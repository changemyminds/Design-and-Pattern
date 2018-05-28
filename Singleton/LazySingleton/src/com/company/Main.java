package com.company;

public class Main {
    public static void main(String[] args) {
	   SingletonThread singletonThread1 = new SingletonThread();
       SingletonThread singletonThread2 = new SingletonThread();
       singletonThread1.start();
       singletonThread2.start();

        try {
            singletonThread1.join(); //等到 singletonThread1的start()結束後，才能執行
            singletonThread2.join(); //等到 singletonThread2的start()結束後，才能執行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(singletonThread1.getSingleton().hashCode());
        System.out.println(singletonThread2.getSingleton().hashCode());

        /* 註： hashCode() 回傳Object 記憶的位址，可以藉由定義(command + b)去看觀看方法
               會發現方法上面是使用JNI再藉由C語言去將記憶體位置讀出來。
         */
    }
}
