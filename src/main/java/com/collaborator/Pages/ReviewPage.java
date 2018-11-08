package com.collaborator.Pages;

import com.collaborator.Base.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ReviewPage extends Browser {
    WebDriver driver;

    /*
     * Top Tabs and buttons
     * */
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'SUMMARY')]")
    WebElement SummaryTab;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'PARTICIPANTS')]")
    WebElement ParticipantsTab;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'MATERIALS')]")
    WebElement MaterialsTab;
    @FindBy(how = How.XPATH, using = "//div[@class='actionButtonLeftBorder floatLeft']//span[contains(text(), 'Inspect')]")
    WebElement InspectButton;
    @FindBy(how = How.XPATH, using = "//div[@class='actionButtonLeftBorder floatLeft']//span[contains(text(), 'Send to Rework')]")
    WebElement SendToReworkButton;
    @FindBy(how = How.XPATH, using = "//div[@class='actionButtonLeftBorder floatLeft']//span[contains(text(), 'Send to Completed')]")
    WebElement SendToCompletedButton;

    /*
     * Summary section
     * */
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Untitled Review')]")
    WebElement UntitledSummaryHeader;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Planning')]")
    WebElement PlanningState;
    @FindBy(how = How.XPATH, using = "//input[@class='gwt-TextBox customFieldControl sectionEditElement']")
    WebElement ReviewTitleInput;

    /*
     * Participants section
     * */
    @FindBy(how = How.XPATH, using = "//div//label[contains(text(), 'Author')]")
    WebElement AddMyselfAsAuthorRadio;
    @FindBy(how = How.XPATH, using = "//td[@id='gwt-uid-139']")
    WebElement AddParticipantDropdown;
    @FindBy(how = How.XPATH, using = "//td[@id='gwt-uid-143']")
    WebElement AddRoleDropdown;
    @FindBy(how = How.XPATH, using = "//div[text() = 'Reviewer']")
    WebElement ReviewerRoleSelection;
    @FindBy(how = How.XPATH, using = "//button[@title='Add Participant']")
    WebElement AddParticipantButton;

    /*
     * Review Materials section
     * */
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Upload')]")
    WebElement UploadMaterialsSelection;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Files')]")
    WebElement UploadFileSelection;
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Upload')]")
    WebElement UploadFilesUploadButton;
    @FindBy(how = How.XPATH, using = "//td[@class='location']/a")
    WebElement CommentTypeColumn;

    public ReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String SaveReviewID() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public Boolean CurrentStateIsPlanning (String state) {
        String currentState = PlanningState.getText();
        return currentState.contains(state);
    }

    public void OpenSummaryTab() {
        SummaryTab.click();
        log.info("Summary tab was opened");
    }

    public void OpenParticipantsTab() {
        ParticipantsTab.click();
        log.info("Participants tab was opened");
    }

    public void OpenMaterialsTab() {
        MaterialsTab.click();
        wait(Wait1Second);
        log.info("Materials tab was opened");
    }

    public void FillInReviewName(String reviewName) {
        ReviewTitleInput.clear();
        ReviewTitleInput.sendKeys(reviewName);
        log.info("Review name was changed to " + reviewName);
    }

    public void AddMyselfAsAnAuthor() {
        AddMyselfAsAuthorRadio.click();
        log.info("Added myself as an Author");
    }

    public void AssignReviewer(String userName) {
        AddParticipantDropdown.click();
        wait(Wait2Seconds);
        driver.findElement(By.xpath(userName)).click();
        log.info("Selecting " + userName);
        wait(Wait1Second);
        AddRoleDropdown.click();
        wait(Wait1Second);
        ReviewerRoleSelection.click();
        wait(Wait1Second);
        AddParticipantButton.click();
        log.info("Reviewer was added");

    }

    public void UploadFile() throws AWTException {
        Actions actions = new Actions(driver);
        actions.moveToElement(UploadMaterialsSelection).moveToElement(UploadFileSelection).click().build().perform();
        wait(Wait2Seconds);
        // Setting clipboard with file location
        StringSelection selection = new StringSelection("C:\\webdrivers\\test.xml");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        // Paste file location
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait(Wait2Seconds);
        UploadFilesUploadButton.click();
        wait(Wait5Seconds);
//        UploadCompleteDismissButton.click();
    }

    public void MoveReviewToInspection() {
        InspectButton.click();
        log.info("Review was moved to Inspection");
    }

    public void OpenFileInDiffViewer(String fileName) {
        Assert.assertTrue(driver.findElement(By.xpath(fileName)).isDisplayed());
        driver.findElement(By.xpath(fileName)).click();
        wait(Wait5Seconds);
        log.info("Opened a DiffViewer");
    }


    public void SendReviewToRework() {
        SendToReworkButton.click();
        log.info("Moved Review to Rework");
    }

    public void MoveReviewToCompleted() {
        SendToCompletedButton.click();
        log.info("Review was moved to Completed");
    }

    public void CheckCommentType(String commentType) {
        String currentCommentType = CommentTypeColumn.getText();
        Assert.assertTrue(currentCommentType.contains(commentType));
        log.info("Comment type is " + commentType);
    }
}
