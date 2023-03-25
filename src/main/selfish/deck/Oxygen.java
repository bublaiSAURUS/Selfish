package selfish.deck;

import java.io.Serializable;

public class Oxygen extends Card implements Serializable
{
    private int value;
    private final static long serialVersionUID = 0;

    public Oxygen(int value)
    {
        super();
        this.value = value; 
    }
    public int getValue()
    {
        return value;
    }
    public String toString()
    {
        return ("Oxygen"+"("+value+")");
    }
   // @Override
    //public int compareTo(Object o) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
   // }    
    public int compareTo(Oxygen o)
    {
        return value-o.getValue();
    }
}