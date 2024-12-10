public class Direction {
    public int x;
    public int y;
    public double angle;

    public Direction() {
        x = 1;
        y = 1;
        this.angle = Math.atan((double) y / x);
    }
}
