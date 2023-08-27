package serial;

import com.fazecast.jSerialComm.SerialPort;


public class SerialHandler
{
    public static void open(SerialPort port)
    {
        if (!port.openPort())
        {
            System.out.println("failed opening port " + port.toString());
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
