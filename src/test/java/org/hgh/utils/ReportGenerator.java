package org.hgh.utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.hgh.maincontroller.MainController;
import org.testng.*;
import org.testng.xml.XmlSuite;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.*;
/*
 * @author Hemanth.Sridhar
 */
public class ReportGenerator implements IReporter {
    
	private static int passedtest;
    
	private static int failedtest;
    
	private static int skippedtest;
	
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(MainController.outputFolder+"/Automation Report.html", true);
        try {
			extent.config()
			        .documentTitle("Automation Report")
			        .reportName(PropertyFileReader.propertiesReader(MainController.applicationSetUp, "productName"))
			        .reportHeadline(PropertyFileReader.propertiesReader(MainController.applicationSetUp, "typeOfTestForReport")+ " test report");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                passedtest = context.getPassedTests().size();
                //System.out.println(passedtest);
                failedtest = context.getFailedTests().size();
               // System.out.println(failedtest);
                skippedtest = context.getSkippedTests().size();
               // System.out.println(skippedtest);
            }
        }

        extent.flush();
        extent.close();
      File zipFile = new File(MainController.outputFolder+".zip");
      ZipUtil.pack(new File(MainController.outputFolder), zipFile);
      
    		   
        
      try {

      	if(PropertyFileReader.propertiesReader(MainController.applicationSetUp, "sendEmailPermisson").equalsIgnoreCase("yes"))
			{
		
				SendEmailOutLook.sendemail(passedtest, failedtest, skippedtest,zipFile);
			} 
			
		}
      
      catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
        if (tests.size() > 0) {
        	for (ITestResult result : tests.getAllResults()) {
        		String s = "";
        		//for printing the name with data being used in extent report
        		if(result.getParameters() != null) {
        		for(int i =0;i<result.getParameters().length;i++){
        			if(!s.isEmpty())
        			{
        				s += ",";
        			}
        			s += result.getParameters()[i].toString();
        		}
        		}
                test = extent.startTest(result.getMethod().getMethodName() + " || " +  s);
                test.getTest().startedTime = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());
                  
                if(result.getStatus()==ITestResult.FAILURE)
                {
                test.log(status, test.addScreenCapture("./Screenshots/"+result.getMethod().getMethodName()+"_"+s+".png"));
                }
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
              
                String message = "Test " + status.toString().toLowerCase() + "ed";
               
                
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
                
                test.log(status, message);

                extent.endTest(test);
            }
        }
    }
    
    
    
//for report 
    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
  
}
