package org.collective.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.collective.maincontroller.MainController;

public class TestUtility extends MainController{

	
	
	public static void openPageInNewTab() throws AWTException {
		Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	}

	public static void fileUpload(String fileLocation) {
		
		 StringSelection stringSelection = new StringSelection(fileLocation);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   Robot robot;
		try {
			robot = new Robot();
		 
			/*robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);*/
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);
		}
           catch (AWTException e) {
   			e.printStackTrace();
   		}
		
	}

	public static void closeCurrentTab() {
		driver.close();
		
	}

	public static void closeAllTabsExceptFirst() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=1;i<tabs.size();i++)
		{	
	    driver.switchTo().window(tabs.get(i));
	    driver.close();
		}
		driver.switchTo().window(tabs.get(0));
	}

	public static void switchToDialogBox(){
		
	    driver.switchTo().window(driver.getWindowHandle());
	    
	}
	
	public static void switchToPreviousTab() throws AWTException {
		Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_SHIFT); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_SHIFT); 
		r.keyRelease(KeyEvent.VK_T);
	}

	public static void printAllTheWindows() {
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		for(String window : al)
		{
			System.out.println(window);
		}
		
	}
}
