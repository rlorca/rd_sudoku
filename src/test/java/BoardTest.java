import org.junit.Test;
import sun.text.normalizer.IntTrie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Responsibilities?
 */
public class BoardTest
{

    private byte[][] complexInitial = new byte[][]{ {0, 4, 0, 1},
                                                    {0, 0, 3, 0},
                                                    {2, 0, 0, 0},
                                                    {0, 0, 1, 0}};

    private Board complexBoard = new Board(complexInitial);;

    @Test
    public void space()
    {
        byte[][] initial = {{0, 1}, {0, 0}};

        byte[] expected = {1, 2};

        Board board = new Board(initial);

        assertEquals(2, board.elementSpace().size());

        for (byte b : expected)
            assertTrue(board.elementSpace().contains(b));

    }

    @Test
    public void candidates()
    {
        assertArrayEquals(new byte[]{3}, complexBoard.candidatesFor(0, 0));
        assertArrayEquals(new byte[]{3, 4}, complexBoard.candidatesFor(3, 2));
    }

    @Test
    public void nextCell()
    {
        //byte[] cell = complexBoard.findNextCandidate();
    }

}
