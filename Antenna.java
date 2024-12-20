import java.awt.*;

public class Antenna {
    public final String frequency;
    public final Point location;
    public Antenna(String freq, Point point) {
        frequency = freq;
        location = point;
    }

    @Override
    public String toString() {
        return "Frequency: " + frequency + " " + location;
    }
}
