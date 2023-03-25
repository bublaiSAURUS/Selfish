package selfish;
import java.io.*;
//import selfish.deck;
import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

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
        actions.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        return actions;
    }
    public String getActionsStr(boolean enumerated, boolean excludeShields)
    {
        //actions.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        List<Card> act = getActions();
        String cardlist = ""; int p = 0; int index = 65;
        while(p!=act.size())
        {
            String s = act.get(p).toString(); int count = 0;
            for(int j = 0; j<act.size();j++)
            {
                String k = act.get(j).toString();
                if(s.equals(k))
                {
                    count++;
                }
            }
            p = p+count; 
            if(excludeShields == true && s == "Shield")
            continue;
            if(enumerated==false)
            {
                if(count>1)
                {
                    cardlist = cardlist + count +"x"+" "+s+", ";
                }
                else if(count==1)
                cardlist = cardlist+s+", ";
            }
            else
            {            
                    cardlist = cardlist +"["+(char)index+"]"+" "+s+", ";
                    index++;
            }
        }
        if(cardlist.equals(""))
        return cardlist;
        return cardlist.substring(0,cardlist.length()-2);
    } 
    public List <Card> getHand()
    {
        List<Card> hand = new ArrayList<>();
        for(int i = 0; i < oxygens.size(); i++)
        {
            Oxygen ob = oxygens.get(i);
            hand.add(ob);
        }
        for(int i = 0; i < actions.size(); i++)
        {
            Card o = actions.get(i);
            hand.add(o);
        }
        hand.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        return hand;
    }
    public String getHandStr()
    {
        List <Oxygen> o = oxygens;
        o.sort(((o1, o2) -> o1.compareTo(o2)));
        String action = getActionsStr(false, false);
        String oxygen = ""; int count_o2 = 0; int count_o1 = 0;
        for(int i = o.size()-1; i >=0; i--)
        {
            if(o.get(i).toString().equals("Oxygen(2)"))
            {
                count_o2++;
            }
        }
        if(count_o2>1)
        oxygen = oxygen+count_o2+"x "+"Oxygen(2), ";
        else if(count_o2==1)
        oxygen = oxygen+"Oxygen(2), ";
        for(int i = 0; i < o.size(); i++)
        {
            if(o.get(i).toString().equals("Oxygen(1)"))
            {
                count_o1++;
            }
        }
        if(count_o1>1)
        oxygen = oxygen+count_o1+"x "+"Oxygen(1), ";
        else if(count_o1==1)
        oxygen = oxygen+"Oxygen(1), ";
        String hand = oxygen.substring(0,oxygen.length()-2);
        return hand+"; "+action;
    } 
    public Collection <Card> getTrack(){return track;}
    public void hack(Card card)
    {
        String n = card.toString();
        if(n.equals("Oxygen(1)") || n.equals("Oxygen(2)"))
            {
                oxygens.remove(card);
            }
        else
            actions.remove(card);
        if(isAlive()==false)
            this.actions = null;
    }
    public Card hack(String card)
    {
        if(card.equals("Oxygen(1)") || card.equals("Oxygen(2)"))
            {
                for(int i = 0; i <oxygens.size();i++)
                {
                    Oxygen o = oxygens.get(i);
                    if(o.toString().equals(card))
                    {oxygens.remove(o);break;}
                }
            }
        else
            {
                for(int i = 0; i< actions.size(); i++)
                {
                    if(actions.get(i).toString().equals(card))
                    {
                        actions.remove(actions.get(i));
                        break;
                    }
                }
            }
        if(isAlive()==false)
            this.actions = null;
        return null;
    }
    public int hasCard(String Card)
    {
        int qty = 0;
        if(Card.equals("Oxygen(1)") || Card.equals("Oxygen(2)"))
            {
                for(int i = 0; i <oxygens.size();i++)
                {
                    Oxygen o = oxygens.get(i);
                    if(o.toString().equals(Card))
                    {
                        qty++;
                    }
                }
            }
        else
            {
                for(int i = 0; i< actions.size(); i++)
                {
                    if(actions.get(i).toString().equals(Card))
                    {
                        qty++;
                    }
                }
            }
        return qty;
    } 
    public boolean hasMeltedEyeballs()
    {
        Card c = peekAtTrack();
        String check = c.toString();
        if(check.equals("Solar flare"))
        {
            return true;
        }
        return false;
    }
    public boolean hasWon()
    {
        if(distanceFromShip()==0 && isAlive()==true)
        return true;
        return false;
    }
    public boolean isAlive()
    {
        int l = oxygens.size();
        if(l>0)
        return true;
        return false;
    }
    public Card laserBlast()
    {
        Card c = ((List<Card>) track).get(track.size()-1);
        track.remove(c);
        return c;
    }
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
    public Card peekAtTrack()
    {
        if(track.size()>0)
        return ((List<Card>) track).get(track.size()-1);
        return null;
    }
    public Oxygen siphon()
    {
        int count = 0; int index = 0;
        for(int i = 0; i<oxygens.size(); i++)
        {
            if(oxygens.get(i).getValue()==1)
            {
                index = i; break;
            }
            else
            count++;
        }
        if(count == oxygens.size())
        {
            Oxygen o = oxygens.get(0);
            oxygens.remove(o);
            Oxygen o1 = new Oxygen(1);
            oxygens.add(o1);
            return o1;
        }
        Oxygen ox = oxygens.get(index);
        oxygens.remove(ox);
        if(isAlive()==false)
        this.actions = null;
        return ox;
    }
    public Card steal()
    {
        List<Card> h = getHand();
        int max = h.size();
        Random random = new Random();
        //int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
        int rand = random.nextInt(max);
        if(oxygens.contains(h.get(rand)))
        {
            oxygens.remove(h.get(rand));
        }
        else
        {
            actions.remove(h.get(rand));
        }
        return h.get(rand);
    }
    public void swapTrack(Astronaut swapee)
    {
        Collection<Card> copy = swapee.getTrack();
        swapee.track = this.track;
        this.track = copy;
    } 
    public String toString()
    {
        if(isAlive()==false)
        return name+" (is dead)";
        return name;
    }
}
