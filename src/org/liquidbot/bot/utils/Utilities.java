package org.liquidbot.bot.utils;

import org.liquidbot.bot.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

/**
 * Created by Kenneth on 7/29/2014.
 */
public class Utilities {

    private static final Random random = new Random();

    /**
     * Used to change the loading of all files
     *
     * @return the directory which files load from
     */
    public static String getContentDirectory() {
        return System.getProperty("user.home") + File.separator + "LiquidBot" + File.separator;
    }

    /**
     * @param point
     * @return check if Point is On Frame
     */
    public static boolean isPointValid(Point point) {
        return Constants.GAME_SCREEN.contains(point);
    }

    /**
     * Sleep Random time between Min and Max
     *
     * @param min
     * @param max
     */
    public static void sleep(int min, int max) {
        sleep(nextInt(min, max));
    }

    /**
     * Sleep Static amount of Time
     *
     * @param amount
     */
    public static void sleep(int amount) {
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Random number between Min and Max
     *
     * @param min
     * @param max
     * @return Random Integer between Min and Max
     */
    public static int nextInt(int min, int max) {
        if (min > max) {
            return max;
        }
        return random.nextInt(max - min) + min;
    }

    /**
     * Uses Toolkit.getDefaultToolkit() to load an image from the specified file location
     *
     * @param file the absolute location of the image
     * @return the image
     */
    public static Image getLocalImage(String file) {
        try {
            return new ImageIcon(Utilities.class.getClass().getResource(file)).getImage();
        } catch (NullPointerException e) {
            System.out.println("[Error] Cannot load this Image " + file);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param string
     * @param strings
     * @return true if contains else false
     */
    public static boolean inArray(String string, String[] strings) {
        if (string == null)
            return false;
        for (String s : strings) {
            if (s.equalsIgnoreCase(string))
                return true;
        }
        return false;
    }

    /**
     * @param i
     * @param array
     * @return true if contains else false
     */
    public static boolean inArray(int i, int[] array) {
        for (int j : array) {
            if (j == i)
                return true;
        }
        return false;
    }

    /**
     *
     * @param region
     * @return Point : random Point inside Polygon
     */
    public static Point generatePoint(Shape region) {
        Rectangle r = region.getBounds();
        double x, y;
        do {
            x = r.getX() + r.getWidth() * Math.random();
            y = r.getY() + r.getHeight() * Math.random();
        } while (!region.contains(x, y));

        return new Point((int) x, (int) y);
    }


}
