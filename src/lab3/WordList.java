package lab3;
import java.util.*;

public class WordList 
{
    private final List<String> words;
    private final Random random;
    
    public WordList(int size)
    {
        words = new ArrayList<>(size);
        random = new Random();
    }
    
    public boolean isEmpty()
    {
        return words.isEmpty();
    }
    
    public void add(String word)
    {
        words.add(word);
    }
    
    public String selectAny()
    {
        return words.get(random.nextInt(words.size()));
    }
    
    public String remove(String word)
    {
        if(words.remove(word))
        {
            return word;
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        Iterator<String> iterator = words.listIterator();
        while(iterator.hasNext())
        {
            result.append(iterator.next());
            result.append("/n");
        }
        return result.toString();
    }
    
}
