package selenium.actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropby {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\11092019\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://only-testing-blog.blogspot.com/2014/09/drag-and-drop.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
        //draganddrop for x axix
        WebElement draggable=driver.findElement(By.xpath("//div[@id='dragdiv']"));
        Actions action1=new Actions(driver);
        action1.dragAndDropBy(draggable, 100, 0).build().perform();
        //generate javascript alert by using javascriptexecutor giving an alert msg
        JavascriptExecutor js=(JavascriptExecutor)driver;
        Thread.sleep(5000);
        js.executeScript("alert('move element by 100 pixel in x direction');");
        driver.switchTo().alert().accept();
        //draganddrop for y axix
        Actions action2=new Actions(driver);
        Action draganddropby=action2.dragAndDropBy(draggable, 0, 100).build();
        draganddropby.perform();
        Thread.sleep(5000);
        //generate javascript alert for y direction
        js.executeScript("alert('move element by 100 pixel in y direction');");
        driver.switchTo().alert().accept();
        
        //draganddrop with original position
        new Actions(driver).dragAndDropBy(draggable, -100, -100).build().perform();
        Thread.sleep(5000);
        //generate javascript alert to move in original position
        js.executeScript("alert('move element by -100 in x direction & y direction');");
        driver.switchTo().alert().accept();
     
        
        
	}

}
