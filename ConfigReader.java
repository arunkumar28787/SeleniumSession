package LoginSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigReader {

	public Properties OR = new Properties();
	public static WebDriver driver;

	// public static FileInputStream fileInput = null;
	// static Properties properties = new Properties();
	// String property=null;
	//
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// // Creating the File Object
	// String Properties;
	// String FileInputStream;
	// File file = new File(System.getProperty("user.dir") +
	// "//config//LoginProperties.properties");
	//
	// try {
	// fileInput = new FileInputStream(file);
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// }
	// Properties prop = new Properties();
	// try {
	// prop.load(fileInput);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// Enumeration KeyValues = properties.keys();
	// while (KeyValues.hasMoreElements()) {
	// String key = (String) KeyValues.nextElement();
	// String value = properties.getProperty(key);
	// System.out.println(key + ":- " + value);
	// }
	//
	//
	// }
	//
	// public String getData(String ElementName) throws Exception {
	// // Read value using the logical name as Key
	// String data = properties.getProperty(ElementName);
	// return data;
	// }

	public void getUrl(String url) {
		// log.info("navigating to :-" + url);
		driver.get(url);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir")
				+ "/config/LoginProperties.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}

	public void init() throws IOException {
		loadData();
		//String log4jConfPath = "log4j.properties";
		// PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}

		}
	}
}
