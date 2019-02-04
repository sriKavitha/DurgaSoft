package org.openmrs.demo.OpenMRSNew;

import org.apache.log4j.Logger;
//import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindPatientPageTests extends FindPatientPage
{
	private static final Logger log=Logger.getLogger(FindPatientPageTests.class.getName());
	HomePage hp;
	@BeforeMethod
	public void findPatientSetUp() throws Exception
	{
		launch(loadData("browserName"),loadData("url"));
		log.info("=======Begin executing Find Patient Page Tests=================");
		hp=new HomePage();
		hp.loginOpenMRS();
		takeScreenShot();
		log.info("Browser opened and User Signed In successfully");
	}



	//Verify title after user sign in
	//@Test(priority=2)
	public void verifyTitle() throws Exception
	{
		String actualTitle=findPatientgetTitle();
		Assert.assertEquals(actualTitle, "OpenMRS Electronic Medical Record","Title is not matching...Should be \"OpenMRS Electronic Medical Record\"");
		takeScreenShot();
		log.info("Verified title in Find Patient page after user signed in");
	}


	//Verify the page refresh when the logo is clicked after user sign in 
	//@Test(priority=3)
	public void verifylogo() throws Exception
	{
		hp=new HomePage();
		hp.logo();
		takeScreenShot();
		log.info("Clicked on Logo in Find Patient page after user signed in");
	}


	//Verify to find the registered patient 
	@Test(priority=1)
	public void verifyFindPatient() throws Exception
	{
		FindPatientPage fp=new FindPatientPage();
		fp.Click_findPatientButton(); //Click Find Patient button after user Signed In

		boolean patientFound=fp.findByIDName(loadData_OR("searchPatiendName"));

		if(patientFound)
		{
			log.info("Verified... The registered Patient is found...");
		}
		else
		{
			log.info("Verified... The Patient is not registered");
		}
		//Thread.sleep(3000);
		takeScreenShot();
		//log.info("Verified... The registered Patient is found or not found");
	}


	//Sign out and close the browser
	@AfterMethod
	public void tearDown() throws Exception
	{
		driver.close();
		log.info("Browser closed");
		log.info("=======End executing Find Patient Page Tests=================");
	}

}
