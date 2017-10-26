import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class House {

    String f = "This is the house that Jack built.";

    /**
     "This is the horse and the hound and the horn\n" +
     "that belonged to the farmer sowing his corn\n" +
     "that kept the rooster that crowed in the morn\n" +
     "that woke the priest all shaven and shorn\n" +
     "that married the man all tattered and torn\n" +
     "that kissed the maiden all forlorn\n" +
     "that milked the cow with the crumpled horn\n" +
     "that tossed the dog\n" +
     "that worried the cat\n" +
     "that killed the rat\n" +
     "that ate the malt\n" +
     "that lay in the house that Jack built.";
     */

    List<String> array = Arrays.asList("house that Jack built.", "malt", "rat", "cat", "dog", "cow", "forlorn");
    List<String> array2 = Arrays.asList("ate", "killed", "worried", "tossed", "milked", "?", "!");
    List<String> array3 = Arrays.asList("maiden all");

    String this_w = "This is the ";
    String that = "that lay in the ";

    public String verse(int verse) {
        List<String> rez = new ArrayList<>();
        if (verse == 1) {
            return this_w + array.get(verse - 1);
        }
        else {
            for (int i = 0; i <= verse - 1; i++) {
                String toAdd = array.get(i);
//                if (i == 6 - 1) {  //if not last and not 6th due to next
//                    toAdd = this_w + array.get(i) + " with the crumpled horn";
//                } else if (i == 7 -1 && verse == 7) {
//                    toAdd = this_w + array3.get(i - 6) + " " +  array.get(i);
//                }
                if (i == verse -1) { //last
                    toAdd = this_w + toAdd;

                } else { //all other
                    if (i > 0) {
                        toAdd = "that " + array2.get(i - 1) + " the " + toAdd;
                    } else toAdd = that + toAdd;
                }
                rez.add(toAdd);
            }
            Collections.reverse(rez); // stupid but let it be :D
            return parseList(rez);
        }
    }

    String parseList(List<String> list) {
        String rez = "";
        for (String a : list) {
            rez += a + "\n";
        }
        System.out.println(rez.substring(0, rez.length() - 1));
        return rez.substring(0, rez.length() - 1);
    }

    public String verses(int startVerse, int endVerse) {
        return null;
    }

    public String sing() {
        return "";
    }
}
