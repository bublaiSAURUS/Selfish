package selfish.deck;

import java.io.Serializable;
/**
 * This is Oxygen class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class Oxygen extends Card implements Serializable
{
    private int value;
    private final static long serialVersionUID = 0;

    /** Public Constructor 
     * @param value Value of Oxygen
     */
    public Oxygen(int value)
    {
        super();
        this.value = value; 
    }
    /** Public method to get value of Oxygen card
     * @return Returns the value of Oxygen Card
     */
    public int getValue()
    {
        return value;
    }
    /** Public method to Get name of Oxygen card
     * @return Returns name of Oxygen card
     */
    public String toString()
    {
        return ("Oxygen"+"("+value+")");
    }
   // @Override
    //public int compareTo(Object o) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
   // }    
    /** Public method to Compare 2 Oxygen Cards by value
     * @param o Oxygen Card to be compared to 
     * @return Returns the net result 
     */
    public int compareTo(Oxygen o)
    {
        return value-o.getValue();
    }
}