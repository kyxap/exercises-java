import java.util.HashMap;
import java.util.Map;

final class Scrabble {

    String word = "";
  //  int count = 0;
    Map<Integer, String> vallues = new HashMap<>();

    Scrabble(String word) {
        this.word = word;
        setVallues();
    }

    Map<Integer, String> setVallues(){
        this.vallues.put(1, "AEIOULNRST");
        this.vallues.put(2, "DG");
        this.vallues.put(3, "BCMP");
        this.vallues.put(4, "FHVWY");
        this.vallues.put(5, "K");
        this.vallues.put(8, "JX");
        this.vallues.put(10, "QZ");
        return vallues;
}

   int countScore() {
        int count = 0;
        if (word != null){
            this.word = this.word.toUpperCase();
            for (int i = 0; i < this.word.length(); i++){
                for(Map.Entry<Integer, String> entry : this.vallues.entrySet()) {
                    Integer key = entry.getKey();
                    String value = entry.getValue();
                    if (value.contains(this.word.substring(i, i + 1))) {
                        count += key;
                    }
            }

        }
        }
        return count;
   }

    int getScore() {
        return countScore();
    }
}
