import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> sL = new ArrayList<>();
        String binaryString = Integer.toBinaryString(number);
        String temp = "";
        for (int i = 0; i < 5 - binaryString.length(); i++) {
           temp += "0";
        }
        binaryString = temp + binaryString;

        System.out.println(binaryString);
        int count = 0;
        boolean reverse = true;
        for (char b: binaryString.toCharArray()){
            if (b == '1') {
                if (count == 0) {
                    reverse = false;
                } else if (count == 1){
                    sL.add(Signal.JUMP);
                } else if (count == 2) {
                    sL.add(Signal.CLOSE_YOUR_EYES);
                } else if (count == 3) {
                    sL.add(Signal.DOUBLE_BLINK);
                } else if (count == 4) {
                    sL.add(Signal.WINK);
                }
            }
            count++;
        }
        if (reverse) {
            Collections.reverse(sL);
        }
        return sL;
    }
}
