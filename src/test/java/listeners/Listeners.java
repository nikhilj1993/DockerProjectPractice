package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreport.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.takeScreenshot;

import java.io.IOException;

public class Listeners implements ITestListener {
    ThreadLocal<ExtentTest> test=new ThreadLocal<>();;
    ExtentReports extent = ExtentReport.getReportObject();
    public void onTestStart(ITestResult result){
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }
    public void onTestSuccess(ITestResult result){
        test.get().log(Status.PASS,"Test has passed");
    }
    public void onTestFailure(ITestResult result){
        test.get().fail(result.getThrowable());
        String path=null;
        try {
            path = takeScreenshot.takeScreenshot(BaseTest.getDriver(),result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
    }
    public void onTestSkipped(ITestResult result){
        test.get().skip(result.getThrowable());
    }
    public void onFinish(ITestContext context){
        extent.flush();
    }

}
