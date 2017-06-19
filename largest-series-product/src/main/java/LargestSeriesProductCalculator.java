import java.util.stream.IntStream;

public class LargestSeriesProductCalculator {

    private String str;
    private String[] strAr;

    public LargestSeriesProductCalculator(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String to search must be non-null.");
        } else {
            for (char c : s.toCharArray()){
                if ((int)c < 48 || (int)c > 57){
                    throw new IllegalArgumentException("String to search may only contains digits.");
                }
            }
            this.str = s;
            this.strAr = this.str.split("");
        }
    }

    public long calculateLargestProductForSeriesLength(int i) {
        if (i > this.str.length()){
                throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if (i == 0){
            return 1;
        } else {
            long rez = 0;
            long temp = 1;
            for (int count = 0; count < this.str.length() - i + 1; count++) {
                for (String s : str.substring(count, i + count).split("")) {
                    temp *= Integer.parseInt(s);
                }
                if (temp > rez) {
                    rez = temp;
                }
                temp = 1;
            }
            return rez;
        }
    }
}
