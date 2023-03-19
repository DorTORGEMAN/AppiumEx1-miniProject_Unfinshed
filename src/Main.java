import io.appium.java_client.android.AndroidDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {}/*/
 //private static AndroidDriver <MobileElement> driver;
   public static AndroidDriver driver;
    @BeforeClass
    public static void  setUp() throws IOException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Android Device");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("newCommandTimeout",120);
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("resetKeyboard",true);
         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test1_skipInto(){
        WebElement intoSkipButton=
        driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton"));
        intoSkipButton.click();
    }
   @AfterClass
    public static void tearDown()throws InterruptedException,IOException{
        driver.quit();

    }/*/
