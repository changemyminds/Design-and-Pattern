import item.WorkingSheet;
import worker.Worker;

public class WorkerManager
{
    private Worker[] mWorkers = null;
    private Thread[] mThread = null;
    private int mWorkerCount = 0;
    private String mWorkingItemName = "";
    private boolean isApply = false;

    public WorkerManager(String workingItemName, int workerCount)
    {
        mWorkingItemName = workingItemName;
        mWorkerCount = workerCount;
        mWorkers = new Worker[mWorkerCount];
        mThread = new Thread[mWorkerCount];

        init();
    }

    private void init()
    {
        if(mWorkingItemName.equals("") || mWorkerCount == 0)
        {
            isApply = false;
            return;
        }

        for(int i = 0; i < mWorkerCount; i++)
        {
            if(WorkingSheet.getWorkerName(mWorkingItemName) == null || WorkingSheet.getWorkerName(mWorkingItemName).equals(""))
            {
                isApply = false;
                return;
            }

            String workerName = WorkingSheet.getWorkerName(mWorkingItemName) + (char)(i + 65);
            mWorkers[i] = new Worker(workerName);
            mWorkers[i].setWorkProject(mWorkingItemName);

            mThread[i] = new Thread(new WorkerThread(mWorkers[i]));
            mThread[i].setName(mWorkers[i].getName());
        }

        isApply = true;
    }

    public boolean isApplySuccess()
    {
        return isApply;
    }

    public void doWorking()
    {
        if(!isApply) return;

        for(int i = 0; i < mWorkerCount; i++)
        {
            System.out.println(mThread[i].getName() + " start work !");
            mThread[i].start();
        }
    }

    public String getWorkingItemName()
    {
        return  mWorkingItemName;
    }
}
