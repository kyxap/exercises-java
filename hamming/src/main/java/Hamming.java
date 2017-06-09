public class Hamming {

    private int hamDist = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (!leftStrand.substring(i, i + 1).equals(rightStrand.substring(i, i + 1))) {
                    increaseHammingDistance();
                }
            }
        }
    }

    int getHammingDistance() {
        return hamDist;
    }

    void increaseHammingDistance() {
        hamDist++;
    }
}

