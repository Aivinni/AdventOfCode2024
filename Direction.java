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
        this.angle = Math.atan((double) y / x) + 2 * Math.PI;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    public void changeDirection(double angle) {
        this.angle += angle;
        x = (int) Math.round(Math.cos(this.angle));
        y = (int) Math.round(Math.sin(this.angle));
        this.angle = this.angle * (180 / Math.PI);
        if (this.angle >= 360) {
            this.angle -= 360;
        }
        this.angle = Math.round(this.angle);
        this.angle = this.angle * (Math.PI / 180);
    }
}
