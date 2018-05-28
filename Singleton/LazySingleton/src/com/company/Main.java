package com.company;

public class Main {
    public static void main(String[] args) {
        SingletonThread[] singletonThreads = new SingletonThread[100];
        for (int i = 0; i < singletonThreads.length; i++) {
            singletonThreads[i] = new SingletonThread();
        }

        for (int i = 0; i < singletonThreads.length; i++) {
            singletonThreads[i].start();
        }

        try {
            for (int i = 0; i < singletonThreads.length; i++) {
                singletonThreads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < singletonThreads.length; i++) {
            System.out.println(singletonThreads[i].getSingleton().hashCode());
        }

        /* 註： hashCode() 回傳Object 記憶的位址，可以藉由定義(command + b)去看觀看方法
               會發現方法上面是使用JNI再藉由C語言去將記憶體位置讀出來。
         */
    }
}
