package selfish.deck;
import java.io.*;
import java.util.*;
/**
 * This is Card class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class Card implements Serializable, Comparable<Card>
{
    private String name;
    private String description;
    private final static long serialVersionUID = 0;
    /**Empty Constructor
     * No param
     */
    public Card()
    {}
    /**Public constructor for Card
     * @param name Name of the card
     * @param description What the card does
     */
    public Card(String name, String description)
    {
        this.name = name;
        this.description = description.trim();
    }
    /** Public Method to get the function of the specified card
     * @return Returns String value of what the card does
     */
    public String getDescription()
    {
        return description;
    }
    /** Public Method to get the name of the specified card
     * @return Returns String value of name of card
     */
    public String toString()
    {
        return name;
    }
    //@Override
    //public int compareTo(Object o) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    //}
    /** Public Method to Compare 2 cards based on their names
     * @param c Card to be compared
     * @return Returns integer value of comparision
     */
    @Override
    public int compareTo(Card c)
    {
        String c1 = this.name;
        String c2 = c.toString();
        if(c1.compareTo(c2)>0)
        return 1;
        else if(c1.compareTo(c2)<0)
        return -1;
        return 0;
    }
}