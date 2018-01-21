package item;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class WorkingItemManager
{
    private static Map<String, WorkingItem> registry = new HashMap<String, WorkingItem>();

    private WorkingItemManager()
    { }

    public static synchronized WorkingItem getInstance(String classname)
    {
        WorkingItem workingItem = registry.get(classname);
        if(workingItem != null)
            return workingItem;

        try
        {
            Class<?> aClass = Class.forName(classname);
            Constructor<?> aClassConstructor = aClass.getConstructor();
            workingItem = (WorkingItem)aClassConstructor.newInstance();
        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            //System.out.println(ex.getMessage());
            return null;
        }

        registry.put(classname, workingItem);

        return workingItem;
    }
}
