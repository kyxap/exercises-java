public class SpiralMatrixBuilder {

    int size = 0;


    public Object[] buildMatrixOfSize(int size) {
        this.size = size;
        int[][] rez = new int[size][size];
        int j = 0;
        int i = 0;

        int count = 0;

        while (i < size) {
            while (j < size) {
                rez[i][j] = count;
                j++;
                count++;
            }


        }





//        int[][] rez = fillFirstRow();
//        rez = fillLastCol(rez);
//        rez = fillCenter(rez);
////        int coun = 1;
////        for (int i = 0; i < size; i++) {
////            for (int j = 0; j < size; j++) {
////                rez[i][j] = coun;
////                coun++;
////            }
////        }
        printAr(rez);
        return rez;
    }

    private void printAr(int[][] rez) {
        for (int[] i : rez) {
            for (int j : i) {
                if (String.valueOf(j).length() > 1) {
                    System.out.print(j + " ");
                } else System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    int[][] fillFirstRow() {
        int[][] rez = new int[size][size];
        int dataStart = 1;
        for (int j = 0; j < size; j++) {
            rez[0][j] = dataStart;
            dataStart++;
        }
        return rez;
    }

    int[][] fillLastCol(int[][] rez) {
        int startData = size + 1;
        for (int i = 1; i < size; i++) {
            rez[i][size - 1] = startData;
            startData++;
        }
        return rez;
    }

    int[][] fillCenter(int[][] rez) {
        int startData = size + size;
        for (int i = size - 1; i > 0; i--) {
            for (int j = size - 2; j >= 0; j--) {
                rez[i][j] = startData;
                startData++;
//                System.out.println("i: " + i + "; j: " + j);
            }
        }
        return rez;
    }
}
