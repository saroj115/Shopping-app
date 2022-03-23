import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class ecommerce extends base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver= capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Alice");
		driver.hideKeyboard();
 	    driver.findElement(By.xpath("//*[@text='Female']")).click();
	    driver.findElement(By.id("android:id/text1")).click();

	    

	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

	     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
	     
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	    

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    Thread.sleep(4000);
	  int count =   driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	  //System.out.println(count);
	  double sum =0;
	    for(int i =0;i<count;i++) {
	    	String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
	    	double amount =getAmount(amount1);
	    	sum = sum+amount;
	    }
	  
	  	System.out.println(sum +"sum of items in the cart");
	String total= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	total = total.substring(1);
	double totalValue = Double.parseDouble(total);
	System.out.println(totalValue+"total value of items in the cart");
	//Assert.assertEquals(sum, totalValue);

	// Mobile gestures
	WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
	TouchAction t = new TouchAction(driver);
	t.tap(tapOptions().withElement(element(checkbox))).perform();
	WebElement tc = driver.findElement(By.xpath("//*[@text = 'Please read our terms of conditions']"));	
	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
			for (String contextName :contexts) {
				System.out.println(contextName);
						}
			driver.context("WEBVIEW_com.androidsample.generalstore");
			driver.findElement(By.name("g")).sendKeys("app has been switched to hybrid mode");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.context("NATIVE_APP");
	}
	public static double getAmount(String value)
	{
	value=value.substring(1);
	double amount2value= Double.parseDouble(value);
	return amount2value;
	}
	
}     

	    