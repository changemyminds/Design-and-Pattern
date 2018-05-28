package worker;

public class Worker
{
    private String mName = "";
    private int mAge = 0;
    private String mWorkProject = "";

    public Worker(String name)
    {
        mName = name;
        mAge = 0;
    }

    public Worker(String name, int age)
    {
        mName = name;
        mAge = age;
    }

    public void setWorkProject(String workProject)
    {
        mWorkProject = workProject;
    }

    public String getName()
    {
        return mName;
    }

    public int getAge()
    {
        return mAge;
    }

    public String getWorkProject()
    {
        return mWorkProject;
    }

}
