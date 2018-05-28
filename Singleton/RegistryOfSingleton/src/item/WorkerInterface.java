package item;

public interface WorkerInterface
{
    public void start();
    public void doProgress(int progress);
    public void doProgress(int progress, String name);
    public boolean checkWorkFinish();
}
