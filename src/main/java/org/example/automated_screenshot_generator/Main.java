package org.example.automated_screenshot_generator;

import org.tinylog.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class Main {
    public static void main(String[] args) throws GeneralSecurityException, IOException {

        WebsitePopulator websitePopulator = new WebsitePopulator();

        try {
            for (Website website :  websitePopulator.websiteList){
                //ScreenshotMaker.makeScreenshot(website,"src/main/resources/screenshots/");
                ScreenshotMaker.makeScreenshotToDrive(website);
            }
        }
        catch (Exception e){
            Logger.error(e);
        }



    }
}