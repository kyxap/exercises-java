import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {


    public List<String> printToList(char a) {
        int start = (int) 'A';
        int end = (int) a;
        int count = 1;
        List<String> rez = new ArrayList<>();
        while (start < end) {
            if (start == 65){
                String i = strOfSpaces(end - start) + (char)start + strOfSpaces(end - start);
                rez.add(i);
            } else {
                String i = strOfSpaces(end - start) + (char)start + strOfSpaces(count) + (char)start + strOfSpaces(end - start);
                rez.add(i);
                count = count + 2;
            }
            start++;

        }

        while (start >= 65) {
            if (start == 65){
                String i = strOfSpaces(end - start) + (char)start + strOfSpaces(end - start);
                rez.add(i);
            } else {
                String i = strOfSpaces(end - start) + (char)start + strOfSpaces(count) + (char)start + strOfSpaces(end - start);
                rez.add(i);
                count = count - 2;
            }
            start--;

        }
        return rez;
    }

    String strOfSpaces(int n) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < n; i++) {
            spaces.append(" ");
        }

        return spaces.toString();
    }
}
