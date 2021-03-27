package compulsory.panels;

import compulsory.panels.ConfigPanel;
import compulsory.panels.ControlPanel;
import compulsory.panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

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

        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
    }

    public void resetCanvas() {
        canvas.removeAll();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}
