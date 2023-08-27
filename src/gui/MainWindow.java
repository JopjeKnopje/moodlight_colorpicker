package gui;

import gui.components.ColorPicker;
import gui.components.SerialSelector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

public class MainWindow extends Window
{

    private final ColorPicker colorPicker;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));

        BorderLayout layout = new BorderLayout();

        panel.setBackground(new Color(0xbebebe));
        panel.setLayout(layout);

        colorPicker = new ColorPicker();
        colorPicker.getSelectionModel().addChangeListener(e ->
        {
            Color color = colorPicker.getColor();
            System.out.println(color);
        });


        panel.add(new SerialSelector());

        panel.add(colorPicker, BorderLayout.PAGE_START);
        pack();
        setVisible(true);
    }
}
