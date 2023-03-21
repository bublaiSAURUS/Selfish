package selfish.deck;
import java.io.*;
import java.util.*;
public class Card implements Serializable, Comparable<Card>
{
    private String name;
    private String description;
    private final static long serialVersionUID = 0;
    public Card()
    {}
    public Card(String name, String description)
    {
        this.name = name;
        this.description = description.trim();
    }
    public String getDescription()
    {
        return description;
    }
    public String toString()
    {
        return name;
    }
    @Override
    public int compareTo(Card o) {
        // TODO Auto-generated method stub
        String s1 = o.toString();
        String s2 = name.trim();
        return s2.compareTo(s1);
        //throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}