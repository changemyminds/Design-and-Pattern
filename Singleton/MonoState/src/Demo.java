public class Demo {
    public static void main(String[] args) {
        MonoState monoState = new MonoState();
        monoState.setNameAngAge("hello", 30);
        System.out.println(monoState);

        MonoState monoState1 = new MonoState();
        System.out.println(monoState1);

        MonoState monoState2 = new MonoState();
        System.out.println(monoState2);

        // 擁有相同的值，但是卻是不同的物件。
        System.out.println(monoState.hashCode());
        System.out.println(monoState1.hashCode());
        System.out.println(monoState2.hashCode());
    }
}

class MonoState {
    private static String name = "";
    private static int age = 0;

    public MonoState(){}


    public void setNameAngAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("MonoState {name: %s, age: %d}", name, age);
    }
}
