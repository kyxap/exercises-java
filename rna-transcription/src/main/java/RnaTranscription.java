import java.util.ArrayList;

public class RnaTranscription {
    public String transcribe(String dnaStrand) {

        if (dnaStrand.length() <= 0){
            return "";
        } else {
            String rez = "";
            for (int i = 0; i < dnaStrand.length(); i++){
                rez += oneTwoOther(dnaStrand.substring(i, i + 1));
            }
            return rez;
        }
    }

    public String oneTwoOther (String a) {
        /*
    * `G` -> `C`
    * `C` -> `G`
    * `T` -> `A`
    * `A` -> `U`
         */
        String rez = "";
        if (a.equals("G")){
            rez = "C";
        } else if (a.equals("C")){
            rez = "G";
        } else if (a.equals("T")){
            rez = "A";
        } else if (a.equals("A")){
            rez = "U";
        }
        return rez;
    }
}
