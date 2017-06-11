final class NaturalNumber {

    int natNum = 0;

    public NaturalNumber(int i) {
        if (i <= 0) {
            throw  new IllegalArgumentException("You must supply a natural number (positive integer)");
        } else this.natNum = i;
    }

    public Classification getClassification() {
        int sum = 0;
        for (int i = 1; i < this.natNum; i++) {
           if (this.natNum % i == 0) {
               sum += i;
           }
        }

        if (this.natNum == sum) {
            return Classification.PERFECT;
        } else if (this.natNum < sum) {
           return Classification.ABUNDANT;
        } else return Classification.DEFICIENT;
    }
}
