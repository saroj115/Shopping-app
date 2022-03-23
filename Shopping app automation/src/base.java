import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
{
	AndroidDriver<AndroidElement> driver;
	// TODO Auto-generated method stub
		File appDir = new File ("src");
		File app = new File(appDir,"General-Store.apk" );
DesiredCapabilities cap = new DesiredCapabilities();

	cap.setCapability(MobileCapabilityType.DEVICE_NAME,"saroj");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2" );
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
 
	//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android device");

cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath() );
driver  = new AndroidDriver<>(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
//cap.setCapability("appPackage", "io.appium.android.apis");
//cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");


return driver;

}

}
