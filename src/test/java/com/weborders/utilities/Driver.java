package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public static WebDriver getDriver(){
        if(driver==null){
            String browser="chrome";

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new ChromeDriver();
                    break;

                default:
                    throw new RuntimeException("Browser is not implement yes: "+ browser);
            }


        }

        return driver;
    }
}
