package LoginSuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchOrangeHRM {
	public static WebDriver driver;
	
	 @BeforeClass(alwaysRun = true)
	public static void setUp(){
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
	driver= new FirefoxDriver();
	}
	
	 @Test
	public static void LaunchApp(){

	driver.get("http://opensource.demo.orangehrmlive.com/");
	WebDriverWait wait = new WebDriverWait(driver, 40);	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUsername")));// instead of id u can use cssSelector or xpath of ur element.
	
	//OR
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	System.out.println(driver.getTitle());
	driver.findElement(By.id("txtUsername")).click();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin");
    driver.findElement(By.id("btnLogin")).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_directory_viewDirectory']/b")));
    driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']/b")).click();
    driver.findElement(By.id("searchDirectory_emp_name_empName")).click();
    driver.findElement(By.id("searchDirectory_emp_name_empName")).clear();
    driver.findElement(By.id("searchDirectory_emp_name_empName")).sendKeys("Linda");
    //driver.findElement(By.xpath("//div[4]/ul/li[3]")).click();
    driver.findElement(By.id("searchDirectory_job_title")).click();
    new Select(driver.findElement(By.id("searchDirectory_job_title"))).selectByVisibleText("HR Manager");
    driver.findElement(By.id("searchDirectory_job_title")).click();
    driver.findElement(By.id("searchDirectory_location")).click();
    new Select(driver.findElement(By.id("searchDirectory_location"))).selectByVisibleText("regexp:\\s+Texas R&D");
    driver.findElement(By.id("searchDirectory_location")).click();
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[2]/ul/li[2]")).click();
	
	}	
	
	
	@AfterTest
	public void browserClose(){
		driver.quit();
	}
}
	
