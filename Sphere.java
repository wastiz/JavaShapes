public class Sphere extends Shapes {
    public Sphere (double radius) {
        super(radius);
    }

    public double getTotalSurface() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
