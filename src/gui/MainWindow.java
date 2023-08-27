package gui;

import gui.components.ColorPicker;
import gui.components.ColorPreview;
import gui.components.SerialSelector;
import serial.Parser;
import serial.SerialHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends Window
{

    private final ColorPicker colorPicker;
    private final ColorPreview colorPreview;
    private final SerialSelector serialSelector;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (serialSelector.getOpenedPort() != null)
                    SerialHandler.close(serialSelector.getOpenedPort());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        BorderLayout layout = new BorderLayout();

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(0x919191));
        panel.setLayout(layout);

        colorPreview = new ColorPreview();
        colorPreview.setPreferredSize(new Dimension(100, 100));

        colorPicker = new ColorPicker();
        colorPicker.getSelectionModel().addChangeListener(e -> colorPickerHandler());

        serialSelector = new SerialSelector();
        serialSelector.setPreferredSize(new Dimension(0, 250));


        layout.setVgap(10);
        layout.setHgap(10);
        panel.add(colorPicker, BorderLayout.CENTER);
        panel.add(colorPreview, BorderLayout.EAST);
        panel.add(serialSelector, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void colorPickerHandler()
    {
        Color color = colorPicker.getColor();
        // update color preview
        colorPreview.setColor(color);

        String val = Parser.colorToString(color);
        System.out.println("val: [" + val  + "]");
        if (serialSelector.getOpenedPort() != null)
        {
            // parse color value
            byte[] data = val.getBytes();
            // send over serial
            SerialHandler.send(serialSelector.getOpenedPort(), data);
        }
    }
}
