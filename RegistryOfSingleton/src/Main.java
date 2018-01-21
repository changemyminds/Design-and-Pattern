public class Main {
    public static void main(String[] args)
    {
        //WorkerManager workerManager = new WorkerManager("Car", 10);
        WorkerManager workerManager = new WorkerManager("House", 10);
        //WorkerManager workerManager = new WorkerManager("Program", 10);
        boolean isApply = workerManager.isApplySuccess();
        System.out.println(workerManager.getWorkingItemName() + ((isApply) ? " Apply Success" : "Apply Fail"));
        if(isApply)  workerManager.doWorking();
    }
}
