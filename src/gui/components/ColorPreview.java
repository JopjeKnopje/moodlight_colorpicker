package gui.components;

import javax.swing.*;
import java.awt.*;

public class ColorPreview extends JPanel
{
    public ColorPreview()
    {
        super();
    }

    public void setColor(Color c)
    {
        setBackground(c);
    }


}
