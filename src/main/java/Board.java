import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Responsibilities?
 */
public class Board
{
    public class Cell
    {
        private final byte[] candidates;
        final int x, y;

        public Cell(int x, int y)
        {
            this.x = x;
            this.y = y;

            this.candidates = candidatesFor(x, y);
        }

        public boolean isOptimum()
        {
            return candidates.length == 1;
        }

        public Board modify(byte value)
        {
            byte[][] result = Arrays.copyOf(board, board.length);
            result[y][x] = value;
            return new Board(result);
        }

        public byte[] possibleValues()
        {
            return candidates;
        }

        public int weight()
        {
            return candidates.length == 0 ? Integer.MAX_VALUE : candidates.length;
        }
    }

    private final Set<Byte> valueUniverse;

    private final byte[][] board;

    public Board(byte[][] b)
    {
        this.board = b;

        this.valueUniverse = Collections.unmodifiableSet(possibleValues());
    }

    public byte[][] board()
    {
        return this.board;
    }

    public boolean isSolved()
    {
        for(byte[] rows : board)
        {
            for(byte b : rows)
            {
                if(b == 0) return false;
            }
        }
        return true;
    }

    public Set<Byte> possibleValues()
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

        final Set<Byte> space = new HashSet<Byte>(valueUniverse);

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

    public Cell findNextCandidate()
    {
        Cell cell = new Cell(0, 0);

        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board.length; y++)
            {
                Cell tmp = new Cell(x, y);

                if(tmp.weight() < cell.weight())
                {
                    cell = tmp;

                    if(cell.isOptimum())
                        return cell;
                }
            }
        }
        return cell;
    }

    @Override
    public String toString()
    {
        StringBuilder buffer = new StringBuilder(1000);

        for(byte[] row : board)
        {
            for(byte b : row)
            {
                buffer.append(',').append(b);
            }
            buffer.append('\n');
        }

        return buffer.toString();
    }
}
