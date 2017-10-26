public class BoardCoordinate {

    private int[] coordinate;

    public BoardCoordinate(int i, int i1) {
        if (i > 7){
            throw new IllegalArgumentException("Coordinate must have rank <= 7.");
        } else if (i1 > 7) {
            throw new IllegalArgumentException("Coordinate must have file <= 7.");
        }
        else if (i < 0 || i1 < 0) {
            throw new IllegalArgumentException("Coordinate must have positive file.");
        } else coordinate = new int[]{i, i1};
    }

    int[] getCoordinate() {
        return coordinate;
    }
}
