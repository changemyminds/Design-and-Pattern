public class SoftwareEngineer implements SohoInterface
{
    private String mProject = "";

    public SoftwareEngineer(String project)
    {
        mProject = project;
    }

    @Override
    public void takeTheCase() {
        System.out.println("接受[" + mProject + "]案件");
    }

    @Override
    public void doSigning() {
        System.out.println("簽約");
    }

    @Override
    public void doWorking() {
        System.out.println("工作中");
    }

    @Override
    public void doClosing() {
        System.out.println("完成[" + mProject + "]案件");
    }

    @Override
    public String getTheCase() {
        return mProject;
    }

}
