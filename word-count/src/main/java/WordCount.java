import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String,Integer> phrase(String word) {
        Map<String, Integer> rez = new HashMap<>();
//        String temp = "";
//        for (char c : word.toCharArray()) {
//            if ((int) c > 96 || (int) c == 32) {
//                temp+= String.valueOf(c);
//            }
//        }
        String[] ar = word.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll("( )+", " ").split(" ");
        for (String str : ar) {
            if (rez.containsKey(str)) {
                rez.computeIfPresent(str, (k, v) -> v + 1);
            } else rez.put(str, 1);
        }
        return rez;
    }
}
