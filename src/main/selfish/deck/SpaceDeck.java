package selfish.deck;

import java.io.Serializable;
/**
 * This is SpaceDeck class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class SpaceDeck extends Deck implements Serializable
{
    /** Public final card
     * Represents Asteroid field card
     */
    public final static String ASTEROID_FIELD = "Asteroid field";
    /** Public final card
     * Represents Blank space card
     */
    public final static String BLANK_SPACE = "Blank space";
    /** Public final card
     * Represents Cosmic radiation card
     */
    public final static String COSMIC_RADIATION= "Cosmic radiation";
    /** Public final card
     * Represents Gravitational anomaly card
     */
    public final static String GRAVITATIONAL_ANOMALY = "Gravitational anomaly";
    /** Public final card
     * Represents Hyperspace card
     */
    public final static String HYPERSPACE = "Hyperspace";
    /** Public final card
     * Represents Meteoroid card
     */
    public final static String METEOROID = "Meteoroid";
    /** Public final card
     * Represents Mysterious nebula card
     */
    public final static String MYSTERIOUS_NEBULA = "Mysterious nebula";
    /** Public final card
     * Represents Solar flare card
     */
    public final static String SOLAR_FLARE = "Solar flare";
    /** Public final card
     * Represents Useful junk card
     */
    public final static String USEFUL_JUNK = "Useful junk";
    /** Public final card
     *Represents Wormhole card
     */
    public final static String WORMHOLE = "Wormhole";
    private final static long serialVersionUID = 5;

    /**Public Constructor
     * No param
     */
    public SpaceDeck(){}
    /**Public Constructor
     * @param path File path for Space Cards
     */
    public SpaceDeck(String path){super();}
}