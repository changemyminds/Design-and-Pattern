import javax.swing.text.StyledEditorKit;
import java.io.*;

public class Store
{
    public boolean saveToFile(String fileName, Journal journal,
                           Boolean isOverWrite)
    {
        File file = new File(fileName);
        if(!file.exists())
        {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        /* java 7 new feature the java.lang.AutoCloseable */
        try(PrintStream printStream = new PrintStream(
                new FileOutputStream(fileName, !isOverWrite)))
        {
            printStream.println(journal.toString());
            return true;
        }
        catch (FileNotFoundException fileEx)
        {
            System.out.println("file not found...");
        }

        return false;
    }
}
