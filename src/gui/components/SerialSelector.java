package gui.components;

import com.fazecast.jSerialComm.SerialPort;
import serial.SerialHandler;

import javax.swing.*;
import java.awt.*;


/**
 * Panel contains all the control for the serial monitor
 */
public class SerialSelector extends JPanel
{
    private final JComboBox<SerialPortWrapper> portSelector;
    private SerialPort openedPort;

    public SerialSelector()
    {
        super();
        portSelector = new JComboBox<>();
        JButton refreshBtn = new JButton("refresh");
        JButton connectBtn = new JButton("connect");

        refreshBtn.addActionListener(e -> refreshPorts());
        connectBtn.addActionListener(e -> connectPort(portSelector.getSelectedItem()));

        refreshPorts();

        add(portSelector);
        add(refreshBtn);
        add(connectBtn);
        setBackground(Color.green);

        openedPort = null;
    }

    private void connectPort(Object p)
    {
        SerialPortWrapper wrapperPort = (SerialPortWrapper) p;
        System.out.println("connected with " + wrapperPort.toString());
        openedPort = wrapperPort.port();
        SerialHandler.open(openedPort);
    }


    private void refreshPorts()
    {
        SerialPort[] ports = SerialPort.getCommPorts();
        portSelector.removeAllItems();

        for (SerialPort p : ports)
        {
            portSelector.addItem(new SerialPortWrapper(p));
        }
    }

    public SerialPort getOpenedPort()
    {
        return openedPort;
    }
}

/**
 * Wrapper for proper naming of the serial port in the selection combobox.
 */
record SerialPortWrapper(SerialPort port)
{
    public String toString()
    {
        return port.getSystemPortPath() + " (" + port.getDescriptivePortName() + ")";
    }
}
