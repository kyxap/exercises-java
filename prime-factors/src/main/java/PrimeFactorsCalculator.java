import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long input) {

        List<Long> resultList = new ArrayList<>();

        for (long i = 2; i <= input; i++) {
            if (input % i == 0) {
                input = input / i;
                resultList.add(i);
                i = 1;
            }
        }
        return resultList;
    }
}
