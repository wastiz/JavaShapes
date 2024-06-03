import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View {
    public static void start () {
        JFrame frame = new JFrame("Silindri ja Kera kalkulaator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Saame JavaKujundid.txt asukoht ja lisame label'sse
        String currentDirectory = System.getProperty("user.dir");
        File file = new File(currentDirectory, "JavaKujundid.txt");
        String filePath = file.getAbsolutePath();
        JLabel label = new JLabel("Kõik tulemused asuvad: " + filePath);

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(label);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Silinder", createCylinderPanel());
        tabbedPane.add("Kera", createSpherePanel());

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(labelPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static JPanel createCylinderPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

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

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(radiusLabel, gbc);

        gbc.gridx = 1;
        panel.add(radiusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(heightLabel, gbc);

        gbc.gridx = 1;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        return panel;
    }

    private static JPanel createSpherePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel radiusLabel = new JLabel("Siseta kera raadius:");
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

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(radiusLabel, gbc);

        gbc.gridx = 1;
        panel.add(radiusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        return panel;
    }
}
