/**
 * Created by kyx on 6/10/17.
 */
public class DifferenceOfSquaresCalculator {
    public int computeSquareOfSumTo(int i) {
        int sum = 0;
        for (int c = 1; c < i + 1; c++) {
           sum += c;
        }
        return sum * sum;
    }

    public int computeSumOfSquaresTo(int i) {
        int sum = 0;
        for (int c = 1; c < i + 1; c++) {
            sum += c * c;
        }
        return sum;
    }

    public int computeDifferenceOfSquares(int i) {
        return computeSquareOfSumTo(i) - computeSumOfSquaresTo(i);
    }
}
