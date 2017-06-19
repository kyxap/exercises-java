import java.util.Arrays;
import java.util.List;

/**
 * Created by kyx on 6/17/17.
 */
public class Matrix {
    private final String matrix;

    public Matrix(String matrixAsString) {
        this.matrix = matrixAsString;
        }

    public int getRowsCount() {
        return this.matrix.split("\n").length;
    }

    public int getColumnsCount() {
        String[] temp = this.matrix.split("\n");
        return temp[0].split(" ").length;
    }

    public int[] getRow(int i) {
        String[] temp = this.matrix.split("\n");
        temp = temp[i].split(" ");
        int[] rez = new int[temp.length];
        int count = 0;
        for (String x : temp) {
            rez[count] = Integer.parseInt(x);
            count++;
        }
        return rez;
    }

    public int[] getColumn(int i) {
        String[] sA = this.matrix.split("\n");
        int[] columAr = new int[sA.length];
        int count = 0;
        for (String str : sA) {
            columAr[count] = Integer.parseInt(str.split(" ")[i]);
            count++;
        }

        return columAr;
    }
}
