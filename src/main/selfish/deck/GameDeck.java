package selfish.deck;
import java.util.*;
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
    public GameDeck(String path)
    {
        super();
        List <Card> a = loadCards(path);
        add(a);
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