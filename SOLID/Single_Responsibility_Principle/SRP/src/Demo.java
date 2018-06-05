import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
    {
        Journal journal = new Journal();
        journal.addEntry("go to the gym");
        journal.addEntry("play with my dog");
        journal.addEntry("listen the special music");

        Store store = new Store();
        String fileName = "C:\\temp\\Journal.txt";
        if(store.saveToFile(fileName, journal, true))
        {
            try {
                Runtime.getRuntime().exec("notepad.exe " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
