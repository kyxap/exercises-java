public class BeerSong {
    public String verse(int i) {
        String song = "";
        if (i >= 1) {
            song += i +" bottle" + checkS(i) + " of beer on the wall, " + i +" bottle" + checkS(i) + " of beer.\n";
        }
        if (i - 1 == 0) {
            song += "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
        } else if (i == 0) {
            song += "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
        } else song += "Take one down and pass it around, "+ (i - 1) + " bottle" + checkS(i - 1) + " of beer on the wall.\n\n";
        return song;
    }

    public String sing(int i, int i1) {
        String song = "";
        while (i >= i1) {
            song += verse(i);
            i--;
        }
        return song;
    }

    public String singSong() {
        return sing(99, 0);
    }

    String checkS(int i) {
        if (i > 1) {
            return "s";
        } else return "";
    }
}
