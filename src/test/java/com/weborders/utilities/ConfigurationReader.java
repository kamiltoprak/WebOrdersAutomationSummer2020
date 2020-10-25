package com.weborders.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties=new Properties();

    static {
        //try  with  resource
        // allows  to automatically close inout  stream when object os not used any more
        //works  only for the  classes that implement Autoclosable interface
        try (InputStream in = new FileInputStream("configuration.properties")) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration.properties file!");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getProperty("browser"));
    }
}
