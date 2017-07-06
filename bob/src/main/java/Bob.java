/**
 * Created by kyx on 7/2/17.
 */
public class Bob {
    public String hey(String s) {
        String pattern = "([A-Z])";
        if (s.matches("[0-9 ]+\\?")) {
            return "Sure.";
        }
        else if (s.matches("[A-Z0-9\u00c4%^*@#$(*.,!? ]+") && !s.matches("[0-9.,!? ]+")) {
            return "Whoa, chill out!";
        } else if (s.matches(".*\\?")) {
            return "Sure.";
        } else if (s.matches("[\\s ]+") || s.length() < 1){
            return "Fine. Be that way!";
        }
            else return "Whatever.";
    }
}
