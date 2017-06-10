final class Acronym {

    String phrase = "";
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        return createAcronym(phrase);
    }

    private String createAcronym(String phrase) {
        String arc = "";
        arc += phrase.substring(0,1);
        for (int i = 1; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(" ") || phrase.substring(i, i + 1).equals("-")) {
                arc += phrase.substring(i + 1, i + 2);
            }
        }
        return arc.toUpperCase();
    }

}
