package gui.components;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;


/**
 * Panel contains all the control for the serial monitor
 */
public class SerialSelector extends JPanel
{
    private final JComboBox<SerialPortWrapper> portSelector;
    private JButton refreshBtn;
    private JButton connectBtn;

    public SerialSelector()
    {
        super();
        portSelector = new JComboBox<SerialPortWrapper>();

        SerialPort[] ports = SerialPort.getCommPorts();

        for (SerialPort p : ports)
        {
            portSelector.addItem(new SerialPortWrapper(p));
        }



        add(portSelector);
        setBackground(Color.green);
    }
}

/**
 * Wrapper class that for proper naming of the serial port in the selection combobox.
 */
class SerialPortWrapper
{
    private final SerialPort port;

    public SerialPortWrapper(SerialPort port)
    {
        this.port = port;
    }

    public String toString()
    {
        return port.getSystemPortPath() + " (" + port.getDescriptivePortName() + ")";
    }
}
