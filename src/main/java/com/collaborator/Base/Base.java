package com.collaborator.Base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Base extends TestListener {
    //Timing Constants
    protected static final int Wait1Second = 1000;
    public static final int Wait2Seconds = 2000;
    public static final int Wait5Seconds = 5000;
    public static final int Wait10Seconds = 10000;

    //Logging/Output streams
    public static Log log = LogFactory.getLog(Base.class);

    public void wait(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
