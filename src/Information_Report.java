import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Information_Report {



    ///////////Methods
    public  static String takeScreenshot(String ImagesPath){
        TakesScreenshot takesScreenshot=(TakesScreenshot) New_Appuim_EX2.driver;
        File screenShotFile =takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile=new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile,destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }return ImagesPath+".png";
    }

public static void Assert_RESULTED(String FORMULA){
    WebElement pre_result= New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_tv_result"));
    String further_result=pre_result.getText();
    switch (FORMULA) {///Assert check if result is right
        case "plus": {
            int expected=16;
            int actual=Integer.parseInt(further_result);
            try {assertEquals(expected, actual);
                New_Appuim_EX2.myTests.log(LogStatus.PASS, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                        "in finally check if get real answer", "it is pass");
            } catch (AssertionError E) {
                New_Appuim_EX2.myTests.log(LogStatus.FAIL, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                    "in finally check if get real answer", "it is fail");}
        }break;
        case "minus": {
            int expected=2;
            int actual= Integer.parseInt(further_result);
            try {assertEquals(expected, actual);
                New_Appuim_EX2.myTests.log(LogStatus.PASS, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                        "in finally check if get real answer", "it is pass");
            } catch (AssertionError E) {
                New_Appuim_EX2.myTests.log(LogStatus.FAIL, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                    "in finally check if get real answer", "it is fail");}}break;

        case "time": {
            int expected=63;
            int actual=Integer.parseInt(further_result);
            try {assertEquals(expected, actual);
                New_Appuim_EX2.myTests.log(LogStatus.PASS, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                        "in finally check if get real answer", "it is pass");
            } catch (AssertionError E) {
                New_Appuim_EX2.myTests.log(LogStatus.FAIL, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                    "in finally check if get real answer", "it is fail");}}break;
        case "Division": {
            String expected="1.2857142857";
            String actual=further_result;
            try {assertEquals(expected, actual);
                New_Appuim_EX2.myTests.log(LogStatus.PASS, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                        "in finally check if get real answer", "it is pass");
            } catch (AssertionError E) {
                New_Appuim_EX2.myTests.log(LogStatus.FAIL, "Test 2: calculator_miniProject: Get in calculator and send Numbers and do same Formula math and " +
                    "in finally check if get real answer", "it is fail");}}break;
    }
}
    public static String DataFromFiles(String kEYDATA) throws Exception {
        File XmlFlies= new File("C:/קורס אוטומציה/APPIUM_XML/new 1.xml");
        DocumentBuilderFactory dbFactry=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder=dbFactry.newDocumentBuilder();
        Document doc=dBuilder.parse(XmlFlies);
        doc.getDocumentElement().normalize();
       return doc.getElementsByTagName(kEYDATA).item(0).getTextContent();
    }
    public static void APP_Appuim(String APP){
        switch (APP) {
            case "chrome":{
                New_Appuim_EX2.capabilities.setCapability("appPackage", "com.android.chrome");
                New_Appuim_EX2.capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
                New_Appuim_EX2.capabilities.setCapability("unicodeKeyboard", true);
                New_Appuim_EX2.capabilities.setCapability("resetKeyboard", true);
            }break;
            case "calculator":{/////For mini Project
                New_Appuim_EX2.capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
                New_Appuim_EX2.capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
            }
        }}
    public static void calculator_FORMULA(String DATA) throws Exception {
        switch (Information_Report.DataFromFiles(DATA)){
            case "plus":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();}break;
            case "minus":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub")).click();}break;
            case "time":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")).click();}break;
            case "Division":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div")).click();}break;

        }}
    public static void NUMBER_FORMULA(String DATA) throws Exception {
        switch (Information_Report.DataFromFiles(DATA)){
            case "9":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();}break;
            case "7":{New_Appuim_EX2.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();}break;
        }
    }


}

