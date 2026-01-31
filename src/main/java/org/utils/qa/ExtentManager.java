package org.utils.qa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
private static ExtentReports extent;
	

    public static ExtentReports getInstance() 
    {
        if (extent == null) 
        {

            ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Administrator\\eclipse-workspace\\HybridFramewokFB\\Reportings\\extend3.html");
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Test Results");
            spark.config().setTimeStampFormat(("dd-mmm-yyyy HH:mm:ss"));

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Author", "QA Team");
        }
        return extent;
}
}
