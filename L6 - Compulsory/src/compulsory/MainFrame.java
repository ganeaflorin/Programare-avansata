package compulsory;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel canvas;
    ControlPanel controlPanel;

    public MainFrame() {
        super("Laborator GUI!");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this, configPanel);

        add(controlPanel, BorderLayout.NORTH);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
    }
}
