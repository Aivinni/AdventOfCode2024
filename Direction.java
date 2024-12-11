public class Direction {
    public int x;
    public int y;
    public double angle;

    public Direction() {
        x = 1;
        y = 1;
        this.angle = Math.atan((double) y / x);
    }

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = Math.atan((double) y / x);
    }
}
