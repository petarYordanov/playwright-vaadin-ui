package com;

import java.util.ResourceBundle;

public class Utils {

    public static String getEnvProperty(String property) {
        ResourceBundle environmentBundle = ResourceBundle.getBundle("env");
        return environmentBundle.getString(property);
    }
}
