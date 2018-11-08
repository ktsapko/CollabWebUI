package com.collaborator.Pages;

import com.collaborator.Base.Browser;
import com.collaborator.Components.TopBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Dashboard extends Browser {
    WebDriver driver;
    Actions actions;
    public TopBar topBar;
    public AdminPage adminPage;
    public ReviewPage reviewPage;

    @FindBy(how = How.XPATH, using = "//div[@class='PageContent']//h1")
    WebElement ReportsPageTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='PageContent']//h1")
    WebElement AdminPageTitle;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        topBar = PageFactory.initElements(this.driver, TopBar.class);
        adminPage = PageFactory.initElements(this.driver, AdminPage.class);
        reviewPage = PageFactory.initElements(this.driver, ReviewPage.class);
    }

    public void OpenAdmin() {
        topBar.AdminPageTab.click();
        wait(Wait2Seconds);
        Boolean SystemTabIsVisible = AdminPageTitle.isDisplayed();
        Assert.assertTrue(SystemTabIsVisible);
        log.info("Admin page was opened");
    }
    public void OpenReports() {
        topBar.ReportsPageTab.click();
        wait(Wait2Seconds);
        Assert.assertEquals(ReportsPageTitle.getText(), "Reports");
        log.info("Reports page was opened");
    }

    public void Logout() {
        actions.moveToElement(topBar.UserSettingsIcon).moveToElement(topBar.LogoutSubTab).click().build().perform();
        wait(Wait10Seconds);
    }

    @AfterTest
    public void stopInstance() {
        driver.quit();
    }

    public void OpenCreateNewReviewPage() {
        topBar.NewReviewButton.click();
        wait(Wait2Seconds);
        Boolean NewUntitledReviewName = reviewPage.UntitledSummaryHeader.isDisplayed();
        Assert.assertTrue(NewUntitledReviewName);
        log.info("New Review Page opened");
    }

    public void OpenReviewByID(String reviewId) {
        driver.get(reviewId);
        wait(Wait2Seconds);
        log.info("Review was opened " + reviewId);
    }


}
