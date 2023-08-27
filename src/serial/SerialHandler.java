package serial;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;


public class SerialHandler
{
    static final int BAUDRATE = 9600;
    public static void open(SerialPort port)
    {
        port.setBaudRate(BAUDRATE);
        if (!port.openPort())
        {
            System.out.println("failed opening port " + port.toString());
        }
    }

    public static void close(SerialPort port)
    {
        if (!port.closePort())
        {
            System.out.println("failed closing port " + port.toString());
        }
    }

    public static void send(SerialPort port, byte[] data)
    {
        if (!port.isOpen())
        {
            System.out.println("error port not opened");
            return;
        }
        try
        {
            if (port.writeBytes(data, data.length) != data.length)
            {
                System.out.println("error writing data");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
