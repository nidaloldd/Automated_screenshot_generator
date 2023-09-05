package org.example.automated_screenshot_generator;

import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;

public class WebsitePopulator {

    public List<Website> websiteList = new ArrayList<>();

    public WebsitePopulator(){
        websiteList.add(new Website(1,"iFunded","https://ifunded.de/en/"));
        websiteList.add(new Website(2,"Property Partner","www.propertypartner.co"));
        websiteList.add(new Website(3,"Property Moose","propertymoose.co.uk"));
        websiteList.add(new Website(4,"Homegrown","www.homegrown.co.uk"));
        websiteList.add(new Website(5,"Realty Mogul","https://www.realtymogul.com"));

        Logger.info("websiteList was populated");
    }
}
