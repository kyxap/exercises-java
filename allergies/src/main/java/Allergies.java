import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allergies {
    private int score;
    List<Allergen> al = new ArrayList<>();

    public Allergies(int z) {
        if (z <= 255) {
            this.score = z;
        } else this.score = z - 256;

        int temp = this.score;
        Allergen[] allergens = Allergen.values();
        for (int i = allergens.length - 1; i >= 0; i--){
            if (temp - allergens[i].getScore() >= 0) {
                this.al.add(allergens[i]);
                temp -= allergens[i].getScore();
            }
        }
        Collections.reverse(this.al);
    }

    public boolean isAllergicTo(Allergen some) {
        return some.getScore() <= this.score;
    }

    public List<Allergen> getList() {
        return this.al;
    }
}
