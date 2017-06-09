import java.time.*;

class Gigasecond {

    long seconds = 1000000000;
    long dateInSecFromEpoch;

    Gigasecond(LocalDate birthDate) {
        //to sec from epoch
        this.dateInSecFromEpoch = birthDate.atStartOfDay(ZoneOffset.UTC).toEpochSecond();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        //to sec from epoch
        this.dateInSecFromEpoch = birthDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    LocalDateTime getDate() {
        //return sum 10^9 sec and input date as sec converted to LocalDateTime
        return LocalDateTime.ofEpochSecond(seconds + dateInSecFromEpoch, 0, ZoneOffset.UTC);
    }

}
