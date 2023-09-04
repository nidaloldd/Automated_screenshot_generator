package org.example.automated_screenshot_generator;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, GeneralSecurityException {

        WebsitePopulator websitePopulator = new WebsitePopulator();

        for (Website website :  websitePopulator.websiteList){
            //ScreenshotMaker.makeScreenshot(website,"src/main/resources/screenshots/");
            ScreenshotMaker.makeScreenshotToDrive(website);
        }



    }
}