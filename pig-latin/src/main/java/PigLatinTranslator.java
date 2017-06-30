import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kyx on 6/29/17.
 */
public class PigLatinTranslator {
    public String translate(String englishPhrase) {

        if (englishPhrase.contains(" ")) {
            String[] sentance = englishPhrase.split(" ");
            String sentace = "";
            for (String word : sentance) {
                sentace+= parse(word) + " ";
            }
            return sentace.substring(0, sentace.length() -1);
        } else return parse(englishPhrase);
    }

    public String parse(String englishPhrase) {
        String ay = "ay";
        ArrayList<String> consonants = new ArrayList<>(Arrays.asList("p","k","y","x", "f", "r", "ch", "qu", "th", "squ", "thr", "sch"));
        String one = englishPhrase.substring(0, 1);
        String two = englishPhrase.substring(0, 2);
        String three = englishPhrase.substring(0,3);
        if (consonants.contains(three)) {
            return englishPhrase.substring(three.length(), englishPhrase.length()) + three + ay;
        } else if (two.equals("yt") || two.contains("xr")) {
            return englishPhrase + ay;
        } else if (consonants.contains(two)) {
            return englishPhrase.substring(two.length(), englishPhrase.length()) + two + ay;
        } else if (consonants.contains(one)) {
            return englishPhrase.substring(one.length(), englishPhrase.length()) + one + ay;
        }
        else return englishPhrase + ay;
    }
}
