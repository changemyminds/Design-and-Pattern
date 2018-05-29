/*
題目：
使用Class Adapter 和 Object Adapter來執行。
原本有一個插頭他只提供120V的電壓，現在要將這個插頭也可以提供3V、12V、120V的電壓，該怎麼辦？

解決辦法：
創建一個ISocketAdapter插頭的轉接器(介面)，這個轉接器提供了3V、12V、120V的電壓，然後讓原本的Socket插頭去
繼承或實作這個介面，來達到提供3V、12V、120V的電壓，以後萬一需要220V的電壓，只需要在實作ISocketAdapter或實作
其他介面及可以。

Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.
Object Adapter – This form uses Java Composition and adapter contains the source object.

 */


public class Demo {
    public static void main(String[] args){
        objectAdapter();
        classAdapter();

    }

    public static void objectAdapter() {
        Socket socket = new Socket();
        ISocketAdapter socketImpl = new SocketObjectAdapterImpl(socket);

        System.out.println("3V object adapter = " + getVolt(socketImpl, 3) + "V");
        System.out.println("12V object adapter = " + getVolt(socketImpl, 12) + "V");
        System.out.println("120V object adapter = " + getVolt(socketImpl, 120) + "V");
    }

    public static void classAdapter() {
        ISocketAdapter socketImpl = new SocketClassAdapterImpl();

        System.out.println("3V class adapter = " + getVolt(socketImpl, 3) + "V");
        System.out.println("12V class adapter = " + getVolt(socketImpl, 12) + "V");
        System.out.println("120V class adapter = " + getVolt(socketImpl, 120) + "V");
    }

    private static int getVolt(ISocketAdapter iSocketAdapter, int volt) {
        switch (volt) {
            case 3:   return iSocketAdapter.get3Volt().getVolts();
            case 12:  return iSocketAdapter.get12Volt().getVolts();
            case 120:
            default:  return iSocketAdapter.get120Volt().getVolts();
        }
    }

}