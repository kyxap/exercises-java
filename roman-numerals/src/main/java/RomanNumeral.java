import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by kyx on 7/16/17.
 */
public class RomanNumeral {
    String romanNumeral = "";

    int[] ara =  {1000, 500, 100, 50,   10, 5, 1};
    String[] rom = {"M","D",  "C", "L", "X", "V", "I"};

    public RomanNumeral(int arabicNumeral) {
        String[] temp  = String.valueOf(arabicNumeral).split("");
        ArrayList<Integer> separatedValue = new ArrayList<>();
        int zeroCount = temp.length - 1;
        for (String str : temp) {
            String tmp = str;
            if (zeroCount > 0) {
                for (int i = 0; i < zeroCount; i++) {
                    tmp+= "0";
                }
                zeroCount--;
            }
            separatedValue.add(Integer.parseInt(tmp));
        }

        //use separated data
        for (int num : separatedValue) {
            romanNumeral+= logic(num);
        }

    }


    String logic(int arabicNumeral) {
        String romanNum = "";
        boolean secTry = false;
        while (arabicNumeral != 0) {
            int t = arabicNumeral;
            for (int i = 0; i < ara.length; i++) {
                int rez = arabicNumeral - ara[i];
                if (rez > 0) {
                    romanNum += rom[i];
                    arabicNumeral -= ara[i];
                    i--;
                } else if (rez == 0) {
                    romanNum += rom[i];
                    arabicNumeral = 0;
                    break;
                } else if (rez < 0 && !IntStream.of(ara).anyMatch(x -> x == t)) {
                    if (IntStream.of(ara).anyMatch(x -> x == rez * -1)) {
                        romanNum += logic(rez * -1);
                        romanNum += rom[i];
                        arabicNumeral = 0;
                        break;
                    }
                }
            }
        }
        return romanNum;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}
