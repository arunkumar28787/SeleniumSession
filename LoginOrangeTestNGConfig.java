package LoginSuite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginOrangeTestNGConfig extends ConfigReader {

	public static WebDriverWait wait;
	//public static WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	public static FileInputStream fileInput = null;
	Properties prop = new Properties();
	String property = null;

	@BeforeTest
	public void setUp() throws IOException {
      init();
      //org.openqa.selenium.InvalidSelectorException: 
	}
	
	@Test(priority=1)
	public static void LoginToOrangeHRM() throws Exception {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
//		// Creating the File Object
//		String Properties;
//		String FileInputStream;
//		File file = new File(System.getProperty("user.dir") + "//config//LoginProperties.properties");
//
//		try {
//			fileInput = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		Properties prop = new Properties();
//		try {
//			prop.load(fileInput);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		Enumeration KeyValues = prop.keys();
//		while (KeyValues.hasMoreElements()) {
//			String key = (String) KeyValues.nextElement();
//			String value = prop.getProperty(key);
//			System.out.println(key + ":- " + value);
//		}
//
//		// Create object of ChromeOptions class
//		ChromeOptions options = new ChromeOptions();
//		// add parameter which will disable the extension
//		options.addArguments("--disable-extensions");
//
//		driver = new ChromeDriver(options);
//		// waiting for browser to open
//		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		// driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
//
//		driver.get(prop.getProperty("URL"));

		// Maximize the window
		//driver.manage().window().maximize();
		

		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUsername")));

		// driver.findElement(By.id("divUsername")).click();
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).clear();
		 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.id("txtUsername")).sendKeys(OR.getProperty("userName"));
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		//driver.findElement(By.id("txtPassword")).sendKeys(OR.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
	}
	
	// selecting from web table
	@Test(priority=2)
	public void selectUserFromAdminScreen() {

		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_viewAdminModule")));

		driver.findElement(By.id("menu_admin_viewAdminModule")).click();

		driver.findElement(By.id("menu_admin_UserManagement")).click();

		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		driver.findElement(By
				.xpath("//td[contains(text(),'Russel Hamilton')]/preceding-sibling::td/input[@name='chkSelectRow[]']"))
				.click();

		System.out.println("check box selected correctly");

		driver.findElement(
				By.xpath("//td[contains(text(),'Jasmine Morgan')]/preceding::td[3]/input[@name='chkSelectRow[]']"))
				.click();

		System.out.println("2 check box selected correctly");

	}
	
	// selecting from drop down
	
	@Test(priority=3)
	public static void SelectUserFromDirectory(){
		//Scrolling Up
		((JavascriptExecutor) driver).executeScript("scroll(400,0)");
		
		//waiting for 20 sec
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Clicking on Directory link
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDirectory_job_title")));
		//selecting HR Manager Job title
		driver.findElement(By.id("searchDirectory_job_title")).click();
	    new Select(driver.findElement(By.id("searchDirectory_job_title"))).selectByVisibleText("HR Manager");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
		
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
		driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}