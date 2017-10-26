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

    public String verse(int verse) {
        if (verse == 1) {
            return f;
        }
        else {

            return null;
        }
    }

    public String verses(int startVerse, int endVerse) {
        return null;
    }

    public String sing() {
        return "";
    }
}
