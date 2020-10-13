package selenium.fluent.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class SeleniumFluentWaitDemo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "E:\\11092019\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://softwaretestingplace.blogspot.com/2017/02/fluent-wait.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	Alert s=new Alert
	driver.findElement(By.xpath("//button[@onclick='fluentWaitTimeOut()']")).click();
	//fluentwait
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	WebElement element1=wait.until(new Function<WebDriver, WebElement>() 
	
	{

		@Override
		public WebElement apply(WebDriver driver)
		{
			WebElement msgelement=driver.findElement(By.xpath("//p[@id='softwareTestingMaterial']"));
			String msg1=msgelement.getText();
			if(msg1.equalsIgnoreCase("softwareTestingMaterial"))
			{
				System.out.println(msg1);
				return msgelement;
			}
			else
			{
			return null;	
			}
			
			}
			
		
	}
	);
}
}
