package gui.components;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorPicker extends JColorChooser
{
    public ColorPicker()
    {
        super();
        // Remove useless panels
        removeColorPickerPanels();
        // Hide the "preview" panel
        setPreviewPanel(new JPanel());
    }

    private void removeColorPickerPanels()
    {
        for (AbstractColorChooserPanel panel : getChooserPanels())
        {
            String name = panel.getDisplayName();
            if (!name.equals("Swatches") && !name.equals("HSV"))
                removeChooserPanel(panel);
        }
    }

}
