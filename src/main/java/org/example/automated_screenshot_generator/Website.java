package org.example.automated_screenshot_generator;

public class Website {

    private final int id;
    private final String name;
    private final String url;
    public Website(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
