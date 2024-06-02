abstract class Shapes {
    double radius;

    public Shapes(double radius) {
        this.radius = radius;
    }

    protected double getCircle() {
        return 2 * Math.PI * radius;
    }

    protected double getRoundSurface () {
        return Math.PI * Math.pow(radius, 2);
    }

}
