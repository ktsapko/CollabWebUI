package com.collaborator;

import org.testng.annotations.*;

public class DiffViewerTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();

        actionwords.theBrowserNameIsStarted("Chrome");
    }

    @Test
    public void addOverallCommentForAFile() {
        // When I login as "QATest1" with password ""
        actionwords.iLoginAsUsernameWithPasswordPassword("QATest1", "");
        // And Open Create Review page
        actionwords.openCreateReviewPage();
        // And Open Summary sub tab
        actionwords.openSummarySubTab();
        // And Open Materials tab
        actionwords.openMaterialsTab();
        // And Upload file "filepath"
        actionwords.uploadFileFilePath("filepath");
        // And Open file "file_name" in Diff viewer
        actionwords.openFileFileNameInDiffViewer("file_name");
        // And Add overall comment "text"
        actionwords.addOverallCommentText("text");
        // And Return to Review page
        actionwords.returnToReviewPage();
        // Then Check comment type
        actionwords.checkCommentType();
    }
}