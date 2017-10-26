import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RotationalCipherTest {

    private RotationalCipher rotationalCipher;

    @Test
    public void task6() {
        rotationalCipher = new RotationalCipher(14, 24, true);
        Assert.assertEquals("The original name of Java was Oak.", rotationalCipher.rotate("Hfs cpwewloj loks cd Hoto kyg Cyy."));
    }

    @Test
    public void task8() throws IOException {
        rotationalCipher = new RotationalCipher(17, 4, true);
        URL url = new URL("http://www.dukelearntoprogram.com/java/mysteryTwoKeysQuiz.txt");
        Scanner s = new Scanner(url.openStream());
        Assert.assertEquals("Duke Computer Science Department Overview", rotationalCipher.rotate(s.nextLine()));
    }

    @Test
    public void task5() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/manywords.txt");
        Scanner s = new Scanner(url.openStream());
        Map<Integer, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String[] ar = s.nextLine().split(" ");
            for (String word : ar) {

                if (!map.containsKey(word.length())) {
                    map.put(word.length(), 1);
                } else map.computeIfPresent(word.length(), (k, v) -> v + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        Assert.assertEquals(map, false);
    }

    @Test
    public void task4() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/errors.txt");
        Scanner s = new Scanner(url.openStream());
        Map<Integer, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.replaceAll("[^a-zA-Z\\s]", "");
            String[] ar = str.split(" ");
            for (String word : ar) {

                System.out.println(word);
                if (!map.containsKey(word.length())) {
                    map.put(word.length(), 1);
                } else map.computeIfPresent(word.length(), (k, v) -> v + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        Assert.assertEquals(map, false);
    }


    /**
     * Week 2:
     * 1:The “if condition” is always false in the loop, so the else part is always executed. This always results in a second random word.
     * The “if condition” is always false the first time in the loop, so the else part is executed the first time through the loop. This means the while loop always executes its body at least twice so some words may be used a second time.
     * +++If a word is a repeated word, then this code gets another random word and uses that second word without checking to see if it is a repeated word.
     * 2: processWord +
     * 3: 3721+
     * 3722 -
     * 2696 -
     * 3714 -
     * 4: of +
     * 5: 609 +
     * 6: ADRIANA +
     * 7: 79 +
     * 8: 3 +
     * 9: 32 +
     * 10: 12 +
     * 11:CAA / 7 CAG / 7 +
     * 12: 135821 -; 530-; 526-; 1-; 529
     * 13: 96801 - ; 2177-; 2172-; 7-; 2176
     * 14: laid - caesar.txt + ! likeit - see + !RANDOM WORD
     * 15: macbeth, romeo, likeit -;             confucius.txt  "likeit.txt "macbeth.txt", "romeo.txt"+
     * 16: readIt +
     * 17: initializeFromSource +
     * 18: for (ArrayList<String> wordlist : myMap.keySet()) {
     * and highlighted         sum += 1; -
     *
     * for (ArrayList<String> wordlist : myMap.keySet()) { ; for (ArrayList<String> wordlist : myMap.keySet()) {;
     * 19: processWord+
     *
     */
    @Test
    public void task2_3() throws IOException {

        URL url = new URL("http://www.dukelearntoprogram.com/java/errors.txt");
        Scanner s = new Scanner(url.openStream());
        Set<String> uniq = new HashSet<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.toLowerCase();
            String[] ar = str.split(" ");
            for (String word : ar) {
                if (word.length() > 1) {
                    uniq.add(word);
                }
            }
        }
        for (String word : uniq) {
            System.out.println(word);
        }
        System.out.println("Uniq words: " + uniq.size() );
        Assert.assertEquals(true, false);
    }

    public Map<String, Integer> countWordFromFile(String filename) throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/" + filename);
        Scanner s = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.toLowerCase();
            String[] ar = str.split(" ");
            for (String word : ar) {
                if (word.length() > 1) {
                    if (!map.containsKey(word)) {
                        map.put(word, 1);
                    } else map.computeIfPresent(word, (k, v) -> v + 1);
                }
            }
        }

        return map;
    }


    @Test
    public void temp() {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        Map<ArrayList<String>, Integer> myMap = new HashMap<>();
        myMap.put(a, 1);
        myMap.put(a, 2);
//        int sum = 0;
//        for (ArrayList<String> wordlist : myMap.keySet()) {
//            sum += wordlist.size();
//        }

//        int sum = 0;
//        for (ArrayList<String> wordlist : myMap.keySet()) {
//            for (String word : wordlist) {
//                sum += 1;
//            }
//        }
        System.out.println(sum);


        Assert.assertEquals(3, sum);
    }

    @Test
    public void task2_12() throws IOException {
        String[] namex = new String[]{"caesar.txt", "confucius.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        ArrayList<Map<String, Integer>> arrayList = new ArrayList<>();
        for (String name : namex) {
            arrayList.add(countWordFromFile(name));
        }

        boolean state = true;
        Map<String, Integer> rez = new HashMap<>();
        for (Map.Entry<String, Integer> entry : arrayList.get(0).entrySet()) {
            state = true;
            for(Map<String, Integer> map : arrayList){
                if (!map.containsKey(entry.getKey())){
                    state = false;
                }
            }
            if (state) {
                rez.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Uniq in 7: " + rez.size());
        Assert.assertEquals(true, false);
    }

    @Test
    public void task2_15() throws IOException {
        String[] namex = new String[]{"caesar.txt", "confucius.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        ArrayList<Map<String, Integer>> arrayList = new ArrayList<>();
        for (String name : namex) {
            arrayList.add(countWordFromFile(name));
        }

        int coun = 0;
        for (Map<String, Integer> entry : arrayList) {
            for (Map.Entry<String, Integer> e : entry.entrySet()){
                if (e.getKey().equals("tree")){
                    System.out.println(coun);
                }
            }
            coun++;

        }
        System.out.println(arrayList.get(0).size());
        Assert.assertEquals(true, false);
    }

    @Test
    public void task2_13() throws IOException {
        String[] namex = new String[]{"caesar.txt", "confucius.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        ArrayList<Map<String, Integer>> arrayList = new ArrayList<>();
        for (String name : namex) {
            arrayList.add(countWordFromFile(name));
        }

        int state = 0;
        Map<String, Integer> rez = new HashMap<>();
        for (Map.Entry<String, Integer> entry : arrayList.get(0).entrySet()) {
            state = 1;
            for(Map<String, Integer> map : arrayList){
                if (map.containsKey(entry.getKey())){
                    state++;
                }
            }
            if (state >= 4) {
                rez.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Uniq in 4: " + rez.size());
        Assert.assertEquals(true, false);
    }

    @Test
    public void task2_9() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/dnaMystery2.txt");
        Scanner s = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();
        String dna = s.nextLine();
        dna = dna.substring(2,dna.length());
//        String dna = "CGTTCAAGTTCAA";
        while (dna.length() >= 3) {
            String word = dna.substring(0, 3);

            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else map.computeIfPresent(word, (k, v) -> v + 1);

            dna = dna.substring(3, dna.length());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
                System.out.println(entry.getKey() + " / " + entry.getValue());
        }
        System.out.println("Uniq words: " + map.size() );
        Assert.assertEquals(true, false);
    }

    @Test
    public void task2_4() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/errors.txt");
        Scanner s = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.toLowerCase();
            str = str.replaceAll("  ", "");
            String[] ar = str.split(" ");
            for (String word : ar) {
//                System.out.println(word);
                if (word.equals(" ")){
                    continue;
                }
                else if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else map.computeIfPresent(word, (k, v) -> v + 1);
            }
        }

        String mostOffen = "";
        int temp = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {

            if (entry.getValue() > temp) {
                System.out.println(entry.getKey() + " / " + entry.getValue());
                mostOffen = entry.getKey();
                temp = entry.getValue();
            }
        }
        System.out.println("Rez:" + mostOffen + "/ " + temp);
        Assert.assertEquals(map, false);
    }

    @Test
    public void task2_6() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/errors.txt");
        Scanner s = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.replaceAll("\\s+", " ");
            String[] ar = str.split("[.]");
            for (String word : ar) {
//                System.out.println(word);
                if (word.equals(" ")){

                }
                else if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else map.computeIfPresent(word, (k, v) -> v + 1);
            }
        }


        String mostOffen = "";
        int temp = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > 90) {
                System.out.println(entry.getKey() + " / " + entry.getValue());
            }
            if (entry.getValue() > temp && entry.getValue() < 100) {
//                System.out.println(entry.getKey() + " / " + entry.getValue());
                mostOffen = entry.getKey();
                temp = entry.getValue();
            }
        }
        System.out.println("Rez:" + mostOffen + "/ " + temp);
        Assert.assertEquals(map, false);
    }

    @Test
    public void task2_7() throws IOException {
        URL url = new URL("http://www.dukelearntoprogram.com/java/errors.txt");
        Scanner s = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();
        while (s.hasNext()) {
            String str = s.nextLine();
            str = str.replaceAll("\\s+", " ");
            String[] ar = str.split("[.]");
            for (String word : ar) {
//                System.out.println(word);
                if (word.equals(" ")){

                }
                else if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else map.computeIfPresent(word, (k, v) -> v + 1);
            }
        }


        String mostOffen = "";
        int temp = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > 60) {
                System.out.println(entry.getKey() + " / " + entry.getValue());
            }
            if (entry.getValue() > temp && entry.getValue() < 100) {
//                System.out.println(entry.getKey() + " / " + entry.getValue());
                mostOffen = entry.getKey();
                temp = entry.getValue();
            }
        }
        System.out.println("Rez:" + mostOffen + "/ " + temp);
        Assert.assertEquals(map, false);
    }

    @Test
    public void taskTemp() throws IOException {
        //rotationalCipher = new RotationalCipher(12, 10, true);
//        String str = "Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.";

        URL url = new URL("http://www.dukelearntoprogram.com/java/mysteryTwoKeysQuiz.txt");


        for (int i = 1; i <= 1; i++) {
            Scanner s = new Scanner(url.openStream());
            int randomNum = ThreadLocalRandom.current().nextInt(1, 26 + 1);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 26 + 1);
            System.out.println(randomNum + " " + randomNum2);
            while(s.hasNext()) {
                rotationalCipher = new RotationalCipher( randomNum, randomNum2, true);

                System.out.println(rotationalCipher.rotate(s.nextLine()));
            }
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("==============================================");

//           System.out.println("key: " + randomNum + " " + randomNum2 + " " + rotationalCipher.rotate(str));
        }
        Assert.assertEquals(true, false);
    }

    @Test
    public void task7() {
        rotationalCipher = new RotationalCipher(7, 19, true);
        Assert.assertEquals("The name of the Java Mascot is Duke. Woeoeee!", rotationalCipher.rotate("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
    }

    @Test
    public void firstOneIAM() {
        rotationalCipher = new RotationalCipher(17);
        Assert.assertEquals("Z RD", rotationalCipher.rotate("I AM"));
    }

    @Test
    public void firstOneIAM1() {
        rotationalCipher = new RotationalCipher(17, true);
        Assert.assertEquals("I AM", rotationalCipher.rotate("Z RD"));
    }

    @Test
    public void testABAT() {
        rotationalCipher = new RotationalCipher(15);
        Assert.assertEquals("Rpc ndj xbpvxct axut LXIWDJI iwt xcitgcti PCS rdbejitgh xc ndjg edrzti?", rotationalCipher.rotate("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }

    @Test
    public void long2key() {
        rotationalCipher = new RotationalCipher(15, 8);
        Assert.assertEquals("Ric nwj xupoxvt aqum EXBWWJB bwm qcbtzcmi PVS rwbxjbtzh xv gdcg ewrstb?", rotationalCipher.rotate("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }


    @Test
    public void long2keyBack() {
        rotationalCipher = new RotationalCipher(15, 8, true);
        Assert.assertEquals("Can you imagine life WITHOUT the internet AND computers in your pocket?", rotationalCipher.rotate("Ric nwj xupoxvt aqum EXBWWJB bwm qcbtzcmi PVS rwbxjbtzh xv gdcg ewrstb?"));
    }

    @Test
    public void testaBAT() {
        rotationalCipher = new RotationalCipher(19);
        Assert.assertEquals("t UTM", rotationalCipher.rotate("a BAT"));
    }

    @Test
    public void test1() {
        rotationalCipher = new RotationalCipher(15);
        Assert.assertEquals("Rpc ndj xbpvxct axut LXIWDJI iwt xcitgcti PCS rdbejitgh xc ndjg edrzti?", rotationalCipher.rotate("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }

    @Test
    public void test2() {
        rotationalCipher = new RotationalCipher(21, 8, true);
        RotationalCipher rotationalCipher2 = new RotationalCipher(26-21, 26-8, true);
        Assert.assertEquals("Hss dgz nefynfj qakw ONLMGZL lmw asljjswy FFI hgrhzljjx nf qtmw ughcjl?", rotationalCipher.rotate("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
        Assert.assertEquals("Can you imagine life WITHOUT the internet AND computers in your pocket?", rotationalCipher2.rotate("Hss dgz nefynfj qakw ONLMGZL lmw asljjswy FFI hgrhzljjx nf qtmw ughcjl?"));
    }

    @Test
    public void rotatePunctuation() {
        rotationalCipher = new RotationalCipher(21);
        Assert.assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!"));
    }

    @Test
    public void rotateAllLetters() {
        rotationalCipher = new RotationalCipher(13);
        Assert.assertEquals("The quick brown fox jumps over the lazy dog.",
                rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
    }

    @Test
    @Ignore
    public void rotateAllLetters2() {
        rotationalCipher = new RotationalCipher(15);
        Assert.assertEquals("NA",
                rotationalCipher.rotate("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }
}
