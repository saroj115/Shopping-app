import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Assert;

public class ecommercetoastMessage extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver= capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Saroj"); to check toast message when namefield value is passed the toastMessage test case fails    
		//driver.hideKeyboard();
 	    driver.findElement(By.xpath("//*[@text='Female']")).click();
	    driver.findElement(By.id("android:id/text1")).click();

	    

	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     String toastMessage =driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");// // name attribute for toast message will have content
	     System.out.println(toastMessage);
	     Assert.assertEquals("Please enter your name",toastMessage);
	     
	}
}
	     

	    