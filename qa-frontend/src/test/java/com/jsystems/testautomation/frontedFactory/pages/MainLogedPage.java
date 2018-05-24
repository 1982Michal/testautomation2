package com.jsystems.testautomation.frontedFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainLogedPage extends BasePage{
    WebDriver driver;

    public MainLogedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    @FindBy(css = "svg.gridicon.gridicons-user-circle")
    public WebElement avatar;


}
