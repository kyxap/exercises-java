/**
 * Created by kyx on 7/15/17.
 */
public class Atbash {

    String encode(String plaintext) {
        String rez = "";
        plaintext = clearStr(plaintext);
        int count = 0;
        for (char c : plaintext.toCharArray()) {
            if (count == 5) {
                rez += " ";
                count = 0;
            }
            rez += encDecChar(c, true);
            count++;
        }
        return rez;
    }

    String decode(String ciphertext) {
        String rez = "";
        ciphertext = clearStr(ciphertext);
        for (char c : ciphertext.toCharArray()) {
            rez += encDecChar(c, false);
        }
        return rez;
    }

    private String clearStr(String str) {
        return str.toLowerCase().replaceAll("[.,\\s]+","");
    }

    private char encDecChar(char c, boolean encOrDec) {
        char rez;
        int a = (int) 'a';
        int z = (int) 'z';
        if (!encOrDec) {
            a = (int) 'z';
            z = (int) 'a';
        }
        if ((int) c >= (int)'0' && (int) c <= (int)'9') {
            rez = c;
        } else {
            rez = (char) (a - (int) c + z);
        }
        return rez;
    }
}
