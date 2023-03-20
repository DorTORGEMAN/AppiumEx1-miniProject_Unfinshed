import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

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

