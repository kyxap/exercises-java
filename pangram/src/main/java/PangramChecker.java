import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String input) {
        if (input.length() > 1) {
            Set<String> list = new HashSet<>();
            input = input.toLowerCase();
            for (int i = 0; i < input.length(); i++) {
                int a = (int)input.substring(i, i+1).charAt(0);
                if (a >= 97 && a < 123){
                    list.add(input.substring(i, i + 1));
                }
            }
            if (list.size() == 26) {
                return true;
            } else return false;
        }
        else return false;
    }
}
