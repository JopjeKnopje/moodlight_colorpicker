package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

public class MainWindow extends Window
{
    private final JColorChooser colorPicker;
    private final BorderLayout layout;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));
        panel.setBackground(Color.GRAY);
        layout = new BorderLayout();
        panel.setLayout(layout);

        colorPicker = new JColorChooser();
        colorPicker.setBorder(BorderFactory.createTitledBorder(
                                null,
                                "Pick led color",
                                TitledBorder.CENTER,
                                TitledBorder.TOP
                                ));

        removeColorPickerPanels();

        panel.add(colorPicker);
        pack();
        setVisible(true);
    }

    private void removeColorPickerPanels()
    {
        final String[] PANEL_NAMES = { "HSL", "RGB", "CMYK" };

        AbstractColorChooserPanel[] panels = colorPicker.getChooserPanels();

        for (AbstractColorChooserPanel panel : panels)
        {
            for (String s : PANEL_NAMES)
            {
                if (panel.getDisplayName().equals(s))
                    colorPicker.removeChooserPanel(panel);
            }
        }
    }

}
