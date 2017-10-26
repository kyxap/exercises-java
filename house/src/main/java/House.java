import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class House {


    List<String> array = Arrays.asList("house that Jack built.", "malt", "rat", "cat", "dog", "cow", "maiden", "man",
            "priest", "rooster", "farmer", "horse", "@", "#");
    List<String> array2 = Arrays.asList("ate", "killed", "worried", "tossed", "milked", "kissed", "married", "woke",
            "kept", "belonged to", "?", "!");
    List<String> array3 = Arrays.asList("with the crumpled horn", "all forlorn", "all tattered and torn",
            "all shaven and shorn", "that crowed in the morn", "sowing his corn", "and the hound and the horn",
            "$", "%");

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
                if (i >= 5) {  //if not last and not 6th due to next
                    toAdd = array.get(i) + " " + array3.get(i - 5);
                }
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
        return rez.substring(0, rez.length() - 1);
    }

    public String verses(int startVerse, int endVerse) {
        String rez = "";
        for (int i = startVerse; i <= endVerse; i++){
            rez = rez += verse(i) + "\n\n";
        }
        System.out.println(rez.substring(0, rez.length() - 1));
        return rez.substring(0, rez.length() - 2);
    }

    /**
     * @return
     */
    public String sing() {
        return verses(1, 12);
    }
}
