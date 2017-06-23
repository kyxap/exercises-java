import java.util.ArrayList;
import java.util.List;

public class KindergartenGarden {

    String[] garden;

    //Why Do wee need array of students? O_o
    public KindergartenGarden(String garden, String[] students) {
        this("\n"); //invoce constructor from another one
    }

    public KindergartenGarden(String garden) {
        this.garden = garden.split("\n");
    }

    public List<Plant> getPlantsOfStudent(String student) {
        int studPlace = (student.charAt(0) - 65) * 2; //ASCII trick 65 - its A(alice); 66 its B(bob) and so on
        List<Plant> plants = new ArrayList<>();
        for (String row : garden) {
            plants.add(Plant.getPlant(row.charAt(studPlace)));
            plants.add(Plant.getPlant(row.charAt(studPlace + 1)));
        }
        return plants;
    }
}