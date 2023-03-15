package selfish.deck;

public class GameDeck extends Deck
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

    public GameDeck()
    {}
    public GameDeck(String path)
    {
        super();
        
    }
    public Oxygen drawOxygen(int value)
    {
        return null;
    }
    public Oxygen[] splitOxygen(Oxygen dbl)
    {
        return null;
    }


}