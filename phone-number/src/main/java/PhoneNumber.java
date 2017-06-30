/**
 * Created by kyx on 6/29/17.
 */
public class PhoneNumber {
    private String actualNumber;
    private boolean numState = true;


    public PhoneNumber(String s) {

        this.actualNumber = verifyNum(cleanNum(s));

    }

    public String getNumber() {
        return this.actualNumber;
    }

    String cleanNum(String num) {
        String rez = "";
        char[] numAr = num.toCharArray();
        for (char c : numAr) {
            if ((int) c >= 48 && (int) c <= 57) {
                rez += String.valueOf(c);
            }
            if ((int) c > 57) {
                this.numState = false;
            }
        }

        return rez;
    }


    String verifyNum(String num) {
//        System.out.println(num.length());
        if (!this.numState) {
            throw new IllegalArgumentException("Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");
        }
        else if (num.length() < 10 || num.length() > 11) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        } else if (num.length() == 11 && num.substring(0, 2).equals("11")) {
            return num.substring(1, num.length());
        } else if (num.length() == 11 && !num.substring(0, 1).equals("1")) {
            throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");

        }
            else return num;
    }
}
