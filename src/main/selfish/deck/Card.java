package selfish.deck;
import java.io.*;
import java.util.*;
public class Card implements Serializable
{
    private String name;
    private String description;
    private final static long serialVersionUID = 0;
    public Card()
    {}
    public Card(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    public String getDescription()
    {
        return description;
    }
    public String toString()
    {
        return name;
    }
}