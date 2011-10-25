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

    @Test
    public void board2x2()
    {
        byte[][] initial = {{0, 1}, {0, 0}};

        byte[][] solution = {{2, 1}, {1, 2}};

        Board result = new Solver().solve(new Board(initial));

        assertArrayEquals(solution, result.board());
    }

}
