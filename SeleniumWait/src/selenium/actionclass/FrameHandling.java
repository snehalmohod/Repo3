package selenium.actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\11092019\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.get("https://jqueryui.com/droppable/");
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       
       driver.switchTo().frame(0);
       
       WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
       Actions action1=new Actions(driver);
       action1.dragAndDrop(source, target).build().perform();
       //To generate javascript alert
       
       JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("alert('move element from source to target location');");
       Thread.sleep(5000);
       driver.switchTo().alert().accept();
       //to access from outside the frame
       driver.switchTo().defaultContent();
      driver.findElement(By.linkText("About")).click();
      String text=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
      System.out.println(text);
	}

}
