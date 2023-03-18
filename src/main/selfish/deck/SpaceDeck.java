package selfish.deck;

import java.io.Serializable;

public class SpaceDeck extends Deck implements Serializable
{
    public final static String ASTEROID_FIELD = "Asteroid field";
    public final static String BLANK_SPACE = "Blank space";
    public final static String COSMIC_RADIATION= "Cosmic radiation";
    public final static String GRAVITATIONAL_ANOMALY = "Gravitational anomaly";
    public final static String HYPERSPACE = "Hyperspace";
    public final static String METEOROID = "Meteoroid";
    public final static String MYSTERIOUS_NEBULA = "Mysterious nebula";
    public final static String SOLAR_FLARE = "Solar flare";
    public final static String USEFUL_JUNK = "Useful junk";
    public final static String WORMHOLE = "Wormhole";
    private final static long serialVersionUID = 5;

    public SpaceDeck(){}
    public SpaceDeck(String path){super();}
}