package selenium.wait.methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\11092019\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https:\\www.facebook.com");
		driver.manage().window().maximize();
		//pageloadtimeout
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Snehal");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mohod");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("snehalmohod36@gmail.com");
		//implicit wait
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
		
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("snehalmohod36@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("mohoh10");
		
		WebElement dob=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select se=new Select(dob);
		se.selectByValue("3");
		WebElement dob1=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		new Select(dob1).selectByValue("10");
		WebElement dob2=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		new Select(dob2).selectByValue("1993");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		//driver.findElement(By.xpath("//input[@value='2']")).click();
		//driver.findElement(By.xpath("//input[@value='-1']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		//implicit wait
		WebDriverWait wait1=new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='uiHeaderTitle']")));
		
		driver.navigate().back();
		

	}

}
