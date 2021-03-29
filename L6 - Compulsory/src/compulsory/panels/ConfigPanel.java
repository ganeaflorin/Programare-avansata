package compulsory.panels;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox color; // the color of the shape
    JTextField sizeField;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JTextField getSizeField() {
        return sizeField;
    }

    public JComboBox getColor() {
        return color;
    }

    private void init() {
        //size label
        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField(3);
        sizeField.setText("100");
        add(sizeLabel);
        add(sizeField);

        //sides label
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(3); //default number of sides
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);

        JLabel colorLabel = new JLabel("Color:");
        String[] colors = {"Random", "Black"};
        color = new JComboBox(colors);
        add(colorLabel);
        add(color);

    }

    public void setSidesField(int sides) {
        this.sidesField.setValue(sides);
    }
}
