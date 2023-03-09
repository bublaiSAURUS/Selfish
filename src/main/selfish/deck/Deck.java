package selfish.deck;
import java.util.*;

public class Deck
{
    private Collection <Card> cards;
    private final static long serialVersionUID = 5;
    protected Deck(){}
    protected static List <Card> loadCards(String path)
    {
        return null;
    }
    protected static Card[] stringToCards(String str)
    {
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