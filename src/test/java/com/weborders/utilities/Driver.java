package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Driver {

    // reference  variable  , pointer an  object
    //if  the  reference  variable  does not  point  on  any  object  , it will  have  a  null  value
    // when ever we   type new Class() -  we  createw a new  object
    // reference  type can  be class , parent class   pr interface  implement by  class  or  paratn class
    //since webDriver  is an  interface  implemented  by  Remote Webdroiver  class
    //and RemoteWebDriver  is  aparent  class of ChromeDriver,  firefoxDriver  stc. classes
    // We  can  specify  reference  type as a  WebDriver
    // it helps  to  define  object type  in a run  time (  polymorphism)


    private static WebDriver driver;
    private Driver(){}

    public static WebDriver getDriver() throws IOException {
        if(driver==null){

          /*  Properties properties=new Properties();
            properties.load(new FileInputStream("configuration.properties"));
            String browser =properties.getProperty("browser");*/

            String browser="chrome";

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

                default:
                    throw new RuntimeException("Browser is not implement yes: "+ browser);
            }


        }

        return driver;
    }
}
