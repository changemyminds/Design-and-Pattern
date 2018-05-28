import item.WorkingItem;
import item.WorkingItemManager;
import item.WorkingListener;
import worker.Worker;

import java.util.Random;

public class WorkerThread implements Runnable
{
    private final String WORKER_PATH = "item.";
    private final int RANDOM_NUMBER = 3;
    private final int DELAY_TIME_MILLIS = 10;

    private String mWorkingProject = "";
    private String mWorkerName = "";

    public WorkerThread(Worker worker)
    {
        mWorkingProject = WORKER_PATH + worker.getWorkProject();
        mWorkerName = worker.getName();
    }

    public WorkerThread(String workingProject, String workerName)
    {
        mWorkingProject = WORKER_PATH + workingProject;
        mWorkerName = workerName;
    }

    @Override
    public void run() {
        WorkingItem mWorkingItem = WorkingItemManager.getInstance(mWorkingProject);
        if(mWorkingItem == null)
        {
            String error = String.format("%s get working project fail.", mWorkerName);
            System.out.println(error);
            return;
        }

        mWorkingItem.registerWorkingListener(new WorkingListener() {
            @Override
            public void onProgress(int progress) {
                System.out.println("Progress = " + progress + "%");
            }
        });

        System.out.println(mWorkerName + " address = " + mWorkingItem.hashCode());
        mWorkingItem.start();

        while (!mWorkingItem.checkWorkFinish())
        {
            Random ran = new Random();
            int progress = ran.nextInt(RANDOM_NUMBER) + 1;
            mWorkingItem.doProgress(progress, mWorkerName);

            try {
                Thread.sleep(DELAY_TIME_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
