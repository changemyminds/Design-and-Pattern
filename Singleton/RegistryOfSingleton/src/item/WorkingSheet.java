package item;

import java.util.HashMap;
import java.util.Map;

public class WorkingSheet
{
    private static WorkingSheet workingSheet = null;

    private Map<String, String> worktable = new HashMap<String, String>();

    private WorkingSheet()
    {
        String[] workItems = {"Car", "House", "Program"};
        String[] workers = {"CarWorker", "ConstructionWorker", "Coder"};

        if(workers.length == workItems.length)
        {
            for(int i = 0; i < workers.length; i++)
                worktable.put(workItems[i], workers[i]);
        }
    }

    private static WorkingSheet getInstance()
    {
        if(workingSheet == null)
        {
            synchronized (WorkingSheet.class) {
                if(workingSheet == null)
                    workingSheet = new WorkingSheet();
            }
        }

        return workingSheet;
    }

    private String getWorkerName_(String workitem)
    {
        return worktable.get(workitem);
    }

    public static String getWorkerName(String workitem)
    {
        return getInstance().getWorkerName_(workitem);
    }
}
