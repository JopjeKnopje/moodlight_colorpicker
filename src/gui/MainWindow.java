package gui;

import gui.components.ColorPicker;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

public class MainWindow extends Window
{

    final ColorPicker colorPicker;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));

        BorderLayout layout = new BorderLayout();

        panel.setBackground(Color.GRAY);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createTitledBorder(
                                null,
                                "PICK LED COLOR",
                                TitledBorder.CENTER,
                                TitledBorder.TOP,
                                new Font("roboto", Font.BOLD, 18),
                                new Color(0xFFFF9900)
                                ));

        colorPicker = new ColorPicker();

        panel.add(colorPicker);
        pack();
        setVisible(true);
    }

}
