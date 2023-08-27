package gui;

import gui.components.ColorPicker;
import gui.components.ColorPreview;
import gui.components.SerialSelector;
import serial.Parser;
import serial.SerialHandler;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends Window
{

    private final ColorPicker colorPicker;
    private final ColorPreview colorPreview;
    private final SerialSelector serialSelector;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));

        BorderLayout layout = new BorderLayout();

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(0x919191));
        panel.setLayout(layout);

        colorPreview = new ColorPreview();
        serialSelector = new SerialSelector();
        colorPicker = new ColorPicker();
        colorPicker.getSelectionModel().addChangeListener(e ->
        {
            Color color = colorPicker.getColor();
            System.out.println(color);
            // update color preview
            colorPreview.setColor(color);

            if (serialSelector.getOpenedPort() != null)
            {
                // parse color value
                byte[] data = Parser.colorToString(color).getBytes();
                // send over serial
                SerialHandler.send(serialSelector.getOpenedPort(), data);
            }
        });

        colorPreview.setPreferredSize(new Dimension(100, 100));
        serialSelector.setPreferredSize(new Dimension(0, 250));




        layout.setVgap(10);
        layout.setHgap(10);
        panel.add(colorPicker, BorderLayout.CENTER);
        panel.add(colorPreview, BorderLayout.EAST);
        panel.add(serialSelector, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

}
