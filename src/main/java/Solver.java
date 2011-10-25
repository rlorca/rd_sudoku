/**
 * This is the external facade.
 *
 */
public class Solver
{
    public byte[][] solve(byte[][] src)
    {
        Board b = new Board(src);

        while(!b.isSolved())
        {
            final Board.Cell next = b.findNextCandidate();

            final byte[] candidates = next.possibleValues();

            b = next.modify(candidates[0]);
        }

        System.out.println(b);

        return b.board();
    }
}
