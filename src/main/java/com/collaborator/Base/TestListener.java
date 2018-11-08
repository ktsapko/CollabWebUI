package com.collaborator.Base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Arrays;
import java.util.Date;

public class TestListener extends TestListenerAdapter {
    //Logging/Output streams
    public static Log log = LogFactory.getLog(TestListener.class);

    @Override
    public void onStart (ITestContext testContext )
    {
        log.info("Running test classes " + testContext.getAllTestMethods());
    }

    @Override
    public void onFinish (ITestContext testContext)
    {
        log.info("Finished running " + Arrays.toString(testContext.getAllTestMethods()) + " tests");
        log.info("Total failure count was " + testContext.getFailedTests());
        log.info("Was this run successful? Result:" + testContext.getPassedTests());
        log.info("");
    }

    @Override
    public void onTestStart (ITestResult result)
    {
        //testCasePassed = true;
        log.info("");
        Date date = new Date();
        log.info("Running test " + result.getName() +" "+ date);
    }

    @Override
    public void onTestFailure (ITestResult tr)
    {
        //testCasePassed = false;
        log.warn("!!!");
        log.warn("Test Failed!");
        log.info("Failure Message: " + tr.getName());
        System.out.println("A StackTrace for the failure was printed to the log.");
        log.debug("StackTrace: " + tr.getThrowable());
    }

    @Override
    public void onTestSuccess (ITestResult tr)
    {
        log.info(tr.getName() + "Successfully passed!");
    }
}
