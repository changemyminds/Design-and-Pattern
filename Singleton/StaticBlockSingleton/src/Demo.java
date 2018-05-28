public class Demo implements Runnable{
    StaticBlockSingleton mStaticBlockSingleton;

    private static final int SIZE = 50;

    public static void main(String[] args) {
        Demo[] demos = new Demo[SIZE];
        Thread[] threads = new Thread[SIZE];
        for(int i = 0; i < demos.length; i++) {
            demos[i] = new Demo();
            threads[i] = new Thread(demos[i]);
        }

        for(int i = 0; i < demos.length; i++) {
            threads[i].start();
        }

        try {
            for(int i = 0; i < demos.length; i++) {
                threads[i].join();
            }
        } catch (Exception ex) {

        }

        for(int i = 0; i < demos.length; i++) {
            System.out.println(demos[i].getStaticBlockSingleton().hashCode());
        }
    }

    @Override
    public void run() {
        mStaticBlockSingleton = StaticBlockSingleton.getInstance();
    }

    private StaticBlockSingleton getStaticBlockSingleton() {
        return mStaticBlockSingleton;
    }
}

class StaticBlockSingleton {
    private static StaticBlockSingleton staticBlockSingleton;

    /*
     使用Static Initializer或稱為Class Initializer，此方法跟建構子很像，
     它的功能在於初始化類別，當類別初次被使用、被載入至JVM時，會執行static block裡面的程式碼。
    */
    static {
        System.out.println("Static Initializer");
        staticBlockSingleton = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() { System.out.println("StaticBlockSingleton Construct");}


    public static StaticBlockSingleton getInstance(){
        return staticBlockSingleton;
    }

}
