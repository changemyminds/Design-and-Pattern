package com.company;

public class SingletonThread extends Thread {
    private  Singleton mSingleton = null;

    public SingletonThread()
    {

    }

    public Singleton getSingleton() {
        return mSingleton;
    }

    @Override
    public void run() {
        //mSingleton = Singleton.getInstanceFail();
        //mSingleton = Singleton.getInstanceFail1();
        mSingleton = Singleton.getInstance();
    }
}
