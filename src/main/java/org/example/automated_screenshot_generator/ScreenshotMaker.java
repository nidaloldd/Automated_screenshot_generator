package org.example.automated_screenshot_generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ScreenshotMaker {
    private static final String CUSTOMERKEY = "9d31e9";
    private static final String SECRETPHRASE = "";
    private static final ScreenshoMachine sm = new ScreenshoMachine(CUSTOMERKEY, SECRETPHRASE);
    private static Map<String, String> options;
    static {
        options = new HashMap<>();
        options.put("url", "https://www.google.com");
        options.put("dimension", "1920x1080");
        options.put("device", "desktop");
        options.put("format", "jpg");
        options.put("cacheLimit", "0");
        options.put("delay", "200");
        options.put("zoom", "100");
    }

    public static void makeScreenshot(Website website,String pathToSave) throws MalformedURLException, IOException, NoSuchAlgorithmException {


        options.put("url", website.URL);

        String apiUrl = sm.generateScreenshotApiUrl(options);
        System.out.println(apiUrl);

        URLConnection openConnection = new URL(apiUrl).openConnection();
        openConnection.addRequestProperty("User-Agent", "Mozilla/4.0");

        InputStream in = openConnection.getInputStream();
        String output = pathToSave+website.ID+"_"+website.NAME+"."+options.get("format");
        Files.copy(in, Paths.get(output), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Screenshot saved as " + output);
    }

    public static void makeScreenshotToDrive(Website website) throws MalformedURLException, IOException, GeneralSecurityException {

        options.put("url", website.URL);

        String apiUrl = sm.generateScreenshotApiUrl(options);
        System.out.println(apiUrl);

        URLConnection openConnection = new URL(apiUrl).openConnection();
        openConnection.addRequestProperty("User-Agent", "Mozilla/4.0");

        InputStream in = openConnection.getInputStream();

        String name = website.ID+"_"+website.NAME+"."+options.get("format");
        String output = "src/main/resources/"+name;

        Files.copy(in, Paths.get(output), StandardCopyOption.REPLACE_EXISTING);
        UploadBasic.uploadBasic(name, output);

        File file = new File(output);
        file.delete();


        System.out.println("Screenshot saved to Drive");
    }
}
