public class Transpose {
    public String transpose(String input) {
        String[] tmp;
        if (input.length() == 0) {
            return "";
        } else if (!input.contains("\n")){
            return putEnterEveryN(input);
        } else {
            tmp = input.split("\n");
            return makeSome(tmp);
        }
    }

    String putEnterEveryN(String str) {
        str = str.replace("", "\n");
        return str.substring(1, str.length() - 1);
    }

    String makeSome(String[] str) {
        String rez = "";

        int max = biggestStrInAr(str);
        str = makeFirsMaxSleng(str, max);
        for (int i = 0; i < max; i++) {
            for (String s : str) {
                try {
                    rez+= s.charAt(i);
                } catch (Exception e) {
                    rez+= " ";
                }
            }
            rez += "\n";
        }

        return rez.replaceAll("(\\n|\\s+)$","");
    }

    int biggestStrInAr(String[] ar) {
        int max = 0;
        for (String s : ar) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    String[] makeFirsMaxSleng(String[] str, int max) {
        while (str[0].length() != max) {
            str[0] = str[0] + " ";
        }
        return str;
    }
}
