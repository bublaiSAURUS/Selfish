package selfish;
import java.io.*;
//import selfish.deck;
import java.util.*;

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
        return -1;
    }
    public int distanceFromShip()
    {
        return 6;
    }
    public List <Card> getActions(){return null;}
    public String getActionsStr(boolean enumerated, boolean excludeShields)
    {
        return "";
    } 
    public List <Card> getHand(){return null;}
    public String getHandStr()
    {
        return "";
    } 
    public Collection <Card> getTrack(){return track;}
    public void hack(Card card){}
    public Card hack(String card){return null;}
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
    public Card laserBlast(){return null;}
    public int oxygenRemaining()
    {
        return 0;
    }
    public Card peekAtTrack(){return null;}
    public Oxygen siphon(){return null;}
    public Card steal(){return null;}
    public void swapTrack(Astronaut swapee)
    {

    } 
    public String toString()
    {
        return name;
    }
}
