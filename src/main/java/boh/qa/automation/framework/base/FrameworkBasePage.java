package boh.qa.automation.framework.base;

public class FrameworkBasePage {

//	WebDriver driver;
//	Properties properties;
//
//	public WebDriver init_driver(String browserName, String url) {
//		
//		if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\BOHTestAutomation\\WebDrivers\\chromedriver.exe");
//			//System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome_driver_path"));
//			driver = new ChromeDriver();			
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", "C:\\BOHTestAutomation\\WebDrivers\\msedgedriver.exe");
//			//System.setProperty("webdriver.chrome.driver", properties.getProperty("edge_driver_path"));
//			driver = new EdgeDriver();
//		} else {
//			System.out.println(browserName + " browser is not found");
//		}
//
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//
//		driver.get(url);
//		return driver;
//	}
//
//	public Properties init_Properties() {
//		properties = new Properties();
//		FileInputStream fileStream;
//		try {
//			fileStream = new FileInputStream(".\\src\\main\\java\\boh\\qa\\automation\\framework\\config\\framework.config.properties");
//			properties.load(fileStream);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		return properties;
//	}
}
