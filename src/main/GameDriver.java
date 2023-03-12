import selfish.GameEngine;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import selfish.Astronaut;
public class GameDriver {

    /**
     * A helper function to centre text in a longer String.
     * @param width The length of the return String.
     * @param s The text to centre.
     * @return A longer string with the specified text centred.
     */
    public static String centreString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public GameDriver() {
    }

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        File f1 = new File("ActionCards.txt");
        File f2 = new File("SpaceCards.txt");
        GameEngine ob = new GameEngine(48,f1.getAbsolutePath(),f2.getAbsolutePath());
        Console con = System.console();
        int t = 0;
        //File f3 = new File("art.txt");
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("art.txt"))) 
        {
            String line = lineNumberReader.readLine();
            for(int i = 1; i <= 17; i++){
               //int number = lineNumberReader.getLineNumber();
               System.out.println(line);
               line = lineNumberReader.readLine();
            }
        }
        String Name1 = con.readLine("Player 1 Name?");
        t = ob.addPlayer(Name1);
        String Name2 = con.readLine("Player 2 Name?");
        t = ob.addPlayer(Name2);
        String option = con.readLine("Add Another Player?[Y]es/[N]o");
        if(option.equals("Y"))
        {
        do
        {
            String Name = con.readLine("Player "+(t+1)+" Name?");
            t = ob.addPlayer(Name);
            option = con.readLine("Add Another Player?[Y]es/[N]o");
        }while(option.equals("N")==false);
        }
        List <Astronaut> Players = new ArrayList<>();
        Players = ob.getAllplayers();
        System.out.println();
        System.out.print("After a dazzling (but doomed) space mission, ");
        for(int i =0; i<Players.size(); i++)
        {
            if(i==Players.size()-1)
            System.out.print("and "+Players.get(i).toString());
            else if (i==Players.size()-2)
            System.out.print(Players.get(i).toString()+" ");
            else
            System.out.print(Players.get(i).toString()+", ");
        }
        System.out.println(" are floating in space and their oxygen supplies are running low.");
        System.out.println("Only the first back to the ship will survive!");
    }   
}