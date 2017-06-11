class RaindropConverter {

    String convert(int number) {
        String rez = "";
        if (number % 3 == 0) {
            rez += "Pling";
        }
        if (number % 5 == 0) {
            rez += "Plang";
        }
        if (number % 7 == 0) {
            rez += "Plong";
        }
        if (rez.length() <= 0) {
            return String.valueOf(number);
        } else return rez;

    }
}
