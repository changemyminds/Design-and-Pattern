public class Demo extends Thread {
    private InnerStaticSingle mInnerStaticSingle = null;
    private static final int SIZE = 100;

    public static void main(String[] args) throws InterruptedException {
        Demo[] demos = new Demo[SIZE];
        for(int i = 0; i < demos.length; i++) {
            demos[i] = new Demo();
        }

        for(int i = 0; i < demos.length; i++) {
            demos[i].start();
        }

        for(int i = 0; i < demos.length; i++) {
            demos[i].join();
        }

        for(int i = 0; i < demos.length; i++) {
            System.out.println(demos[i].getInnerStaticSingle().hashCode());
        }

    }

    @Override
    public void run() {
        mInnerStaticSingle = InnerStaticSingle.getInstance();
    }

    public InnerStaticSingle getInnerStaticSingle() {
        return mInnerStaticSingle;
    }
}



class InnerStaticSingle {
    private InnerStaticSingle(){}

    private static class InnerStaticSingleHolder{
        private static final InnerStaticSingle innerStaticSingle = new InnerStaticSingle();
    }

    public static InnerStaticSingle getInstance() {
        return InnerStaticSingleHolder.innerStaticSingle;
    }
}