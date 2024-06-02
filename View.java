import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Silindri ja Kera kalkulaator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel cylinderPanel = createCylinderPanel();
        JPanel spherePanel = createSpherePanel();

        tabbedPane.add("Silinder", cylinderPanel);
        tabbedPane.add("Kera", spherePanel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JPanel createCylinderPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JLabel radiusLabel = new JLabel("Raadius:");
        JTextField radiusField = new JTextField(10);
        JLabel heightLabel = new JLabel("Kõrgus:");
        JTextField heightField = new JTextField(10);
        JLabel resultLabel = new JLabel();

        JButton calculateButton = new JButton("Kalkuleeri");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusField.getText());
                    double height = Double.parseDouble(heightField.getText());
                    resultLabel.setText(Controller.calculate(radius, height));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Palun siseta ainult numbrid.");
                }
            }
        });

        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        return panel;
    }

    private static JPanel createSpherePanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JLabel radiusLabel = new JLabel("Raadius:");
        JTextField radiusField = new JTextField(10);
        JLabel resultLabel = new JLabel();

        JButton calculateButton = new JButton("Kalkuleeri");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusField.getText());
                    resultLabel.setText(Controller.calculate(radius));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Palun siseta ainult numbrid.");
                }
            }
        });

        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        return panel;
    }
}
