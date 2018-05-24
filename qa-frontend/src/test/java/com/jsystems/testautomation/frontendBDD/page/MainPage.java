package com.jsystems.testautomation.frontendBDD.page;

import com.jsystems.testautomation.frontedFactory.TestDataHelper;
import com.jsystems.testautomation.frontedFactory.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
   @FindBy(id = "navbar-login-link")

    public WebElement loginButton;

    @FindBy(id = "hero-cta")

    public WebElement getStartedButton;

    @FindBy (css = "a#hero-plans-anchor.button.is-more-link.is-large")
            public WebElement seePlansButton;


    @FindBy (css = "div.hp-hero__wrapper h1 span.no-widows")
    public WebElement wordPressTowerText;


    public boolean isContentPresent() {
       loginButton = driver.findElement(By.id("navbar-login-link"));

        assertTrue(loginButton.isDisplayed());
        assertTrue(getStartedButton.isDisplayed());
        assertTrue(seePlansButton.isDisplayed());
        assertTrue(wordPressTowerText.isDisplayed());
        assertTrue(wordPressTowerText.getText().equals(TestDataHelper.wordPressMainText));
        return true;
    }
}
