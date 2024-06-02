import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    public static String calculate (double radius, double height) {
        Cylinder cylinder = new Cylinder(radius, height);
        double lateralSurface = cylinder.getLateralSurface();
        double totalSurface = cylinder.getTotalSurface();
        double volume = cylinder.getVolume();
        String content = "Silinder;" + radius + ";" + height + ";" + totalSurface + ";" + lateralSurface + ";" + volume;
        fileSave(content);
        return "<html>Silindri raadius: " + radius + "<br>Silindri kõrgus: " + height + "<br>Külg pindala: " + lateralSurface + "<br>Kogu pindala: " + totalSurface + "<br>Ruumala: " + volume + "</html>";
    }

    public static String calculate (double radius) {
        Sphere sphere = new Sphere(radius);
        double circumference = sphere.getCircle();
        double totalSurface = sphere.getTotalSurface();
        double volume = sphere.getVolume();
        String content = "Kera;" + radius + ";" + totalSurface + ";" + circumference + ";" + volume;
        fileSave(content);
        return "<html> Kera raadius: " + radius + "<br>Ümbermõõt: " + circumference + "<br>Kogu pindala: " + totalSurface + "<br>Ruumala: " + volume + "</html>";
    }

    public static void fileSave(String content) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("JavaKujundid.txt", true)))) {
            writer.println(content);
            System.out.println("Kõik läks hästi ja on salvestanud.");
        } catch (IOException e) {
            System.err.println("Mingi vea on: " + e.getMessage());
        }
    }
}
