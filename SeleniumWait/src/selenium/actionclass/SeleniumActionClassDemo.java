
package selenium.actionclass;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActionClassDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\24112019\\Seleniumgriddata\\New folder\\2020new\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  //pageload
		  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		  //title
		   String title=driver.getTitle();
		   System.out.println("Amazon webpage title is:"+title);
		   //no of hyperlinks
		  List<WebElement> ls= driver.findElements(By.tagName("a"));
		  int count=ls.size();
		  System.out.println("No of hyperlinks on webpage are:"+count);
		   

		WebElement gift=driver.findElement(By.linkText("Gift Ideas"));
		 Actions action1=new Actions(driver);
		action1.doubleClick(gift).build().perform();
		
		 // explicit wait
		 WebDriverWait wait=new WebDriverWait(driver, 15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='zg_banner_text_wrapper'][.='Amazon Gift Ideas']")));
		 String text=driver.findElement(By.xpath("//div[@id='zg_banner_text_wrapper'][.='Amazon Gift Ideas']")).getText();
		 System.out.println("Gift ideas next page title is:"+text);
		
		 //rightclick//contextclick
		WebElement coupon=driver.findElement(By.linkText("Coupons"));
		Actions action2=new Actions(driver);
		Action rightclick=action2.contextClick(coupon).build();
		rightclick.perform();
		
		//mousehover
		WebElement mouse=driver.findElement(By.xpath("//span[@class='nav-line-1'][.='Hello. Sign in']"));
		Actions action3=new Actions(driver);
		action3.moveToElement(mouse).build().perform();
		driver.findElement(By.linkText("Your Orders")).click();
		WebDriverWait wait1=new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
		boolean flag=driver.findElement(By.xpath("//input[@name='email']")).isDisplayed();
		
		if(flag==true)
		{
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("snehalmohod36@gmail.com");
			driver.navigate().back();
		}
		
	}
}
