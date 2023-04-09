package selfish.deck;
import java.util.*;

import selfish.GameException;

import java.io.*;
/**
 * This is Deck class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public abstract class Deck implements Serializable
{
    private Collection <Card> cards;
    private final static long serialVersionUID = 5;
    /** Protected Constructor
     * No param
     */
    protected Deck()
    {
        cards = new ArrayList <Card>();
    }
    
    /** p
     * @param path p
     * @return r
     * @throws GameException e
     */
    protected static List <Card> loadCards(String path) throws GameException
    {
        List <Card> Cards = new ArrayList<>();
        try
        {
            FileReader f = new FileReader(path);
            BufferedReader br = new BufferedReader(f);
            String line = br.readLine();
            while(line!=null)
            {
                line = br.readLine();
                if(line == null)
                {
                    br.close();
                    break;
                }
                Card elements[] = stringToCards(line);
                for(int i = 0; i<elements.length;i++)
                {
                    Cards.add(elements[i]);
                }
            }
        }catch (Exception e)
        {
            throw new GameException("error", new FileNotFoundException());
        }
        return Cards;
    }
    /** Protected class to get an array of Cards
     * @param str Card as string
     * @return Returns an array of Cards
     */
    protected static Card[] stringToCards(String str)
    {
        //Card p[] = new Card[5]; Array to be returned.
        String ref [] = str.split(";");
        String l = ref[2].trim();
        Card p[] = new Card[Integer.parseInt(l)];
        for(int i = 0 ; i<p.length; i++)
        {
            Card c = new Card(ref[0],ref[1]);
            p[i] = c;
        }
        return p;
    }
    /**protected method
     * @param cards list of cards to be added
     * @return size of cards
     */
    protected int add(List <Card> cards)
    {
        for(Card c: cards)
        {
            this.cards.add(c);
        }
        return this.cards.size();
    }
    /**public method
     * @param card card to be added
     * @return size of cards
     */
    public int add(Card card)
    {
        cards.add(card);
        return cards.size();
    }

    /**p
     * @return r
     */
    public Card draw()
    {
        if(cards.size()==0)
        {
            throw new IllegalStateException("Empty Deck");
        }
        List <Card> copy = (List <Card>) cards;
        Card c = copy.get(cards.size()-1);
        cards.remove(c);
        return c;
    }
    /** Public method to remove the specified card
     * @param card Card to be removed
     */
    public void remove(Card card)
    {
        if(cards.contains(card))
        {
            cards.remove(card);
        }
    }
    /** Public method to suffle cards
     * @param random Random object for shuffling cards
     */
    public void shuffle(Random random)
    {
        Collections.shuffle((List <Card>) cards, random);
    }
    /** Public method to get size
     * @return Returns an integer value
     */
    public int size()
    {
        return cards.size();
    }
}