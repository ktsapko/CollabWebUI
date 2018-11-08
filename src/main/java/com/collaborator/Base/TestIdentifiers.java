package com.collaborator.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestIdentifiers {
    public TestIdentifiers(){}

    public Properties getIDs() {

        Properties myObj = new Properties();

        InputStream input = null;

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String defaultPath = rootPath + "Identifiers.Properties";
        try {
            // placement of this file will need to change
            input = new FileInputStream(defaultPath);

            myObj.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return myObj;
    }
}
