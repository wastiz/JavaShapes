public class Cylinder extends Shapes {
    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getLateralSurface() {
        return getCircle() * height;
    }

    public double getTotalSurface() {
        return getLateralSurface() + (2 * getRoundSurface());
    }

    public double getVolume() {
        return getRoundSurface() * height;
    }
}
