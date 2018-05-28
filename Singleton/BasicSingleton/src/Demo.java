import java.io.*;

class Demo {
    static void saveToFile(BasicSingleton basicSingleton,
                           String filename) throws Exception {
        if(basicSingleton == null || filename == null) {
            return;
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);){
            objectOutputStream.writeObject(basicSingleton);
        }
    }

    static BasicSingleton readFile(String filename) throws Exception {
        if(filename == null) {
            return null;
        }

        try(FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            return (BasicSingleton)objectInputStream.readObject();
        }

    }

    public static void main(String[] args) throws Exception{
        BasicSingleton basicSingleton = BasicSingleton.getInstance();
        basicSingleton.setValue(100);

        String filename = "singleton.bin";
        saveToFile(basicSingleton, filename);

        basicSingleton.setValue(300);

        BasicSingleton basicSingleton1 = readFile(filename);

        System.out.println(basicSingleton == basicSingleton1);

        System.out.println("basicSingleton hashcode: " + basicSingleton.hashCode());
        System.out.println("basicSingleton1 hashcode: " + basicSingleton1.hashCode());
        System.out.println("basicSingleton value = " + basicSingleton.getValue());
        System.out.println("basicSingleton1 value = " + basicSingleton1.getValue());
    }
}


class BasicSingleton implements Serializable{
    private static final BasicSingleton basicSingleton = new BasicSingleton();

    private int mValue = 0;

    private BasicSingleton() {}

    public static BasicSingleton getInstance() {
        return  basicSingleton;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }

    /*
     必須要加上readResolve, 這是我們給JVM一個提示，
     即每當序列化的時候，它必須是你原本的實體，而不一個新創的實體。

     此方法是用於替換stream中讀取的物件，確保沒有人可以通過序列化或反序列化來創建另一個實體。
     */
    protected Object readResolve() {
        return basicSingleton;
    }
}
