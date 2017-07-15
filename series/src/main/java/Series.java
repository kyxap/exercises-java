import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyx on 7/14/17.
 */
public class Series {
    private String series = "";
    private List<Integer> digits = new ArrayList<>();

    public Series(String s) {
        this.series = s;
        for (char c : this.series.toCharArray()) {
            digits.add(Integer.parseInt(String.valueOf(c)));
        }
    }

    public List<Integer> getDigits() {

        return digits;
    }

    public List<List<Integer>> slices(int i) {
        if (i > this.series.length()) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> rez = new ArrayList<>();
        for (int z = 0; series.length() >= i; z++){
            String[] a = series.substring(0, i).split("");
            rez.add(strToIntAr(a));
            series = series.substring(1, series.length());
        }
        return rez;
    }

    ArrayList<Integer> strToIntAr(String[] strAr) {
        ArrayList rez = new ArrayList();
        for (int i = 0; i < strAr.length; i++) {
            rez.add(Integer.parseInt(strAr[i]));
        }
        return rez;
    }
}
