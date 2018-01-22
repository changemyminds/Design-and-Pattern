public class SohoStore
{
    public SohoInterface askSoho(String species, String project)
    {
        SohoInterface sohoInterface = SohoFactory.createSoho(species, project);
        sohoInterface.takeTheCase();
        sohoInterface.doSigning();
        sohoInterface.doWorking();
        sohoInterface.doClosing();
        return sohoInterface;
    }

}
