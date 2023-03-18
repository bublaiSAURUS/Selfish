package selfish.deck;
import java.util.*;
import java.io.*;
public class Deck implements Serializable
{
    private Collection <Card> cards;
    private final static long serialVersionUID = 5;
    protected Deck(){}
    protected static List <Card> loadCards(String path)
    {
        List <Card> Cards = new ArrayList<Card>();
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
                String card [] = line.split(";");
                Card c = new Card(card[0],card[1]);
                Cards.add(c);
            }
        }catch (Exception e){}
        return Cards;
    }
    protected static Card[] stringToCards(String str)
    {
        //Card p[] = new Card[5]; Array to be returned.
        return null;
    }
    public int add(Card card)
    {
        return 1;
    }
    protected int add(List <Card> cards)
    {
        return 1;
    }
    public Card draw()
    {
        return null;
    }
    public void remove(Card card)
    {

    }
    public void shuffle(Random random)
    {

    }
    public int size()
    {
        return 1;
    }
}