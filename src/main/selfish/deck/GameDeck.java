package selfish.deck;
import java.util.*;

import selfish.GameException;

import java.io.FileNotFoundException;
import java.io.Serializable;
/**
 * This is GameDeck class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class GameDeck extends Deck implements Serializable
{
    /** Public final card 
     * Represents Hack suit Card
     */
    public final static String HACK_SUIT = "Hack suit";
    /** Public final card
     * Represents Hole in suit card
     */
    public final static String HOLE_IN_SUIT = "Hole in suit";
    /** Public final card
     * Represents Laser Blast card
     */
    public final static String LASER_BLAST= "Laser Blast";
    /** Public final card
     * Represents oxygen
     */
    public final static String OXYGEN = "Oxygen";
    /** Public final card
     * Represents Oxygen 1 card
     */
    public final static String OXYGEN_1 = "Oxygen(1)";
    /** Public final card
     * Represents Oxygen 2 card
     */
    public final static String OXYGEN_2 = "Oxygen(2)";
    /** Public final card
     * Represents Oxygen siphon card
     */
    public final static String OXYGEN_SIPHON = "Oxygen siphon";
    /** Public final card
     * Represents Rocket booster card
     */
    public final static String ROCKET_BOOSTER = "Rocket booster";
    /** Public final card
     * Represents Shield card
     */
    public final static String SHIELD = "Shield";
    /** Public final card
     * Represents Tether card
     */
    public final static String TETHER = "Tether";
    /** Public final card
     * Represents Tractor beam card
     */
    public final static String TRACTOR_BEAM = "Tractor beam";
    private final static long serialVersionUID = 5;

    /**Public constructor
     * No param
     */
    public GameDeck()
    {}
    /** Public constructor
     * @param path Path of file with game cards
     */
    public GameDeck(String path) throws GameException
    {
        try
        {
            super.add(loadCards(path));
        }catch(Exception e)
        {
            throw new GameException("File path invalid", new FileNotFoundException());
        }
        for(int i = 1; i <=10; i++)
        {
            super.add(new Oxygen(2));
        }
        for(int i = 1; i<=38 ; i++)
        {
            super.add(new Oxygen(1));
        }
    }
    /** Public method to draw Oxygen cards
     * @param value Value of Oxygen card to be drawn
     * @return Returns the Oxygen Card drawn
     */
    public Oxygen drawOxygen(int value) throws IllegalStateException
    {
        if(this.size()==0)
        {
            throw new IllegalStateException("Not possible", null);
        }
        int l = this.size();
        List <Card> mana = new ArrayList<>();
        boolean check = false; Card c = null;
        do
        {
            c = draw();String n = c.toString();
            if(value==1 && n.equals("Oxygen(1)"))
            {
                check = true;
                if(mana.size()>0)
                {
                    Collections.reverse(mana);
                    super.add(mana);
                }
                return (Oxygen)c; 
            }
            else if(value==2 && n.equals("Oxygen(2)"))
            {
                check = true;
                if(mana.size()>0)
                {
                    Collections.reverse(mana);
                    super.add(mana);
                }
                return (Oxygen)c;
            }
            else
            mana.add(c);
        }while(check != true && mana.size()!=l);
        if(c==null)
        {
            super.add(mana);
            throw new IllegalStateException("Not available", null);
        }
        return (Oxygen) c;
    }
    /** Public method to split Oxygen
     * @param dbl Oxygen Card of double value
     * @return Returns a list of single valued oxygen
     */
    public Oxygen[] splitOxygen(Oxygen dbl) throws IllegalArgumentException
    {
        if(dbl.getValue()==1)
        {
            throw new IllegalArgumentException("NOT possible", null);
        }
        Oxygen o1 = drawOxygen(1);
        Oxygen o2 = drawOxygen(1);
        if(o1==null || o2==null)
        {
            throw new IllegalArgumentException("Not enough Oxygen", null);
        }
        Oxygen o[] = {o2, o1};
        super.add(dbl);
        return o;
    }
}