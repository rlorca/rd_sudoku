import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Responsibilities?
 */
public class SolverTest
{
    @Test
    public void smallestBoard()
    {
        byte[][] pos = new byte[1][1];
        Board b = new Board(pos);

        final Board solution = new Solver().solve(b);

        assertArrayEquals(pos, solution.board());
    }
}
