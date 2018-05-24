package com.jsystems.testautomation.frontedFactory.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class FrontendConfig {

    public WebDriver driver = null;


    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {


        ChromeOptions chromeOptions = new ChromeOptions();


        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
        }


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        driver = null;
    }


}
