package com.mkdsk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static void Pause(long t)
    {
        long timestamp = System.currentTimeMillis();

        do {

        }while (System.currentTimeMillis() < timestamp + t);
    }

    /*
    Returns the formatted current time.
    Used as prefixes in logging messages.
     */
    public static String GetTimePrefix()
    {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));
    }

}
