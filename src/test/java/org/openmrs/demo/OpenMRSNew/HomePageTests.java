package org.openmrs.demo.OpenMRSNew;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends HomePage{
	private static final Logger log=Logger.getLogger(HomePageTests.class.getName());
	
	
	//Just Invoke browser with provided url
	@BeforeClass
	public void openB() throws Exception
	{
		launch(loadData("browserName"),loadData("url"));
		log.info("=======Begin executing Home Page Tests=================");
		log.info("Browser opened");
		takeScreenShot();
	}


	//Verify cant login is clicked
	@Test(priority=1)
	public void verifyCantLogin() throws Exception
	{
		cantLogin();
		takeScreenShot();
		log.info("Verified Cant Login");
	}

	
	
	//Verify title 
	@Test(priority=2)
	public void verifyTitle() throws Exception
	{
		//hPage=new HomePage();
		//String homePageTitle=hPage.getTitle();
		String homePageTitle=getTitle();
		Assert.assertEquals(homePageTitle, "Login" , "Title is not matching...Should be \"Login\"");
		takeScreenShot();
		log.info("Verified title of the page");
	}


	
	//Verify logo is clicked
	@Test(priority=3)
	public void verifyLogo() throws Exception
	{
		logo();
		takeScreenShot();
		log.info("Logo clicked");

	}


	
	//Close the browser after each test
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		log.info("=======End executing Home Page Tests=================");
	}


	}
