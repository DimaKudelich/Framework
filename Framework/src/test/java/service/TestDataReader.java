package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");
    //private static ResourceBundle resourceBundle = ResourceBundle.getBundle("dev.properties");

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
