import java.util.*;
import java.util.stream.Collectors;

class Flattener {


    public <T> List<T> flatten(List<Object> inputList) {
        List<Object> rez = new ArrayList<>();
        boolean state = false;
        while (!state) {
            state = true;
            rez = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i ++) {
                if (inputList.get(i) instanceof List) {
                    rez.addAll((Collection<?>) inputList.get(i));
                    state = false;
                } else if (inputList.get(i) != null) {
                    rez.add(inputList.get(i));
                }
            }
            inputList = rez;
        }
        return (List<T>) rez;
    }
}
