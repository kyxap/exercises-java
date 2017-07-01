import java.util.Random;

public class Robot {
    private String name = "";


    public Robot() {
        for (int i = 0; i < 2; i++) {
            this.name += String.valueOf((char)getRandom(65, 90));
        }
        for (int i = 0; i < 3; i++) {
            this.name += String.valueOf(getRandom(0, 9));
        }
    }

    int getRandom(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = new Robot().getName();
    }
}
