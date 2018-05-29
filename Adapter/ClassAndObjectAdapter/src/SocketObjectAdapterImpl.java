public class SocketObjectAdapterImpl implements ISocketAdapter {
    private Socket mSocket;

    public SocketObjectAdapterImpl(Socket socket) {
        mSocket = socket;
    }


    @Override
    public Volt get120Volt() {
        return mSocket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(mSocket.getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(mSocket.getVolt(), 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}
