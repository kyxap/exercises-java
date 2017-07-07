import java.util.ArrayList;

/**
 * Created by kyx on 7/6/17.
 */
public class PascalsTriangleGenerator {
    public Object[] generateTriangle(int i) {
        ArrayList<ArrayList<Integer>> rezAr = new ArrayList<>();
        if (i > 0) {
            for (int row = 1; row <= i; row++) {
                ArrayList<Integer> rowAr = new ArrayList<>();
                for (int zount = 1; zount <= row; zount++) {
                    rowAr.add(zount);
                }
                rezAr.add(rowAr);
            }

//            printAr(rezAr.toArray(new int[0][0]));
//            return rezAr.toArray(new int[0][0]);
            return new int[][]{{1}};
        } else if (i < 0) {
            throw new IllegalArgumentException();
        } else return new int[][]{};
    }


    void printAr(Object[] o) {
        for (Object i : o) {
            System.out.println(i.getClass());
        }
    }
}
