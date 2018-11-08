package com.collaborator;

public class Actionwords extends TestHelper {

    public void theBrowserNameIsStarted(String name){
        setup(name);
        init();
    }

    public void iEditUserLoginPromptWithTextText(String text) {
        dashboard.OpenAdmin();
        adminPage.OpenSystemDisplayTab();
        adminPage.adminSystemDisplayTab.EditUserLoginPrompt(text);
    }

    public void logout() {
        dashboard.Logout();
    }

    public void newPromptDisplaysTextText(String text) {
        loginPage.CheckPrompt(text);
        driver.quit();
    }

    public void iLoginAsUsernameWithPasswordPassword(String username, String password) {
        loginPage.LoginToCollab(username, password);
    }

    public void openCreateReviewPage() {

    }

    public void openSummarySubTab() {

    }

    public void openMaterialsTab() {

    }

    public void uploadFileFilePath(String filePath) {

    }

    public void openDiffViewer() {

    }

    public void openFileFileNameInDiffViewer(String fileName) {

    }

    public void addOverallCommentText(String text) {

    }

    public void returnToReviewPage() {

    }

    public void checkCommentType() {

    }
}