import java.util.ArrayList;

/**
 * Created by kyx on 6/26/17.
 */
public class IsogramChecker {
    public boolean isIsogram(String duplicates) {
        ArrayList<Integer> all = new ArrayList<>();
        for (char x : duplicates.toLowerCase().replace(" ", "").replace("-", "").toCharArray()) {
            if (all.indexOf((int) x) == -1) {
                all.add((int) x);
            } else return false;
        }
        return true;
    }
}
