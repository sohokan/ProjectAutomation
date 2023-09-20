package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class PaymentDonePage extends HomePage{
    By msgCongratsLocator= By.xpath("//p[contains(.,'Congratulations')]");

    By btnContinueLocator= By.xpath("//a[contains(.,'Continue')]");

    By btnDownLoadLocator=By.xpath("//a[contains(.,'Download')]");

    WebElement msgCongrats;

    WebElement btnContinue;

    WebElement btnDownLoad;

    public void ContinuetoHome()

    {
        btnContinue=driver.findElement(btnContinueLocator);
        btnContinue.click();

    }

    public void DownloadInvoice()
    {
        btnDownLoad=driver.findElement(btnDownLoadLocator);
        btnDownLoad.click();

    }

    public void CheckFileWasDownloaded()
    {

//        isFileDownloaded("invoice").forEach(file-> System.out.println(file));


        System.out.println("Last created file "+getLatestFilefromDir());






    }



//     List<String> isFileDownloaded( String fileName) {
//        File downloaddir = new File(System.getProperty("user.dir")+"\\Downloads");
//        File[] dirContents = downloaddir.listFiles();
//
//         System.out.println("Number of files "+dirContents.length);
//
//        for (int i = 0; i < dirContents.length; i++) {
//            if (dirContents[i].getName().contains(fileName)) {
//                // File has been found, it can now be deleted:
////                dirContents[i].getName();
//
//                return Collections.singletonList(dirContents[i].getName());
//            }
//        }
//        return Collections.singletonList("No files Downloaded");
//    }

    private File getLatestFilefromDir(){
        File dir =  new File(System.getProperty("user.dir")+"\\Downloads");
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }
}
