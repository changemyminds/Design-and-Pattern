public class SohoFactory
{
    public static SohoInterface createSoho(String species, String project)
    {
        return create(species, project);
    }

    public static SohoInterface createSoho(String species)
    {
        return create(species, "");
    }

    private static SohoInterface create(String species, String project)
    {
        SohoInterface sohoInterface = null;
        switch (species)
        {
            case "Soft":
                sohoInterface = new SoftwareEngineer(project);
                break;
            case "Hard":
                sohoInterface = new HardwareEngineer(project);
                break;
            case "Firmware":
                sohoInterface = new FirmwareEngineer(project);
                break;
        }

        return sohoInterface;
    }

}
