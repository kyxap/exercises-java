import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodChain {

    String B_LINE = "\n";
    String END_LINE = ".";
    Map<Integer, String[]> animalsToSwallow = new HashMap<>();
    FoodChain() {

        animalsToSwallow.put(1, new String[] {"fly", ""});
        animalsToSwallow.put(2, new String[] {"spider", "It wriggled and jiggled and tickled inside her.\n"});
        animalsToSwallow.put(3, new String[] {"bird", "How absurd to swallow a bird!\n"});
        animalsToSwallow.put(4, new String[] {"cat", "Imagine that, to swallow a cat!\n"});
        animalsToSwallow.put(5, new String[] {"dog", "What a hog, to swallow a dog!\n"});
        animalsToSwallow.put(6, new String[] {"goat", "Just opened her throat and swallowed a goat!\n"});
        animalsToSwallow.put(7, new String[] {"cow", "I don't know how she swallowed a cow!\n"});
        animalsToSwallow.put(8, new String[] {"horse", "She's dead, of course!"});
    }
    public String verse(int verse) {
        ArrayList<String> song = new ArrayList<>();

        int count = verse;
        while (count != 0)  {
            if (count == 1) {
                if (verse == 8) {
                    song = new ArrayList<>();
                    song.add(0, "I know an old lady who swallowed a " + animalsToSwallow.get(verse)[0] + ".\n");
                    if (animalsToSwallow.get(verse)[1].length() > 0) {
                        song.add(1, animalsToSwallow.get(verse)[1]);
                    }
                    break;
                } else {

                    //at the start for each one
                    song.add(0, "I know an old lady who swallowed a " + animalsToSwallow.get(verse)[0] + ".\n");
                    if (animalsToSwallow.get(verse)[1].length() > 0) {
                        song.add(1, animalsToSwallow.get(verse)[1]);
                    }
                }
            }
            if (count >= 2 ){
                if (count == 3) {
                    song.add("She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n");
                } else {
                    song.add("She swallowed the " + animalsToSwallow.get(count)[0] + " to catch the " + animalsToSwallow.get(count - 1)[0] + ".\n");
                }
            } if (count == 1 && verse != 8) {
                //at the end of each except 8
                song.add("I don't know why she swallowed the fly. Perhaps she'll die.");
            }
            count--;
        }


        return listToStr(song);
    }

    public String verses(int startVerse, int endVerse) {
        String rez = "";
        while (startVerse <= endVerse) {
            String tmp = verse(startVerse);
            startVerse++;
            if (startVerse <= endVerse) {
                tmp += "\n\n";
            }
            System.out.println(tmp);
            rez += tmp;

        }
        return rez;
    }

    String listToStr(ArrayList<String> list) {
        String rez = "";
        for (String str : list) {
           rez += str;
        }
//        System.out.println(rez);
        return rez;
    }
}
