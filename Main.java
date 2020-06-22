package com.mkdsk

import java.io.InputStream;
import java.lang.Process;
import java.util.Scanner;

/* Created by mkdsk on 6/22/20 */

public class Main {

    static String response; // JSON response received from Spotify
    static String l_Name; // The name of the song that was last received
    static String token;

    static int tokenTimer = 0; // Increased by 1 every minute. Once it's 60 (an hour), we reset our token.

    public static void main(String[] args) {

        UpdateToken(); // Get our token on startup

        while(true){
            tick();
            Util.Pause(60000);
            tokenTimer++;
            if(tokenTimer == 60)
            {
                UpdateToken();
                tokenTimer = 0; // Reset clock
            }
        }

    }

    /* Called every 60 seconds */
    public static void tick() {
        String get = "curl -X \"GET\" \"https://api.spotify.com/v1/me/player?market=ES&additional_types=episode\" " +
                "-H \"Accept: application/json\" -H \"Content-Type: " +
                "application/json\" -H \"Authorization: Bearer " + token;
        try{
            Process process = Runtime.getRuntime().exec(get);
            InputStream is = process.getInputStream();
            Scanner s = new Scanner(is).useDelimiter("\\A");
            response = s.hasNext() ? s.next() : ""; 
            process.destroy();

        }catch(Exception f){
            System.out.println("Error!");
            System.exit(0);
        }

        if(l_Name != getName(response)) // Make sure we don't log duplicates
        {
            log(getArtist(response), getName(response));
        }

    }

    public static void log(String artist, String title)
    {
        // Log to the individual song log file as well as the main file!
        //TODO: Make this work.
    }

    // Called every hour. Resets our token variable.
    public static void UpdateToken()
    {
        //TODO: Do some GET shit here to get a new token.
    }

    public static String getArtist(String json) /// Maybe JSON object as parameter?
    {
        //TODO: Separate artist name from JSON data.
        return "dsadasdas";
    }

    public static String getName(String json) /// Maybe JSON object as parameter?
    {
        //TODO: Separate name from JSON data.
        return "dsadasdas";
    }

}
