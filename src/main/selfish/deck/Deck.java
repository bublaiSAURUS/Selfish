package selfish.deck;
import java.util.*;
import java.io.*;
public abstract class Deck implements Serializable
{
    private Collection <Card> cards;
    private final static long serialVersionUID = 5;
    protected Deck(){}
    protected static List <Card> loadCards(String path)
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
        }catch (Exception e){}
        return Cards;
    }
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