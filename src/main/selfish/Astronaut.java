package selfish;
import java.io.*;
//import selfish.deck;
import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

import selfish.deck.Card;
import selfish.deck.Oxygen;
/**
 * This is Astronaut class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class Astronaut implements Serializable
{
    private GameEngine game;
    private List <Card> actions;
    private List <Oxygen> oxygens;
    private String name;
    private Collection <Card> track;
    private final static long serialVersionUID = 5;

    /**Public Constructor for Astronaut 
     * @param name Name of the astronaut 
     * @param game instance of game
     */
    public Astronaut (String name, GameEngine game)
    {
        this.name = name;
        this.game = game;
        actions = new ArrayList<Card>();
        oxygens = new ArrayList<Oxygen>();
        track = new ArrayList<Card>();
    }
    /**Public Method to add card to hand. Combines oxygen and game cards
     * @param card Card that is to be added to hand
     */
    public void addToHand(Card card)
    {
        /**Public Method to add card to hand. Combines oxygen and game cards
        * @param card: Card that is to be added to hand
        */
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
    /**Public method that creates the Path for the astronaut.
     * @param card Returns Card that has to be added as a pathway
     */
    public void addToTrack(Card card)
    {
        track.add(card);
    }
    /**Public method to "breathe" in the game 
     * @return Returns the total qty of oxygen left.
     */
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
                if(isAlive()==false)
                {
                    game.killPlayer(this);
                }
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
            if(isAlive()==false)
            {
                game.killPlayer(this);
            }
            
        }
        return oxygenRemaining();
    }
    /**Public method to get distance from spaceship
     * @return Returns the how far the astronaut is from the spaceship
     */
    public int distanceFromShip()
    {
        return 6-track.size();
    }
    /**Public method for action cards
     * @return Returns list of action cards 
     */
    public List <Card> getActions()
    {
        actions.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        return actions;
    }
    /** Public method for string version of actions
     * @param enumerated if the user wants enumerated actions list
     * @param excludeShields if shields are to be excluded from consideration
     * @return Returns the String value of cards
     */
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
    /** Public method to get the hand of chosen opponent
     * @return Returns a list of cards that opponent is holding in their hands
     */
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
    /** Public method to get string version of above
     * @return Returns String version of hands
     */
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
    /** Public method to get track
     * @return Returns a list of cards representing track
     */
    public Collection <Card> getTrack(){return track;}
    /** p
     * @param card c
     * @throws IllegalArgumentException e
     */
    public void hack(Card card) throws IllegalArgumentException
    {
        if(card == null || (card instanceof Oxygen && !(this.oxygens.contains(card))) || !(this.actions.contains(card)))
        {
            throw new IllegalArgumentException("Error");
        }
        int l = oxygens.size();
        if(actions.contains(card))
        {
            actions.remove(card);
        }
        else
        {
            if(l==1)
            {
                actions.clear();
            }
            oxygens.remove(card);
        }
        if(isAlive()==false)
        {
            game.killPlayer(this);
        }
    }

    /**P
     * @param card C
     * @return r
     * @throws IllegalArgumentException e
     */
    public Card hack(String card) throws IllegalArgumentException
    {
        if (card==null || this.hasCard(card)==0)
        {
            throw new IllegalArgumentException("Error");
        }
        Card c = null; int l = oxygens.size();
        if(card.equals("Oxygen(1)") || card.equals("Oxygen(2)"))
        {
            if(l == 1)
            actions.clear();
            int val = card.charAt(7)-'0';
            for(int i = 0; i < oxygens.size(); i++)
            {
                Oxygen ob = oxygens.get(i);
                if(ob.getValue()==val)
                {
                    c = ob;
                    oxygens.remove(ob);
                    break;
                }
            }
        }
        else
        {
            for(int i = 0; i<actions.size(); i++)
            {
                if(actions.get(i).toString().equals(card))
                {
                    c = actions.get(i);
                    actions.remove(c);
                    break;
                }
            }
        }
        if(isAlive()==false)
        {
            game.killPlayer(this);
        }
        return c;
    }
    /**Public method to check if a card is there 
     * @param Card the card to be checked
     * @return returns the quantity of card if present
     */
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
    /** Public method to check if the solar-flare card is behind the astronaut
     * @return Returns true/false accordingly
     */
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
    /**Public method to check if the current player has won or not
     * @return Returns true/false accordingly
     */
    public boolean hasWon()
    {
        if(distanceFromShip()==0 && isAlive()==true)
        return true;
        return false;
    }
    /** Public method to check if the present player is alive or not
     * @return Retuens boolean true or false accordingly
     */
    public boolean isAlive()
    {
        int l = oxygens.size();
        if(l>0)
        return true;
        return false;
    }

    /** p 
     * @return c
     * @throws IllegalArgumentException e
     */
    public Card laserBlast() throws IllegalArgumentException
    {
        if(distanceFromShip()==6)
        {
            throw new IllegalArgumentException("Error");
        }
        Card c = ((List<Card>) track).get(track.size()-1);
        track.remove(c);
        return c;
    }
    /** Public method to get the total quantity of oxygen remaining
     * @return Returns the total amount of oxygen remaining
     */
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
    /** Public method to get a list of entire track behind the the astronaut
     * @return Returns the list of cards in track
     */
    public Card peekAtTrack()
    {
        if(track.size()>0)
        return ((List<Card>) track).get(track.size()-1);
        return null;
    }
    /** Public method to steal oxygen
     * @return Returns an oxygen card of value 1
     */
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
            if(isAlive()==false)
            {
                game.killPlayer(this);
            }
            return o1;
        }
        Oxygen ox = oxygens.get(index);
        oxygens.remove(ox);
        if(isAlive()==false)
        {
            this.actions = null;
            game.killPlayer(this);
        }
        return ox;
    }
    /** Public method to steal a card from others
     * @return Returns the card to be stolen
     */
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
        if(isAlive()==false)
        {
            game.killPlayer(this);
        }
        return h.get(rand);
    }
    /** Public method to swap the present astronaut with someone else
     * @param swapee Returns the target astronaut to be swapped with
     */
    public void swapTrack(Astronaut swapee)
    {
        Collection<Card> copy = swapee.getTrack();
        swapee.track = this.track;
        this.track = copy;
    } 
    /** Public method to get name of the present astronaut
     * @return Returns the name (accordingly status) of the astronaut
     */
    public String toString()
    {
        if(isAlive()==false)
        return name+" (is dead)";
        return name;
    }
}
