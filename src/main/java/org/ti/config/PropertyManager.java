package org.ti.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager implements PropertyManagerInterface{
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private Properties properties = new Properties();

    public static PropertyManager getInstance(){
        if(instance == null){
            synchronized (lock){
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    @Override
    public void loadData(){
        try {
            properties.load(new FileInputStream(propertyFilePath));
        }catch (IOException e){
            System.err.println("Class: PropertyManager | Method: loadData | Exception:" + e.getMessage());
        }
    }

    @Override
    public String getProperty(String aproperty){
        return properties.getProperty(aproperty);
    }
}
