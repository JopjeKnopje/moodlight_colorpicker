package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

public class MainWindow extends Window
{
    private final JColorChooser colorPicker;

    public MainWindow()
    {
        super("color picker", new Dimension(800, 600));
        panel.setBackground(Color.GRAY);

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        colorPicker = new JColorChooser();
        panel.setBorder(BorderFactory.createTitledBorder(
                                null,
                                "PICK LED COLOR",
                                TitledBorder.CENTER,
                                TitledBorder.TOP,
                                new Font("roboto", Font.BOLD, 18),
                                new Color(0xFFFF9900)
                                ));

        removeColorPickerPanels();


        // Hide the "preview" panel
        colorPicker.setPreviewPanel(new JPanel());



        panel.add(colorPicker);
        pack();
        setVisible(true);
    }

    private void removeColorPickerPanels()
    {
        for (AbstractColorChooserPanel panel : colorPicker.getChooserPanels())
        {
            String name = panel.getDisplayName();
                if (!name.equals("Swatches") && !name.equals("HSV"))
                    colorPicker.removeChooserPanel(panel);
        }
    }
}
