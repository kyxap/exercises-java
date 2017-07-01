import java.util.HashMap;
import java.util.Map;

public class RunLengthEncoding {
    public String encode(String data) {
        String rez = "";
        while (data.length() != 0) {
            char firstChar = data.charAt(0);
            int charCount = 0;
            for (int i = 0; i < data.length(); i++) {
                if (firstChar == data.charAt(i)) {
                    charCount++;
                } else break;
            }
            if (charCount > 1) {
                rez += String.valueOf(charCount);
            }
            rez += String.valueOf(firstChar);
            data = data.substring(charCount, data.length());
        }
        return rez;
    }


    public String decode(String encodedData) {
        if (encodedData.length() < 4) {
            return encodedData;
        } else {
            String rez = "";
            String multypl = "";
            char[] dList = encodedData.toCharArray();
            for (char c : dList) {
                if ((int) c >= 48 && (int) c <= 57) {
                    multypl+= String.valueOf(c);
                } else {
                    if (multypl.length() == 0) {
                        multypl = "1";
                    }
                    for (int i = 0; i < Integer.parseInt(multypl); i++){
                        rez += String.valueOf(c);
                    }
                    multypl = "";
                }
            }
            return rez;
        }
    }
}
