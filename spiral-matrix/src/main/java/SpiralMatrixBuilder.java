public class SpiralMatrixBuilder {

    public Object[] buildMatrixOfSize(int n) {

        int size = n * n;
        int[][] spiral = new int[n][n];
        int count = 1;
        int x = 0, y = 0, loop = 1;
        while (count < size) {
            //go right
            while (x < n - loop) { //0-3
                spiral[y][x] = count;
                count++;
                x++;
            }
            //go down
            while (y < n - loop) {
                spiral[y][x] = count;
                count++;
                y++;
            }
            //go left
            while (x >= loop) {
                spiral[y][x] = count;
                count++;
                x--;
            }
            //go up
            while (y > loop) {
                spiral[y][x] = count;
                count++;
                y--;
            }
            loop++;
        }
        //does the last element
        if (count == size) {
            spiral[y][x] = count;
        }

        printAr(spiral);
        return spiral;
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
}
