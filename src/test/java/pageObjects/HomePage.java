package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	//WebDriver driver;
	public HomePage (WebDriver driver)
	{
		super(driver);
	
	}
	
	
@FindBy(xpath="//div[@class='nav float-end']//div[@class='dropdown']")  WebElement myAccount;
@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;


public void clickMyAccount()
{
	
	myAccount.click();

}


public void clickRegister()
{
	
	 register.click();

}public void clickLogin()
{
	
	login.click();

}


}
