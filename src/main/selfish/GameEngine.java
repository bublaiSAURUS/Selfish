package selfish;

import java.util.*;

import selfish.deck.Card;
import selfish.deck.Deck;
import selfish.deck.GameDeck;
import selfish.deck.Oxygen;
import selfish.deck.SpaceDeck;

public class GameEngine
{
    private Collection <Astronaut> activePlayers;
    private boolean hasStarted;
    private List <Astronaut> corpses;   
    private Astronaut currentPlayer;
    private Random random;
    private GameDeck gameDeck;
    private GameDeck gameDiscard;
    private SpaceDeck spaceDeck;
    private SpaceDeck spaceDiscard;
    private final static long serialVersionUID=5;

    private GameEngine(){}
    public GameEngine(long seed, String GameDeck, String SpaceDeck)
    {
        activePlayers = new ArrayList<>();
    }
    public int addPlayer(String player)
    {
        GameEngine p = new GameEngine();
        Astronaut ob = new Astronaut(player,p);
        activePlayers.add(ob);
        return activePlayers.size();
    }
    public int endTurn()
    {
        return 1;
    }
    public boolean gameOver()
    {
        return true;
    }
    public List <Astronaut> getAllplayers()
    {
        List <Astronaut> All = new ArrayList<>();
            for(int i = 0 ; i< activePlayers.size(); i++)
            {
                All.add(((List<Astronaut>) activePlayers).get(i));
            }
        return All;
    }
    public Astronaut getCurrentPlayer()
    {
        return currentPlayer;
    }
    public int getFullPlayerCount()
    {
        return 5;
    }
    public GameDeck getGameDeck(){return gameDeck;}
    public GameDeck getGameDiscard(){return gameDiscard;}
    public SpaceDeck getSpaceDeck(){return spaceDeck;}
    public SpaceDeck getSpaceDiscard(){return spaceDiscard;}
    public Astronaut getWinner()
    {
        return currentPlayer;
    }
    public void killPlayer(Astronaut corpse)
    {

    }
    public static GameEngine loadState(String path)
    {
        return null;
    }
    public void mergeDecks(Deck deck1, Deck deck2){}
    public void saveState(String path)
    {

    }
    public Oxygen[] splitOxygen(Oxygen dbl){return null;}
    public void startGame()
    {

    }
    public void startTurn()
    {

    }
    public Card travel(Astronaut traveller){return null;}
}