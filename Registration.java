package demoqa;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {

	public static WebDriver driver;
	private String baseUrl;

	public static void main(String[] args) throws Exception {
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			
			// driver.manage().window().maximize();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			// add parameter which will disable the extension
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			
			driver.get("http://demoqa.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Registration")).click();

			driver.findElement(By.id("name_3_firstname")).click();
			driver.findElement(By.id("name_3_firstname")).clear();
			driver.findElement(By.id("name_3_firstname")).sendKeys("Test");

			driver.findElement(By.id("name_3_lastname")).clear();
			driver.findElement(By.id("name_3_lastname")).sendKeys("name");

			driver.findElement(By.xpath(".//input[@value='married']")).click();

			driver.findElement(By.xpath("//input[@value='reading']")).click();
			driver.findElement(By.xpath("//input[@value='cricket ']")).click();

			driver.findElement(By.id("dropdown_7")).click();
			new Select(driver.findElement(By.id("dropdown_7"))).selectByVisibleText("India");
			
			((JavascriptExecutor) driver).executeScript("scroll(400,0)");

			driver.findElement(By.id("dropdown_7")).click();
			driver.findElement(By.id("mm_date_8")).click();
			new Select(driver.findElement(By.id("mm_date_8"))).selectByVisibleText("10");
			
			driver.findElement(By.id("mm_date_8")).click();			
			new Select(driver.findElement(By.id("dd_date_8"))).selectByVisibleText("15");
			
			
			driver.findElement(By.id("yy_date_8")).click();
			new Select(driver.findElement(By.id("yy_date_8"))).selectByVisibleText("1996");
			
			
			driver.findElement(By.id("phone_9")).click();
			driver.findElement(By.id("phone_9")).clear();
			driver.findElement(By.id("phone_9")).sendKeys("9876543210");
			
			driver.findElement(By.id("username")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("testname123@gmail.com");
			
			
			driver.findElement(By.id("email_1")).click();
			driver.findElement(By.id("email_1")).clear();
			driver.findElement(By.id("email_1")).sendKeys("testname123@gmail.com");
			
			
			driver.findElement(By.id("profile_pic_10")).click();
			driver.findElement(By.id("profile_pic_10")).clear();
			driver.findElement(By.id("profile_pic_10")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
			
			
			driver.findElement(By.id("description")).click();
			driver.findElement(By.id("description")).clear();
			driver.findElement(By.id("description")).sendKeys("hello... i am working in TCS");
			
			
			driver.findElement(By.id("password_2")).click();
			driver.findElement(By.id("password_2")).clear();
			driver.findElement(By.id("password_2")).sendKeys("Nov@2017");
			
			driver.findElement(By.id("confirm_password_password_2")).clear();
			driver.findElement(By.id("confirm_password_password_2")).sendKeys("Nov@2017");
			driver.findElement(By.name("pie_submit")).click();
		}

	}
}