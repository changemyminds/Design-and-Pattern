import java.util.ArrayList;
import java.util.List;

public class Journal
{
    private final List<String> mEntries = new ArrayList<>();
    private int mCount = 0;

    public void addEntry(String text)
    {
        if(text == null || text.length() == 0)
            return;

        mEntries.add((++mCount) + ":" + text);
    }

    public void removeEntry(int index)
    {
        if(index < 0)
            return;

        mEntries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), mEntries);
    }
}
