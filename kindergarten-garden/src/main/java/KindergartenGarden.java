import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KindergartenGarden {

    private String[] garden;
    private ArrayList<String> newStudents = new ArrayList<>(); //?

    public KindergartenGarden(String garden, String[] students) {
        this.garden = garden.split("\n");
        this.newStudents.addAll(Arrays.asList(students));
        Collections.sort(this.newStudents);
    }

    public KindergartenGarden(String garden) {
        this.garden = garden.split("\n");
    }

    public List<Plant> getPlantsOfStudent(String student) {
        int studPlace;
        if (student.charAt(0) > 76) {
            studPlace = newStudents.indexOf(student) * 2;
        } else {
            studPlace = (student.charAt(0) - 65) * 2; //ASCII trick 65 - its A(alice); 66 its B(bob) and so on
        }
        List<Plant> plants = new ArrayList<>();
        for (String row : garden) {
            plants.add(Plant.getPlant(row.charAt(studPlace)));
            plants.add(Plant.getPlant(row.charAt(studPlace + 1)));
        }
        return plants;
    }
}