package org.openmrs.demo.OpenMRSNew;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FindPatientPage extends BasePage
{
	private String actualPatientFound;
	private CharSequence patientName;

	public void Click_findPatientButton() throws Exception
	{
		driver.findElement(By.xpath(loadData_OR("findPatient_button_xpath"))).click();  //Selected Find Patient after User Signs In

	}

	public boolean findByIDName(String patientName) throws Exception
	{
		boolean val=false;
		String actualPatientFound=null;
		driver.findElement(By.xpath(loadData_OR("findPatient_IdName_xpath"))).sendKeys(patientName);
	//	Thread.sleep(6000);
		
		String noMatch=driver.findElement(By.xpath(loadData_OR("findPatient_emptyTable_xpath"))).getText();
		if(noMatch.contains("No matching records found"))
		{
			//Thread.sleep(10000);
			//System.out.println("valuefale :"+val);
			return(false);
		}
		else
		{
			//List<WebElement>a=driver.findElements(By.xpath("findPatient_hasRecords_xpath"));
			actualPatientFound=driver.findElement(By.xpath(loadData_OR("findPatient_hasRecords_xpath"))).getText();
			//System.out.println(actualPatientFound);
			val = actualPatientFound.contains(patientName);
			//System.out.println("vale :"+val);
			return(true);
		}	
		}


		//Verify title after user sign in
		public String findPatientgetTitle()
		{
			return(driver.getTitle());
		}


	}
