import java.util.Arrays;

public class QueenAttackCalculator {

    BoardCoordinate whiteQ;
    BoardCoordinate blackQ;
    public QueenAttackCalculator(BoardCoordinate boardCoordinate, BoardCoordinate boardCoordinate1) {
        whiteQ = boardCoordinate;
        blackQ = boardCoordinate1;
        if (Arrays.equals(whiteQ.getCoordinate(), blackQ.getCoordinate())) {
            throw new IllegalArgumentException("Queens may not occupy the same board coordinate.");
        }
    }

    public boolean canQueensAttackOneAnother() {

        if (whiteQ.getCoordinate()[0] == blackQ.getCoordinate()[0] || whiteQ.getCoordinate()[1] == blackQ.getCoordinate()[1]) {
            return true;
        } else  return false;
    }
}
