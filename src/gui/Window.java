package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public abstract class Window extends JFrame
{
    protected JPanel panel;

    public Window(String title, Dimension size)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(size);

        centerWindow();
        initPanel();

        setTitle(title);
        setResizable(true);
        panel.setLayout(null);
    }

    private void centerWindow()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int x = (screenSize.width - getWidth());
        int y = (screenSize.height - getHeight()) / 4;
        this.setLocation(x, y);
    }

    private void initPanel()
    {
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        setContentPane(panel);
    }
}