package gui;

import de.lars.colorpicker.ColorPicker;
import java.awt.*;

public class MainWindow extends Window
{
    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));
        panel.setBackground(Color.GRAY);

        ColorPicker cp = new ColorPicker(Color.BLUE);
        cp.addColorListener(color ->
        {
            panel.setBackground(color);
            System.out.println(color);
        });


        cp.setBounds(100, 100, 400, 300);

        panel.add(cp);
        setVisible(true);
        pack();
    }
}
