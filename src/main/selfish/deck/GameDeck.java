package selfish.deck;

import java.io.Serializable;
/**
 * This is GameDeck class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class GameDeck extends Deck implements Serializable
{
    public final static String HACK_SUIT = "Hack suit";
    public final static String HOLE_IN_SUIT = "Hole in suit";
    public final static String LASER_BLAST= "Laser Blast";
    public final static String OXYGEN = "Oxygen";
    public final static String OXYGEN_1 = "Oxygen(1)";
    public final static String OXYGEN_2 = "Oxygen(2)";
    public final static String OXYGEN_SIPHON = "Oxygen siphon";
    public final static String ROCKET_BOOSTER = "Rocket booster";
    public final static String SHIELD = "Shield";
    public final static String TETHER = "Tether";
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
    public GameDeck(String path)
    {
        super();
        
    }
    /** Public method to draw Oxygen cards
     * @param value Value of Oxygen card to be drawn
     * @return Returns the Oxygen Card drawn
     */
    public Oxygen drawOxygen(int value)
    {
        return null;
    }
    /** Public method to split Oxygen
     * @param dbl Oxygen Card of double value
     * @return Returns a list of single valued oxygen
     */
    public Oxygen[] splitOxygen(Oxygen dbl)
    {
        return null;
    }


}