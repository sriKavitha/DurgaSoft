package org.openmrs.demo.OpenMRSNew;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTests extends RegisterPage
{
	private static final Logger log=Logger.getLogger(RegistrationPageTests.class.getName());
	HomePage hp;
	@BeforeClass
	public void RegisterPageSetUp() throws Exception
	{
		launch(loadData("browserName"),loadData("url"));
		log.info("=======Begin executing Registration Page Tests=================");
		
		hp=new HomePage();
		hp.loginOpenMRS();
		takeScreenShot();
		log.info("Browser opened and Admin Signed In successfully");
	}


	//Verify title after user sign in
	@Test(priority=1)
	public void verifyTitle() throws Exception
	{
		hp=new HomePage();
		String actualTitle=hp.getTitle();
		Assert.assertEquals(actualTitle, "Home","Title is not matching...Should be \"Home\"");
		takeScreenShot();
		log.info("Verified title after user signed in");
	}

	//Verify the page refresh when the logo is clicked after user sign in 
	@Test(priority=2)
	public void verifylogo() throws Exception
	{
		hp=new HomePage();
		hp.logo();
		takeScreenShot();
		log.info("Clicked on Logo after Admin signed in");
	}


	//Verify if the control goes to beginning of the registration page without saving the patient details 
	//after clicking Cancel button
	@Test(priority=3)
	public void VerifyCancelRegister() throws Exception
	{
		cancelRegistrationButtonClicked();
		//Thread.sleep(3000);
		takeScreenShot();
		tearDown();
		log.info("Verified... The control goes to begin of Registration details after Admin clicks CANCEL button");
	}


	//Verify if the registration is saved and confirmed
	@Test(priority=4)
	public void verifyConfirmRegister() throws Exception
	{
		RegisterPageSetUp();
		confirmRegistrationButtonClicked();
	//	Thread.sleep(5000);
		String gName=driver.findElement(By.xpath(loadData_OR("register_successfull_given_xpath"))).getText();
		Assert.assertEquals(gName, capture_given_Name,"Not Equal..");
		System.out.println("Given names are equal...");
		
		String fName=driver.findElement(By.xpath(loadData_OR("register_successfull_family_xpath"))).getText();

		Assert.assertEquals(fName, capture_family_Name,"Not Equals...");
		takeScreenShot();
		log.info("Verified... The PATIENT registration details are successfully saved into the system after user clicks CONFIRM button");
	}


	//Sign out and close the browser
	@AfterClass
	public void tearDown() throws Exception
	{
		driver.close();
		log.info("Browser closed");
		log.info("=======End executing Registration Page Tests=================");
		
	}

}
