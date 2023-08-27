package gui.components;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
        ArrayList<AbstractColorChooserPanel> panels = new ArrayList<>();

        for (AbstractColorChooserPanel panel : getChooserPanels())
        {
            String name = panel.getDisplayName();
            if (name.equals("Swatches") || name.equals("HSV"))
                panels.add(panel);
            removeChooserPanel(panel);
        }

        Collections.reverse(panels);
        for (AbstractColorChooserPanel panel : panels)
            addChooserPanel(panel);
    }
}
