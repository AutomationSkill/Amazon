package com.amazon.constants;

/**
 * Created by arulelango on 18/03/18.
 */
public enum Browsers {

    FIREFOX,
    CHROME,
    IE,
    SAFARI;

    public static Browsers obtainBrowser(String browser) throws IllegalArgumentException {
        for (Browsers b : values()) {
            if (b.toString().equalsIgnoreCase(browser)) {
                return b;
            }
        }
        return CHROME;
    }

}
