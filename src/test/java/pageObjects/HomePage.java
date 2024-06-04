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

@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
WebElement txtSearchbox;
@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
WebElement btnSearch;

public void clickMyAccount()
{
	myAccount.click();
}


public void clickRegister()
{
	 register.click();
}
public void clickLogin()
{	
	login.click();
}
public void enterProductName(String pName)   //For Search Product Test
{
	txtSearchbox.sendKeys(pName);
}

public void clickSearch()  //For Search Product Test
{
	btnSearch.click();
}

}
