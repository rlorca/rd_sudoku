import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Responsibilities?
 */
public class BoardTest
{

    private byte[][] complexInitial = new byte[][]{ {3, 4, 0, 1},
                                                    {0, 0, 3, 0},
                                                    {2, 0, 0, 0},
                                                    {0, 0, 1, 0}};

    private Board complexBoard = new Board(complexInitial);;

    @Test
    public void space()
    {
        final Set<Byte> bytes = complexBoard.elementSpace();

        final byte[] elements = {1, 2, 3, 4};

        assertEquals(elements.length, bytes.size());

        for (byte b : elements)
            assertTrue(bytes.contains(b));

    }

    @Test
    public void candidates()
    {
        assertArrayEquals(new byte[]{2}, complexBoard.candidatesFor(2, 0));
        assertArrayEquals(new byte[]{3, 4}, complexBoard.candidatesFor(3, 2));
        assertArrayEquals(new byte[0], complexBoard.candidatesFor(1, 0));
    }

    @Test
    public void nextCell()
    {
        Board.Cell cell = complexBoard.findNextCandidate();

        assertEquals(0, cell.x);
        assertEquals(3, cell.y);
        assertTrue(cell.isOptimum());
        assertEquals(1, cell.getCandidateValues().length);
    }

    @Test
    public void move()
    {
        Board.Cell cell = complexBoard.findNextCandidate();

        byte[] cv = cell.getCandidateValues();

        Board newBoard = cell.setValue(cv[0]);

        final Board.Cell nextCell = newBoard.findNextCandidate();

        assertEquals(0, nextCell.x);
        assertEquals(1, nextCell.y);
    }

    @Test
    public void solving()
    {
        assertFalse(complexBoard.isSolved());

        Board simpleBoard = new Board(new byte[][]{{1,2}, {2,1}});

        assertTrue(simpleBoard.isSolved());
    }

    @Test(timeout = 1000)
    public void solver()
    {
        Board b = complexBoard;

        while(!b.isSolved())
        {
            final Board.Cell next = b.findNextCandidate();

            final byte[] candidates = next.getCandidateValues();

            b = next.setValue(candidates[0]);
        }

        System.out.println(b.toString());
    }

    @Test(timeout = 1000)
    public void realLifeProblem()
    {
        byte[][] init = new byte[][]{           {0, 0, 0, 2, 6, 0, 7, 0, 1},
                                                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                                                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                                                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                                                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                                                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                                                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                                                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                                                {7, 0, 3, 0, 1, 8, 0, 0, 0}};



        Board b = new Board(init);

        while(!b.isSolved())
        {
            final Board.Cell next = b.findNextCandidate();

            final byte[] candidates = next.getCandidateValues();

            b = next.setValue(candidates[0]);
        }

        System.out.println(b.toString());
    }


    @Test(timeout = 1000)
    public void notFun()
    {
        byte[][] init = new byte[][]{           {0, 2, 0, 0, 0, 0, 0, 0, 0},
                                                {0, 0, 0, 6, 0, 0, 0, 0, 3},
                                                {0, 7, 4, 0, 8, 0, 0, 0, 0},
                                                {0, 0, 0, 0, 0, 3, 0, 0, 2},
                                                {0, 8, 0, 0, 4, 0, 0, 1, 0},
                                                {6, 0, 0, 5, 0, 0, 0, 0, 0},
                                                {0, 0, 0, 0, 1, 0, 7, 8, 0},
                                                {5, 0, 0, 0, 0, 9, 0, 0, 0},
                                                {0, 0, 0, 0, 0, 0, 0, 4, 0}};



        Board b = new Board(init);

        while(!b.isSolved())
        {
            final Board.Cell next = b.findNextCandidate();

            final byte[] candidates = next.getCandidateValues();

            b = next.setValue(candidates[0]);
        }

        System.out.println(b.toString());
    }

}
