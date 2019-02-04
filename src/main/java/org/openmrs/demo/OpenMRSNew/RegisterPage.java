package org.openmrs.demo.OpenMRSNew;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage
{
	public static String capture_given_Name;
	public static String capture_family_Name;
	public void inputRegistrationDetails() throws Exception
	{
		driver.findElement(By.xpath(loadData_OR("register_button_xpath"))).click();  //Selected/Clicked Register Patient on HomePage
		driver.findElement(By.name(loadData_OR("register_given_name"))).sendKeys("Test Patient",Keys.ENTER);
		driver.findElement(By.name(loadData_OR("register_middle_name"))).sendKeys("A",Keys.ENTER);
		driver.findElement(By.name(loadData_OR("register_family_name"))).sendKeys("Chris",Keys.ENTER);

		driver.findElement(By.name(loadData_OR("register_gender_name"))).sendKeys("Male",Keys.ENTER);;
		driver.findElement(By.id(loadData_OR("register_birth_dd_id"))).sendKeys("23",Keys.ENTER);;
		driver.findElement(By.id(loadData_OR("register_birth_mm_id"))).sendKeys("January");;
		driver.findElement(By.id(loadData_OR("register_birth_yy_id"))).sendKeys("1985", Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_birth_yy_id"))).sendKeys(Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_address1_id"))).sendKeys("Address1");
		driver.findElement(By.id(loadData_OR("register_address1_id"))).sendKeys(Keys.ENTER);

		driver.findElement(By.id(loadData_OR("register_address2_id"))).sendKeys(Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_city_id"))).sendKeys("MyCity");
		driver.findElement(By.id(loadData_OR("register_city_id"))).sendKeys(Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_state_id"))).sendKeys("Andhra");
		driver.findElement(By.id(loadData_OR("register_state_id"))).sendKeys(Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_country_id"))).sendKeys("INDIA", Keys.ENTER);
		driver.findElement(By.id(loadData_OR("register_postalcode_id"))).sendKeys("580631", Keys.ENTER);
		driver.findElement(By.name(loadData_OR("register_phoneNumber_name"))).sendKeys("9965800763",Keys.ENTER);
		driver.findElement(By.name(loadData_OR("register_relationship_name"))).sendKeys("Patient",Keys.ENTER);
		driver.findElement(By.xpath(loadData_OR("register_relationshipPersonName_xpath"))).sendKeys("asas",Keys.ENTER);

	}
	
	
	//Keyin the registration details and click on cancel button in case patient details needs to be modified 
	public void cancelRegistrationButtonClicked() throws Exception
	{
		inputRegistrationDetails();
		//Thread.sleep(5000);
		driver.findElement(By.id(loadData_OR("register_cancel_id"))).click();
	}

	
	//Keyin the registration details and click on submit button 
	public void confirmRegistrationButtonClicked() throws Exception
	{
		inputRegistrationDetails();
		//Capture the given name and family name for validation
		capture_given_Name=driver.findElement(By.name(loadData_OR("register_given_name"))).getAttribute("value");
		capture_family_Name=driver.findElement(By.name(loadData_OR("register_family_name"))).getAttribute("value");

		driver.findElement(By.id(loadData_OR("register_submit_id"))).click();
		
	}

}
