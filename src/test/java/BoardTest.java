import org.junit.Test;
import sun.text.normalizer.IntTrie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Responsibilities?
 */
public class BoardTest
{

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



}
