package item;

import java.util.ArrayList;
import java.util.List;

public abstract class WorkingItem implements WorkerInterface
{
    private final Object OBJECT_LOCK = new Object();
    private final int PROGRESS_LIMIT = 100;

    private boolean mIsStart = false;
    private boolean mIsFinish = false;
    private int mProgress = 0;
    private List<WorkingListener> workingListenerList = new ArrayList<>();

    @Override
    public synchronized void start()
    {
            mIsStart = true;
    }

    @Override
    public void doProgress(int progress, String name)
    {
        if(mIsStart)
        {
            synchronized (OBJECT_LOCK) {
                if(mIsFinish) return;

                if(!name.equals(""))
                {
                    String workerSchedule = String.format("%s worked for %d%%.", name, progress);
                    System.out.println(workerSchedule);
                }

                mProgress = (mProgress + progress > PROGRESS_LIMIT) ? PROGRESS_LIMIT : mProgress + progress;

                if(mProgress == PROGRESS_LIMIT) mIsFinish = true;

                for (WorkingListener workingListener: workingListenerList) {
                    workingListener.onProgress(mProgress);
                }
            }
        }
    }

    @Override
    public void doProgress(int progress) {
        doProgress(progress, "");
    }

    @Override
    public synchronized boolean checkWorkFinish() {
        if(mProgress == PROGRESS_LIMIT)
        {
            mIsStart = false;
            mIsFinish = true;
        }

        return mIsFinish;
    }

    public void registerWorkingListener(WorkingListener workingListener)
    {
        if(workingListenerList.size() == 0)
        {
            synchronized (WorkingItem.class)
            {
                if(workingListenerList.size() == 0)
                {
                    workingListenerList.add(workingListener);
                }
            }
        }
    }

    public void unRegisterWorkingListener(WorkingListener workingListener)
    {
        workingListenerList.remove(workingListener);
    }

    public void unRegisterWorkingListener()
    {
        workingListenerList.clear();
    }

}
