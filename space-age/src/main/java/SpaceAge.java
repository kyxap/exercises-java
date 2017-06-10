import java.time.LocalDateTime;
import java.time.ZoneOffset;

class SpaceAge {

    double secconds = 0;

    SpaceAge(double seconds) {
        this.secconds = seconds;
    }

    double getSeconds() {
        return this.secconds;
    }

    double onEarth() {
        //this.dateInSecFromEpoch = birthDateTime.toEpochSecond(ZoneOffset.UTC);
        return secconds/31557600;
    }

    double onMercury() {
        return onEarth()/0.2408467;
    }

    double onVenus() {
        return onEarth()/0.6151972;
    }

    double onMars() {
        return onEarth()/1.8808158;
    }

    double onJupiter() {
        return onEarth()/11.86261;
    }

    double onSaturn() {
        return onEarth()/29.447498;
    }

    double onUranus() {
        return onEarth()/84.016846;
    }

    double onNeptune() {
        return onEarth()/164.79132;
    }

}
