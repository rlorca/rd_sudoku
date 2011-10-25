import sun.reflect.generics.tree.ReturnType;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Responsibilities?
 */
public class Solver
{
    public Board solve(Board src)
    {
        final byte[][] board = src.board();

        final Set<Byte> elementSpace = null; //createSpace(board[0].length);

        byte[] row = board[0];

        byte[][] result = new byte[board.length][row.length];

        for(int i = 0; i < board.length; i++)
        {
            Queue<Byte> rowComplement = complementOf(row, elementSpace);

            result[i] = fillRow(row, rowComplement);
        }

        return new Board(result);
    }

    private byte[] fillRow(byte[] row, Queue<Byte> rowComplement)
    {
        for(int i = 0; i < row.length; i++)
        {
            if(row[i] == 0)
            {
                row[i] = rowComplement.poll();
            }
        }
        return row;
    }

    private Queue<Byte> complementOf(byte[] target, Set<Byte> space)
    {
        HashSet<Byte> result = new HashSet<Byte>(space);

        for(byte b : target)
            result.remove(b);

        return new LinkedList(result);
    }



}
