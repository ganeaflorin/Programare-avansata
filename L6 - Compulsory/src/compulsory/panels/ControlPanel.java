package compulsory.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private BufferedImage img;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {

                ImageIO.write(frame.canvas.image, "PNG", new File(fileChooser.getSelectedFile().getPath()));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void load(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                frame.getCanvas().setCanvas(ImageIO.read(fileChooser.getSelectedFile()));

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void reset(ActionEvent e) {
        frame.getCanvas().resetCanvas();
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }


}
