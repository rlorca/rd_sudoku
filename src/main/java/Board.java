import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Responsibilities?
 */
public class Board
{
    private byte[][] board;

    public Board(byte[][] b)
    {
        this.board = b;
    }

    public byte[][] board()
    {
        return board;
    }

    public Set<Byte> elementSpace()
    {
        HashSet<Byte> result = new HashSet<Byte>(board.length);

        for(byte i = 1; i <= board.length; i++)
        {
            result.add(i);
        }

        return result;
    }

    public byte[] candidatesFor(int x, int y)
    {
        if(board[y][x] != 0)
            return new byte[0];

        final Set<Byte> space = elementSpace();

        for(int i = 0; i < board.length; i++)
        {
            space.remove(board[y][i]);
            space.remove(board[i][x]);
        }

        byte[] result = new byte[space.size()];
        int i = 0;
        for(Byte b : space)
            result[i++] = b;

        return result;
    }

    public byte[] findNextCandidate()
    {
        int min = board.length;
        byte[] cell = null;

        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board.length; y++)
            {
                final byte[] c = candidatesFor(x, y);
                if(c.length > 0 && min > c.length)
                {
                    cell = new byte[]{(byte) x, (byte) y};
                    min = c.length;

                    if(min == 1)
                    {
                        return cell;
                    }
                }
            }
        }
        return cell;
    }
}
