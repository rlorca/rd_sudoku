import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Responsibilities?
 */
public class SolverTest
{
    @Test
    public void board2x2()
    {
        byte[][] initial = {{0, 1}, {0, 0}};

        byte[][] solution = {{2, 1}, {1, 2}};

        assertArrayEquals(solution, new Solver().solve(initial));
    }

    @Test(timeout = 1000)
    public void realLifeProblem()
    {
        byte[][] init = new byte[][]{          {0, 0, 0, 2, 6, 0, 7, 0, 1},
                                               {6, 8, 0, 0, 7, 0, 0, 9, 0},
                                               {1, 9, 0, 0, 0, 4, 5, 0, 0},
                                               {8, 2, 0, 1, 0, 0, 0, 4, 0},
                                               {0, 0, 4, 6, 0, 2, 9, 0, 0},
                                               {0, 5, 0, 0, 0, 3, 0, 2, 8},
                                               {0, 0, 9, 3, 0, 0, 0, 7, 4},
                                               {0, 4, 0, 0, 5, 0, 0, 3, 6},
                                               {7, 0, 3, 0, 1, 8, 0, 0, 0}};

        byte[][] expected = new byte[][] {
                                            {4,3,5,2,6,9,7,8,1},
                                            {6,8,2,5,7,1,4,9,3},
                                            {1,9,7,8,3,4,5,6,2},
                                            {8,2,6,1,9,5,3,4,7},
                                            {3,7,4,6,8,2,9,1,5},
                                            {9,5,1,7,4,3,6,2,8},
                                            {5,1,9,3,2,6,8,7,4},
                                            {2,4,8,9,5,7,1,3,6},
                                            {7,6,3,4,1,8,2,5,9}};


        assertArrayEquals(expected, new Solver().solve(init));
    }


    @Test(timeout = 1000)
    public void notFun()
    {
        byte[][] init = new byte[][]{          {0, 2, 0, 0, 0, 0, 0, 0, 0},
                                               {0, 0, 0, 6, 0, 0, 0, 0, 3},
                                               {0, 7, 4, 0, 8, 0, 0, 0, 0},
                                               {0, 0, 0, 0, 0, 3, 0, 0, 2},
                                               {0, 8, 0, 0, 4, 0, 0, 1, 0},
                                               {6, 0, 0, 5, 0, 0, 0, 0, 0},
                                               {0, 0, 0, 0, 1, 0, 7, 8, 0},
                                               {5, 0, 0, 0, 0, 9, 0, 0, 0},
                                               {0, 0, 0, 0, 0, 0, 0, 4, 0}};

        byte[][] expected = new byte[][] {
                                                {4,2,1,9,3,7,5,6,8},
                                                {9,5,8,6,2,4,1,7,3},
                                                {1,7,4,2,8,5,3,9,6},
                                                {8,9,6,1,7,3,4,5,2},
                                                {2,8,5,3,4,6,9,1,7},
                                                {6,4,7,5,9,8,2,3,1},
                                                {3,6,9,4,1,2,7,8,5},
                                                {5,1,3,7,6,9,8,2,4},
                                                {7,3,2,8,5,1,6,4,9}};

        assertArrayEquals(expected, new Solver().solve(init));
    }


}
