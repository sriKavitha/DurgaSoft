package org.openmrs.demo.OpenMRSNew;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class BasePage {

	public static WebDriver driver;

	//To load config.properties file to read browser/url/username/password
	public static String loadData(String key) throws Exception
	{
		File f=new File(System.getProperty("user.dir")+"//properties/config.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fis);
		return(prop.getProperty(key));
	}



	//To load OR.properties all the web locators in different pages
	public static String loadData_OR(String key_OR) throws Exception
	{
		File f_OR=new File(System.getProperty("user.dir")+"//properties/OR.properties");
		FileInputStream fis_OR=new FileInputStream(f_OR);
		Properties prop=new Properties();
		prop.load(fis_OR);
		return(prop.getProperty(key_OR));
	}



	//To launch browser
	public static void launch(String browserName, String url) throws Exception
	{
		if(browserName.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FIREFOX"))
		{
			//	System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "C:\\JavaH2K\\JavaAug_18\\OpenMRSNew\\drivers\\IEDriverServer_3.11.1_32.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get(loadData("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path="C:\\JavaH2K\\JavaAug_18\\OpenMRSNew\\properties\\log4j.properties";
		PropertyConfigurator.configure(path);

	}

	//Send the method name and call takeOpenMRSScreenShot so that screenshot has functionality name with timestamp
	public static void takeScreenShot() throws Exception
	{
		String nameofCurrMethod=new Exception().getStackTrace()[1].getMethodName();
		takeOpenMRSScreenShot(nameofCurrMethod);
	}


	public static void takeOpenMRSScreenShot(String methodName) throws Exception
	{
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY HH-mm-ss");
		String dateFormat = sdf.format(dt);
		File f1=new File("C:\\JavaH2K\\JavaAug_18\\OpenMRSNew\\OpenMRS_ScreenShots\\"+ methodName+"_"+dateFormat+".png");
		FileHandler.copy(f, f1);
	}
}
