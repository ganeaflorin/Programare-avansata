package compulsory.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShapesPanel extends JPanel {
    final MainFrame frame;
    JButton circleBtn = new JButton("Circle");
    JButton triangleBtn = new JButton("Triangle");
    JButton diamondBtn = new JButton("Diamond");

    public ShapesPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(3, 1));
        circleBtn.addActionListener(this::circle);
        triangleBtn.addActionListener(this::triangle);
        diamondBtn.addActionListener(this::diamond);
        add(circleBtn);
        add(triangleBtn);
        add(diamondBtn);
    }

    private void circle(ActionEvent actionEvent) {
        frame.getConfigPanel().setSidesField(100);
    }

    public void triangle(ActionEvent actionEvent) {
        frame.getConfigPanel().setSidesField(3);
    }

    public void diamond(ActionEvent actionEvent) {
        frame.getConfigPanel().setSidesField(4);
    }

}
