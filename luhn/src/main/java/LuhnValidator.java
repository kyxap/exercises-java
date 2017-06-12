final class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");
        int sum = 0;
        if (candidate.length() > 1){
            int count = 1;
            candidate = new StringBuilder(candidate).reverse().toString();
            for (char ch : candidate.toCharArray()) {
                if ((int) ch < 48 || (int) ch > 57){
                    return false;
                }
                int s = Integer.parseInt(String.valueOf(ch));
                if (count % 2 == 0){
                    if ( s * 2 > 9) {
                        sum += (s * 2) - 9;
                    } else {
                        sum += s*2;
                    }
                } else {

                    sum += s;
                }
                count++;
            }
            return sum % 10 == 0;
        } else return false;
    }

}
