import java.util.HashMap;
import java.util.Map;

class BracketChecker {

    private String s = "";
    private Map<Character, Integer> counts = new HashMap<>();


    BracketChecker(String s) {
        s = s.replace(" ", "");
        this.s = s;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        if (this.s.length() % 2 == 0) {
            return mainLogic();
        } else return false;

    }

    boolean mainLogic() {
        String temp = this.s;
        while (temp.length() > 0){
            char firstChar = temp.charAt(0);
            temp = remoteCharByIndex(0, temp);
            int indexClosed = findIndexClosed(firstChar, temp);
            if (indexClosed != -1) {
                temp = remoteCharByIndex(indexClosed, temp);
            } else {
                return false;
            }
        }
        return true;
    }

    int findIndexClosed(char firstChar, String str) {
        int first = str.indexOf((int)firstChar + 2);
        int sec = str.indexOf((int)firstChar + 1);

        if (first != -1) {
            return first;
        } else if (sec != -1) {
            return sec;
        } else return -1;
    }

    String remoteCharByIndex(int index, String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(index);
        return sb.toString();

    }
}
