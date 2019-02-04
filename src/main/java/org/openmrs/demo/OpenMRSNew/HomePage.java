package org.openmrs.demo.OpenMRSNew;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	//Login as Admin 
	public void loginOpenMRS() throws Exception
	{
		driver.findElement(By.id(loadData_OR("homepage_username_id"))).sendKeys(loadData("userName"));
		driver.findElement(By.id(loadData_OR("homepage_password_id"))).sendKeys(loadData("passWord"));
		driver.findElement(By.id(loadData_OR("homepage_location_id"))).click();
		driver.findElement(By.id(loadData_OR("homepage_logIn_id"))).click();
	}

	
	//Verify title after user sign in
	public String getTitle()
	{
		return(driver.getTitle());
	}
	
	
	//Click on logo to refresh the page
	public void logo() throws Exception 
	{
		driver.navigate().refresh();
		//Thread.sleep(3000);
	}
	
	
	//Click on Can't login link
	public String cantLogin() throws Exception
	{
		driver.findElement(By.cssSelector(loadData_OR("homepage_cantLogin_css"))).click();
		String cantLoginTitle=driver.findElement(By.xpath(loadData_OR("homepage_cantloginTitleText_xpath"))).getText();
		//Thread.sleep(3000);
		driver.findElement(By.xpath(loadData_OR("homepage_cantloginokBtn_xpath"))).click();
		return cantLoginTitle;
	}

}
