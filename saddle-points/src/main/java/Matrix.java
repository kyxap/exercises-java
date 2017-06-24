import java.awt.*;
import java.util.*;
import java.util.List;

class Matrix {

    Set<MatrixCoordinate> matCoo = new HashSet<>();
    List<List<Integer>> matrix = new ArrayList<>();

    Matrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        boolean state = true;
        int rowCount = 0;
        int colCount = 0;
        for (List<Integer> row : matrix) {
            colCount = 0;
            for (int el : row) {
                state = true;
                for (int i = 0; i < row.size(); i++) {
                    if (state) {
                        int tmp = row.get(i);
                        if (el >= row.get(i)) {
                            continue;
                        } else state = false;
                    }
                }
                    for (int j = 0; j < matrix.size(); j++) {
                        if (state) {
                            int tmp = matrix.get(j).get(colCount);
                            if (el <= matrix.get(j).get(colCount)) {
                                continue;
                            } else state = false;
                        }
                    }
                if (state) {
                    matCoo.add(new MatrixCoordinate(rowCount, colCount));
                }
                colCount++;
            }
            rowCount++;
        }
        return matCoo;
    }
}

