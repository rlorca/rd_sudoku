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
    public byte[][] solve(byte[][] src)
    {
        Board b = new Board(src);

        while(!b.isSolved())
        {
            final Board.Cell next = b.findNextCandidate();

            final byte[] candidates = next.getCandidateValues();

            b = next.setValue(candidates[0]);
        }

        System.out.println(b);

        return b.board();
    }
}
