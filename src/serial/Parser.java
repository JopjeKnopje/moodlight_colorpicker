package serial;

import java.awt.*;

import static java.lang.Math.round;

public class Parser
{

    public static String colorToString(Color c)
    {
        return (c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + ", " + "0");
    }

    public static String colorToString1(Color c)
    {
        boolean blueCorrectionEnabled = false;
        int _wTempRed = 255;
        int _wTempGreen = 255;
        int _wTempBlue = 255;


        // Calculate all of the color's white values corrected taking into account the white color temperature.
        float wRed = c.getRed() * (255 / _wTempRed);
        float wGreen = c.getGreen() * (255 / _wTempGreen);
        float wBlue = c.getBlue() * (255 / _wTempBlue);

        // Determine the smallest white value from above.
        int wMin = round(Math.min(wRed, Math.min(wGreen, wBlue)));

        // Make the color with the smallest white value to be the output white value
        int wOut;
        if (wMin == wRed)
            wOut = c.getRed();
        else if (wMin == wGreen)
            wOut = c.getGreen();
        else
            wOut =  c.getBlue();

        // Calculate the output red, green and blue values, taking into account the white color temperature.
        int rOut = round(c.getRed() - wOut * (_wTempRed / 255));
        int gOut = round(c.getGreen() - wOut * (_wTempGreen / 255));
        int bOut = round(c.getBlue() - wOut * (_wTempBlue / 255));

        // Apply the blue correction in enabled.
        //This is required on some RGBW NeoPixels which have a little bit of mixed into the blue color.
        if (blueCorrectionEnabled)
        {
            wOut -= bOut * 0.2;
        }

        // Return the output values.
        return (rOut + ", " + gOut + ", " + bOut + ", " + wOut);
    }



}
