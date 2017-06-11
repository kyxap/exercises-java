class SumOfMultiples {

    int number;
    int[] set;

    SumOfMultiples(int number, int[] set) {
       this.set = set;
       this.number = number;
    }

    int getSum() {
        int sum = 0;
        if (this.set.length > 0) {
            for (int i = this.set[0]; i < this.number; i++) {
                for (int j = 0; j < this.set.length; j++) {
                    if (i % this.set[j] == 0) {
                        sum += i;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
