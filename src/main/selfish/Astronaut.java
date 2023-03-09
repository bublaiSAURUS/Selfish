package selfish;
//import selfish.deck;
import java.util.*;
public class Astronaut 
{
    private GameEngine game;
    //private List <Card> actions;
    //private List <Oxygen> oxygens;
    private String name;
    //private Collection <Card> track;
    private final static long serialVersionUID = 5;

    public Astronaut (String name, GameEngine game)
    {

    }
    public void addToHand()//Card card
    {

    }
    public void addToTrack()//Card card
    {

    }
    public int breathe()
    {
        return -1;
    }
    public int distanceFromShip()
    {
        return 6;
    }
    // public List <Card> getActions(){return null;}
    public String getActionsStr(boolean enumerated, boolean excludeShields)
    {
        return "";
    } 
    // public List <Card> getHand(){return null;}
    public String getHandStr()
    {
        return "";
    } 
    // public Collection <Card> getTrack(){}
    // public void hack(Card card){}
    // public Card hack(String card){}
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
    //public Card laserBlast(){return null;}
    public int oxygenRemaining()
    {
        return 0;
    }
    //public Card peekAtTrack(){return null;}
    //public Oxygen siphon(){return null;}
    //public Card steal(){return null;}
    public void swapTrack(Astronaut swapee)
    {

    } 
    public String toString()
    {
        return "";
    }
}
