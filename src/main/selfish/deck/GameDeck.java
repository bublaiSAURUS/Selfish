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
    
    /**p
     * @param path p
     * @throws Exception e
     */
    public GameDeck(String path) throws Exception
    {
        try{super.add(loadCards(path));
        for(int i = 1; i <=10; i++)
        {
            super.add(new Oxygen(2));
        }
        for(int i = 1; i<=38 ; i++)
        {
            super.add(new Oxygen(1));
        }}catch(Exception e)
        {
            throw new GameException("Error", new FileNotFoundException());
        }
    }
    /** Public
     * @param value c
     * @return d
     * @throws IllegalStateException e
     */
    public Oxygen drawOxygen(int value) throws IllegalStateException
    {
        int l = size();
        Card c = null;
        List <Card> mana = new ArrayList<>();
        try{do
        {
           Card p = draw();String n = p.toString();
            if(value==1 && n.equals("Oxygen(1)"))
            {
                c = p;
                if(mana.size()>0)
                {
                    Collections.reverse(mana);
                    super.add(mana);
                }
                break;
            }
            else if(value==2 && n.equals("Oxygen(2)"))
            {
                c = p;
                if(mana.size()>0)
                {
                    Collections.reverse(mana);
                    super.add(mana);
                }
                break;
            }
            else
            mana.add(p);
        }while(mana.size() != l);}catch(Exception e)
        {
            throw new IllegalStateException("Error");
        }
        if(c==null)
        {
            Collections.reverse(mana);
            super.add(mana);
            throw new IllegalStateException("Error");
        }
        return (Oxygen)c; 
    }
    /** Public method to split Oxygen
     * @param dbl Oxygen Card of double value
     * @return Returns a list of single valued oxygen
     */
    public Oxygen[] splitOxygen(Oxygen dbl)
    {
        if(dbl.getValue()==1)
        {
            throw new IllegalArgumentException();
        }
        Oxygen o[] = new Oxygen[2];
        try{Oxygen o1 = drawOxygen(1);
        Oxygen o2 = drawOxygen(1);
        o[0] = o2;
        o[1] = o1;
        }catch(Exception e)
        {
            throw new IllegalStateException("Error");
        }
        super.add(dbl);
        return o;
    }


}