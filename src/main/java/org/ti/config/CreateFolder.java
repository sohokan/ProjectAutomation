package org.ti.config;

import org.ti.DriverFactory.FrameworkException;
import org.ti.utils.logs.Log;

import java.io.File;

public class CreateFolder {
  public static  String createFolder(String folderName) throws FrameworkException {
    File dir = new File(folderName);
    if(!dir.exists()){
      Log.info("creating directory:" + dir.getName());

      try {
        dir.mkdir();
        Log.info("Folder created!");
      }catch (SecurityException se){
        throw new FrameworkException("Class CreateFolder | Method sreateFolder | Exception: " + se.getMessage());
      }
    }
    return dir.toString();
  }
}
