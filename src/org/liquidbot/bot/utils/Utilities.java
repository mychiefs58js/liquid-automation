package org.liquidbot.bot.utils;

import org.liquidbot.bot.Constants;

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
     *
     * @param point
     * @return check if Point is On Frame
     */
    public static boolean isPointValid(Point point){
        return Constants.GAME_SCREEN.contains(point);
    }

    /**
     * Sleep Random time between Min and Max
     *
     * @param min
     * @param max
     */
    public static void sleep(int min , int max){
        sleep(nextInt(min,max));
    }

    /**
     * Sleep Static amount of Time
     *
     * @param amount
     */
    public static void sleep(int amount){
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
        if(min > max){
            return max;
        }
        return random.nextInt(max - min) + min;
    }

}
