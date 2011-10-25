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
}
