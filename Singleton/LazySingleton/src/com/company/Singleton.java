package com.company;


public class Singleton
{
    /* 確保只有唯一一個Singleton */
    private static Singleton singleton = null;

    /**
     * 需將就建構子設定為private，藉由getInstance()來做使用，確保唯一性。
     */
    private Singleton()
    { }

    /**
     *
     * @return 回傳的值，可能不唯一，因為Muti-Thread的關係，會造成Thread-safe的問題。
     */
    public static Singleton getInstanceFail()
    {
        if(singleton == null)
        {
            singleton = new Singleton();
        }

        return singleton;
    }

    /**
     *
     * @return 回傳的值，可能不唯一，因為synchronized之後並沒有在做判斷，Double Checked Locking。
     */
    public static Singleton getInstanceFail1()
    {
        if(singleton == null)
        {
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }

        return singleton;
    }

    /**
     *
     * @return 回傳的值，是唯一的此方法稱為Double Checked Locking，但效能會差一點。
     */
    public static Singleton getInstance() {
        if(singleton == null)
        {
            synchronized (Singleton.class){
                if(singleton == null)
                    singleton = new Singleton();
            }
        }

        return singleton;
    }

    /**
     *
     * @return 回傳的值是唯一的，缺點是效能較差。
     */
    public static synchronized Singleton getInstance1() {
        if(singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

}
