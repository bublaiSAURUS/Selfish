package selfish;
import java.io.*;
//import selfish.deck;
import java.util.*;

import selfish.deck.Card;
import selfish.deck.Oxygen;
public class Astronaut implements Serializable
{
    private GameEngine game;
    private List <Card> actions;
    private List <Oxygen> oxygens;
    private String name;
    private Collection <Card> track;
    private final static long serialVersionUID = 5;

    public Astronaut (String name, GameEngine game)
    {
        this.name = name;
        this.game = game;
        actions = new ArrayList<Card>();
        oxygens = new ArrayList<Oxygen>();
        track = new ArrayList<Card>();
    }
    public void addToHand(Card card)//
    {
        String n = card.toString();
        if(n.equals("Oxygen(1)") || n.equals("Oxygen(2)"))
        {
            oxygens.add((Oxygen)card);
        }
        else
        {
            actions.add(card);
        }

    }
    public void addToTrack(Card card)//
    {
        track.add(card);
    }
    public int breathe()
    {
        int count = 0;
        for(int i = 0; i<oxygens.size();i++)
        {
            Oxygen ob = oxygens.get(i);
            int v = ob.getValue();
            if(v==1)
            {
                oxygens.remove(ob);
                return oxygenRemaining();
            }
            else
            count++;
        }
        if(count==oxygens.size())
        {
            Oxygen ob = oxygens.get(0);
            oxygens.remove(ob);
            oxygens.add(new Oxygen(1));
        }
        return oxygenRemaining();
    }
    public int distanceFromShip()
    {
        return 6-track.size();
    }
    public List <Card> getActions()
    {
        return actions;
    }
    public String getActionsStr(boolean enumerated, boolean excludeShields)
    {
        actions.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        String cardlist = ""; int p = 0;
        for(int i = 0; i<actions.size(); i++)
        {
            String s = actions.get(i).toString(); int count = 0;
            for(int j = p; j<actions.size();j++)
            {
                String k = actions.get(j).toString();
                if(s.equals(k))
                {
                    count++;
                }
            }
            p = p+count;
            if(count>0 && p!=actions.size())
            {
                cardlist = cardlist + count +"x"+" "+s+", ";
            }
            else if(count==0 && p!=actions.size())
            cardlist = cardlist+s+", ";
            else if(count>0 && p==actions.size())
            {
                cardlist = cardlist + count+"x"+" "+s;
            }
            else if(count==0 && p!=actions.size())
            {
                cardlist = cardlist + s;
            }
        }
        return cardlist;
    } 
    public List <Card> getHand(){return null;}
    public String getHandStr()
    {
        return "";
    } 
    public Collection <Card> getTrack(){return track;}
    public void hack(Card card){}
    public Card hack(String card){return null;}
    public int hasCard(String Card)
    {
        return 1;
    } 
    public boolean hasMeltedEyeballs()
    {
        return false;
    }
    public boolean hasWon()
    {
        return false;
    }
    public boolean isAlive()
    {
        return true;
    }
    public Card laserBlast(){return null;}
    public int oxygenRemaining()
    {
        int val = 0;
        for(int i = 0; i<oxygens.size(); i++)
        {
            Oxygen o = oxygens.get(i);
            val = val+ o.getValue();
        }
        return val;
    }
    public Card peekAtTrack(){return null;}
    public Oxygen siphon(){return null;}
    public Card steal(){return null;}
    public void swapTrack(Astronaut swapee)
    {

    } 
    public String toString()
    {
        return name;
    }
}
