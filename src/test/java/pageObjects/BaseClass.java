package pageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public EdgeOptions op;
	// public Logger log;
	public Logger log = LogManager.getLogger(BaseClass.class);
	public Properties prop;

	public BaseClass() {
		// empty constructor
	}

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@Parameters({ "browser", "os" })
	@BeforeClass(groups = { "Functional", "Sanity", "Regression", "Master" })
	public void setUp(@Optional("edge") String br, @Optional("windows") String os) throws IOException {


		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		switch (br.toLowerCase()) {
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browser is invalid :" + br);
			return; // return for completely breaking the execution
		}
		log = LogManager.getLogger(this.getClass());
		op = new EdgeOptions();
		op.addArguments("--headless");

		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("OpenCartURL"));
	}

	// Generate Random Email address
	public static String createEmail() {

		//
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(Character::isLetterOrDigit).build();
		String emailAddress = generator.generate(10);
		return emailAddress + "@gmail.com";
	}

	// Generate Random Email address
	public static String createPassword() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(Character::isLetterOrDigit).build();
		String password = generator.generate(12);
		return password;
	}

	// Generate Random Phone address
	public static String createPhone() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', '9').build();
		String phone = generator.generate(10);
		return phone;
	}

	// Generate Random Phone address
	public static String createFirstLastName() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		String name = generator.generate(7);
		return name;
	}

	public String captureScreen(String tname) throws IOException {
		try {
			// Small wait to let any error message appear on the screen
			Thread.sleep(1000); // wait 1 second (you can increase to 1500ms if needed)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


	@AfterClass(groups = { "Functional", "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

}
