package org.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.framework.maincontroller.MainController;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * @author Hemanth.Sridhar
 */
public class Screenshot extends MainController {
	
public static void captureScreenShot(WebDriver driver, String screenshotName,String date, String time) throws IOException{
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
	File dest = new File(outputFolder + "/Screenshots/"+screenshotName+"_"+date+".png");
	
	FileUtils.copyFile(src,dest);
}
}
