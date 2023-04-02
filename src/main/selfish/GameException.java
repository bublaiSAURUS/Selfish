package selfish;
import java.util.*;
/**
 * This is GameException class
 * @author Sourabh Roy
 * @ selfish
 * @version jdk 17.0.6
 */
public class GameException extends Exception
{
    /**Public Constructor
     * @param msg Error message to be displayed
     * @param e The throwable object
     */
    public GameException(String msg, Throwable e)
    {
        super(msg, e);
    }
}

