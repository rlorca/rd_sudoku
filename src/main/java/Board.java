import java.util.HashSet;
import java.util.Set;

/**
 * Responsibilities?
 */
public class Board
{
    private byte[][] b;

    public Board(byte[][] b)
    {
        this.b = b;
    }

    public byte[][] board()
    {
        return b;
    }

    public Set<Byte> elementSpace()
    {
        HashSet<Byte> result = new HashSet<Byte>(b.length);

        for(byte i = 1; i <= b.length; i++)
        {
            result.add(i);
        }

        return result;
    }

}
