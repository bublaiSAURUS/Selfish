package selfish;

import java.util.*;
import java.io.*;
import selfish.deck.Card;
import selfish.deck.Deck;
import selfish.deck.GameDeck;
import selfish.deck.Oxygen;
import selfish.deck.SpaceDeck;
/**
 * This is Game Engine
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class GameEngine implements java.io.Serializable
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

    /**Private Empty Constructor
     * No param
     */
    private GameEngine(){}
    /**Public Constructor 
     * @param seed Long value for Random Object seed
     * @param GameDeck Absolute Path for Game Cards
     * @param SpaceDeck Absolute Path for Space Cards
     */
    public GameEngine(long seed, String GameDeck, String SpaceDeck)
    {
        gameDeck = new GameDeck(GameDeck);
        gameDiscard = new GameDeck(GameDeck);
        spaceDeck = new SpaceDeck(SpaceDeck);
        spaceDiscard = new SpaceDeck(SpaceDeck);
        activePlayers = new ArrayList<Astronaut>();
        random = new Random(seed);
    }
    /**Public Method to add Player
     * @param player Name of player
     * @return Returns the number of active players
     */
    public int addPlayer(String player)
    {
        GameEngine p = new GameEngine();
        Astronaut ob = new Astronaut(player,p);
        activePlayers.add(ob);
        return activePlayers.size();
    }
    /**Public method to end a player's turn
     * @return Returns number of active players
     */
    public int endTurn()
    {
        if(currentPlayer.isAlive())
       {
        
        activePlayers.add(currentPlayer);
       }
        return activePlayers.size();
    }
    /** Public method to check if Game is over
     * @return Returns true/false accordingly
     */
    public boolean gameOver()
    {
        return true;
    }
    /** Public method to get all active players
     * @return Returns a List 
     */
    public List <Astronaut> getAllPlayers()
    {
        List <Astronaut> All = new ArrayList<Astronaut>();
            for(int i = 0 ; i< activePlayers.size(); i++)
            {
                All.add(((List<Astronaut>) activePlayers).get(i));
            }
        return All;
    }
    /** Public Method to get the player with ongoiong turn
     * @return Returns the player
     */
    public Astronaut getCurrentPlayer()
    {
        currentPlayer = ((List<Astronaut>)activePlayers).get(0);
        return currentPlayer;
    }
    /** Public Method to get number of players from the start of game
     * @return Returns total number of all players
     */
    public int getFullPlayerCount()
    {
        return 5;
    }
    /** Public Method to get the game deck
     * @return Returns set of gamecards available
     */
    public GameDeck getGameDeck()
    {return gameDeck;}
    /** Public Method to get discard pile of Game Cards
     * @return Returns a list of cards as discard Pile
     */
    public GameDeck getGameDiscard()
    {return gameDiscard;}
    /** Public Method to get pile of Space Cards
     * @return Returns a list of cards as space pile
     */
    public SpaceDeck getSpaceDeck()
    {return spaceDeck;}
    /**Public Method to get discard pile of Space Cards
     * @return Returns a list of cards as space discard pile
     */
    public SpaceDeck getSpaceDiscard()
    {return spaceDiscard;}
    /** Public Method to get winner name
     * @return Returns player who won
     */
    public Astronaut getWinner()
    {
        return currentPlayer;
    }
    /** Public Method to kill a player
     * @param corpse Player to be killed
     */
    public void killPlayer(Astronaut corpse)
    {

    }
    /** Public Method to load the game
     * @param path String path to get the file to load
     * @return Returns the saved game instance
     */
    public static GameEngine loadState(String path)
    {
        return null;
    }
    /** Public Method to merge two decks
     * @param deck1 Deck 1
     * @param deck2 Deck 2
     */
    public void mergeDecks(Deck deck1, Deck deck2){}
    /** Public Method to save the game
     * @param path File path where it will be saved
     */
    public void saveState(String path)
    {
        try {  
            File file = new File(path);  
            if (file.createNewFile()) 
            {  
              System.out.println("File created: " + file.getName());  
              System.out.println("Absolute path: " + file.getAbsolutePath());  
              FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(f);
                out.writeObject(gameDeck);
                out.writeObject(spaceDeck); 
                out.writeObject(gameDiscard); 
                out.writeObject(spaceDiscard); 
                out.writeObject(random);
                out.writeObject(activePlayers);    
                out.close();
                f.close();
                System.out.println("Object has been serialized");
            } 
            else 
            {  
              System.out.println("File already exists.");  
            }  
          } catch (IOException e) 
          {
            System.out.println("An error occurred.");
            e.printStackTrace();  
          }
        
    }
    /** Public method to split oxygen
     * @param dbl Double oxygen cylinders
     * @return Returns a list of oxygen cards (Single-valued)
     */
    public Oxygen[] splitOxygen(Oxygen dbl){return null;}
    /** Public method to start the game
     * No param
     */
    public void startGame()
    {

    }
    /** Public Method to start turn of current player
     * No param
     */
    public void startTurn()
    {
        System.out.println(getCurrentPlayer().toString()+":");
        //System.out.println(((List<Astronaut>) activePlayers).get(3));
        activePlayers.remove(getCurrentPlayer());
        
    }
    /** Public Method to move player
     * @param traveller Specified player to be moved
     * @return Returns the card in his track 1 unit away
     */
    public Card travel(Astronaut traveller){return null;}
}