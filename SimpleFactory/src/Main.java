public class Main
{
    public static void main(String[] args)
    {
        SohoStore sohoStore = new SohoStore();
        sohoStore.askSoho("Soft", "ERP");
        System.out.println("------- Happy Dividers -------");
        sohoStore.askSoho("Hard", "Intel Cpu");
        System.out.println("------- Happy Dividers -------");
        sohoStore.askSoho("Firmware", "Usb Driver");
    }


}
