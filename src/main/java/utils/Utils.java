package utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:17
 */

public final class Utils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private Utils() {}

    public static Boolean getRndBoolean() {
        return Math.random() < 0.5;
    }

    public static int getRandomInt(int maxValue) {
        return 1 + (int)(Math.random() * maxValue);
    }

    public static int getRndInt(int minValue, int maxValue) {
        return 1 + (int)(Math.random() * ((maxValue - minValue) + 1));
    }

    public static String getRndString(String stringBeginning, int stringLength) {
        return String.format(stringBeginning + "%s", UUID.randomUUID()).replace("-", "").substring(0, stringLength);
    }

    public static String getRndString(int stringLength) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, stringLength);
    }

    public static String getTodayDate() {
        Date dt = new Date();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(dt);
    }

    public static String getTodayDate2() {
        Date dt = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");

        return sdf.format(dt);
    }
}
