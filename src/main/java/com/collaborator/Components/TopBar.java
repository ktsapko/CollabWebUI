package com.collaborator.Components;

import com.collaborator.Base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class TopBar extends Browser {
    WebDriver driver;

    @FindBy(how= How.XPATH, using="//a[@title=\"Go to the home page\"]")
    public WebElement HomePageTab; // Home Tab
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Reports')]")
    public WebElement ReportsPageTab; // Reports Tab
    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-user']")
    public WebElement UserSettingsIcon; // User Settings Tab
    @FindBy(how = How.XPATH, using = "//a[@title=\"Site-Wide Administration\"]")
    public WebElement AdminPageTab; // Admin Tab
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Logout')]")
    public WebElement LogoutSubTab; // Logout Sub Tab
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'NEW REVIEW')]")
    public WebElement NewReviewButton; // Logout Sub Tab


    public TopBar(WebDriver driver) {
        this.driver = driver;
    }

    public void AssertAllTopTabs() {
        Assert.assertTrue(HomePageTab.isDisplayed());
        Assert.assertTrue(ReportsPageTab.isDisplayed());
        Assert.assertTrue(UserSettingsIcon.isDisplayed());
    }
}
