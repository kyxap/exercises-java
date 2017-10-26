public class RotationalCipher {

    private String az = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String az2 = "abcdefghijklmnopqrstuvwxyz";
    private String rotAz;
    private String rotAz2;
    private String rotAz3 = "";
    private String rotAz4 = "";

    public RotationalCipher(int i) {
        this.rotAz = az.substring(i, az.length()) + az.substring(0, i);
        this.rotAz2 = az2.substring(i, az2.length()) + az2.substring(0, i);

    }

    public RotationalCipher(int y, int i) {
        this(y);
        this.rotAz3 = az.substring(i, az.length()) + az.substring(0, i);
        this.rotAz4 = az2.substring(i, az2.length()) + az2.substring(0, i);
    }

    public RotationalCipher(int i, boolean unrotate) {
        this (26-i);
    }

    public RotationalCipher(int y, int i, boolean unrotate) {
        this (26-y,26-i);
    }


    public String rotate(String str) {
        String rez = "";
        String tempAz = "";
        String tempAz2 = "";
        for (int i = 0; i < str.length(); i++) {

            if ((i + 1) % 2 == 0 && rotAz3.length() != 0){
                tempAz = rotAz3;
                tempAz2 = rotAz4;
            } else {
                tempAz = rotAz;
                tempAz2 = rotAz2;
            }


            if (az.indexOf(str.charAt(i)) != -1) {
                rez += tempAz.charAt(az.indexOf(str.charAt(i)));
            } else if (az2.indexOf(str.charAt(i)) != -1) {
                rez += tempAz2.charAt(az2.indexOf(str.charAt(i)));
            } else rez += str.charAt(i);
        }
        return rez;
    }
}
