import java.util.HashMap;
import java.util.Map;

public class DNA {
    private String dna;
    Map<Character, Integer> nuc = new HashMap();
    public DNA(String s) {
        this.dna = s;

        this.nuc.put('A', 0);
        this.nuc.put('C', 0);
        this.nuc.put('G', 0);
        this.nuc.put('T', 0);
    }

    public int count(char a) {
        int count = 0;
        for (char c : this.dna.toCharArray()) {
            if (!nuc.containsKey(a)) {
               throw new IllegalArgumentException();
            } else if (c == a) {
                count++;
            }
        }
        return count;
    }

    public Map<Character, Integer> nucleotideCounts() {
        if (this.dna.length() > 0) {
            for (char c : this.dna.toCharArray()) {
                updateValueByKey(c);
            }
        }
        return nuc;
    }

    void updateValueByKey(char c) {
        this.nuc.computeIfPresent(c, (k, v) -> v + 1);
    }
}
