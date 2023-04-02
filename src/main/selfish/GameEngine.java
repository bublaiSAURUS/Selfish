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
    private GameEngine()
    {
        activePlayers = new ArrayList<Astronaut>();
        corpses = new ArrayList<Astronaut>();
    }
    /**Public Constructor 
     * @param seed Long value for Random Object seed
     * @param GameDeck Absolute Path for Game Cards
     * @param SpaceDeck Absolute Path for Space Cards
     */
    public GameEngine(long seed, String GameDeck, String SpaceDeck)
    {
        gameDeck = new GameDeck(GameDeck);
        gameDiscard = new GameDeck();
        spaceDeck = new SpaceDeck(SpaceDeck);
        spaceDiscard = new SpaceDeck();
        activePlayers = new ArrayList<Astronaut>();
        corpses = new ArrayList<Astronaut>();
        random = new Random(seed);
        gameDeck.shuffle(random);
        spaceDeck.shuffle(random);
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
       else
       {
        killPlayer(currentPlayer);
       }
        currentPlayer = null;
        return activePlayers.size();
    }
    /** Public method to check if Game is over
     * @return Returns true/false accordingly
     */
    public boolean gameOver()
    {
        if(getFullPlayerCount()==corpses.size())
        return true;
        else if(getWinner()!=null)
        return true;
        return false;
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
            for(int i = 0; i<corpses.size(); i++)
            {
                All.add(corpses.get(i));
            }
            if(currentPlayer!=null && All.contains(currentPlayer)==false)
            All.add(currentPlayer);
        return All;
    }
    /** Public Method to get the player with ongoiong turn
     * @return Returns the player
     */
    public Astronaut getCurrentPlayer()
    {
        return currentPlayer;
    }
    /** Public Method to get number of players from the start of game
     * @return Returns total number of all players
     */
    public int getFullPlayerCount()
    {
        List<Astronaut> full = getAllPlayers();
        return full.size();
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
        List <Astronaut> checklist = getAllPlayers();
        for(int i = 0; i<checklist.size(); i++)
        {
            if(checklist.get(i).isAlive()==true)
            {
                if(checklist.get(i).distanceFromShip()==0)
                return(checklist.get(i));
            }
        }
        return null;
    }
    /** Public Method to kill a player
     * @param corpse Player to be killed
     */
    public void killPlayer(Astronaut corpse)
    {
        corpses.add(corpse);
        activePlayers.remove(corpse);
    }
    /** Public Method to load the game
     * @param path String path to get the file to load
     * @return Returns the saved game instance
     */
    public static GameEngine loadState(String path)
    {
        try
        {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            GameEngine LoadedGame = (GameEngine) in.readObject();
            in.close();
            file.close();
            return LoadedGame;
        }catch (Exception e) 
        {
          System.out.println("An error occurred.");
          e.printStackTrace();  
        }

        return null;
    }
    /** Public Method to merge two decks
     * @param deck1 Deck 1
     * @param deck2 Deck 2
     */
    public void mergeDecks(Deck deck1, Deck deck2)
    {
        if(deck1.size() == 0)
        {
            while(deck2.size()!=0)
            {
                Card c = deck2.draw();
                deck1.add(c);
            }
        }
        else
        {
            while(deck2.size()!=0)
            {
                Card c = deck2.draw();
                deck1.add(c);
            }   
        }
    }
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
                //out.writeObject(gameDeck);
                //out.writeObject(spaceDeck); 
                //out.writeObject(gameDiscard); 
                //out.writeObject(spaceDiscard); 
                //out.writeObject(random);
                //out.writeObject(activePlayers);
                //out.writeObject(corpses);
                //out.writeObject(currentPlayer);
                //out.writeObject(hasStarted);
                out.writeObject(this);   
                out.close();
                f.close();
                System.out.println("Object has been serialized");
            } 
            else 
            {  
                System.out.println("File already exists.");
                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(f);
                //out.writeObject(gameDeck);
                //out.writeObject(spaceDeck); 
                //out.writeObject(gameDiscard); 
                //out.writeObject(spaceDiscard); 
                //out.writeObject(random);
                //out.writeObject(activePlayers);
                //out.writeObject(corpses);
                //out.writeObject(currentPlayer);
                //out.writeObject(hasStarted);
                out.writeObject(this);   
                out.close();
                f.close();
                System.out.println("Object has been serialized");  
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
    public Oxygen[] splitOxygen(Oxygen dbl)
    {
        Oxygen o[] = new Oxygen[2];
        if(getGameDeck().size()==0)
        {
            Oxygen hold[] = getGameDiscard().splitOxygen(dbl);
            o[0] = hold[0];
            o[1] = hold[1];
        }
        else if(getGameDiscard().size()==0)
        {
            Oxygen hold[] = getGameDeck().splitOxygen(dbl);
            o[0] = hold[0];
            o[1] = hold[1];
        }
        else if(getGameDeck().size()==1 && getGameDiscard().size()==1)
        {
            Oxygen hold1 = (Oxygen)getGameDeck().draw();
            Oxygen hold2 = (Oxygen)getGameDiscard().draw();
            o[0] = hold1;
            o[1] = hold2;
            getGameDeck().add(dbl);
        }
        else if(getGameDeck().size()==1 && getGameDiscard().size()>=2)
        {
            Card hold1 = getGameDeck().draw();
            if(hold1.toString().equals("Oxygen(1)"))
            {
                o[0] = (Oxygen)hold1;
                o[1] =  getGameDiscard().drawOxygen(1);
            }
            else
            {   getGameDeck().add(hold1);
                o[0] = getGameDiscard().drawOxygen(1);
                o[1] = getGameDiscard().drawOxygen(1);
            }
            getGameDeck().add(dbl);
        }
        else if(getGameDeck().size()>=2)
        {
            Oxygen hold[] = getGameDeck().splitOxygen(dbl);
            if(hold[0]!=null && hold[1]!=null)
            o = hold;
            else
            {
                o[0] = hold[1];
                o[1] = getGameDiscard().drawOxygen(1);
            }
        }
        return o;
    }
    /** Public method to start the game
     * No param
     * @throws Exception
     */
    public void startGame() throws Exception
    {
        if(hasStarted==true)
        {
            throw new IllegalStateException();
        }
        for(int i = 0; i<activePlayers.size(); i++)
        {
            Astronaut a = ((List<Astronaut>)activePlayers).get(i);
            Oxygen o2 = gameDeck.drawOxygen(2);
            a.addToHand(o2);
        }
        for(int j = 1; j<=4; j++)
        {
            for(int i = 0; i<activePlayers.size(); i++)
            {
                Astronaut a = ((List<Astronaut>)activePlayers).get(i);
                Oxygen o1 = gameDeck.drawOxygen(1);
                a.addToHand(o1); 
            }
        }
        for(int j = 1; j<=4; j++)
        {
            for(int i = 0; i<activePlayers.size(); i++)
            {
                Astronaut a = ((List<Astronaut>)activePlayers).get(i);
                a.addToHand(getGameDeck().draw());
            }
        }
        hasStarted = true;
    }
    /** Public Method to start turn of current player
     * No param
     */
    public void startTurn()
    {
        currentPlayer = ((List<Astronaut>)activePlayers).get(0);
        System.out.println(currentPlayer.toString()+":");
        //System.out.println(((List<Astronaut>) activePlayers).get(3));
        activePlayers.remove(currentPlayer);
        
    }
    /** Public Method to move player
     * @param traveller Specified player to be moved
     * @return Returns the card in his track 1 unit away
     */
    public Card travel(Astronaut traveller)
    {
        Card p = null;
        if(traveller.hasCard("Oxygen(2)")!=0)
        {
            Card c = traveller.hack("Oxygen(2)");
            gameDiscard.add(c);
            if(traveller.isAlive()==false)
            {
                killPlayer(traveller);
            }
            p = getSpaceDeck().draw();
            if(p.toString().equals("Gravitational anomaly"))
            return p;
            else
            traveller.addToTrack(p);
        }
        else
        {
            for(int i = 0; i<2; i++)
            {
                Card c = traveller.hack("Oxygen(1)");
                gameDiscard.add(c);
            }
            if(traveller.isAlive()==false)
            {
                killPlayer(traveller);
            }
            p = getSpaceDeck().draw();
            if(p.toString().equals("Gravitational anomaly"))
            return p;
            else
            traveller.addToTrack(p);
        }
        return p;
    }
}