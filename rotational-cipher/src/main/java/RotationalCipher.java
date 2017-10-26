public class RotationalCipher {
    int rotation = 0;
    int max = (int)'z' - (int)'a' + 1;

    public RotationalCipher(int i) {
        while (i - max >= 0) {
            i = i - max;
        }
        this.rotation = i;
    }

    public RotationalCipher(int i, int y) {
        while (i - max >= 0) {
            i = i - max;
        }
        this.rotation = i;
    }

    public String rotate(String str) {
        String rez = "";
        for (char c : str.toCharArray()) {
            if (c >= 'A') {
                int biggest = findMax(c);
                if ((int)c + rotation > biggest){
                    rez += (char)(biggest - max + ((int) c + rotation - biggest));
                } else {
                    rez+= (char)((int) c + rotation);
                }
            } else {
                rez+= c;
            }
        }
        return rez;
    }

    int findMax(char c) {
        if (c >= 'A' && c <= 'Z') {
           return (int)'Z';
        } else if (c >= 'a' && c <= 'z'){
            return (int) 'z';
        } else return 127;
    }
}
