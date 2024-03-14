package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{
     //WebDriver driver;
     public RegistrationPage(WebDriver driver)
     {
    	super(driver); 
     }
  
  @FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
  @FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
  @FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
  @FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
  @FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
  @FindBy(xpath="//button[normalize-space()='Continue']") WebElement btnContinue;
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
  
  
  public void setFirstName(String fname)
  {
	  txtFirstname.sendKeys(fname);
  }

  public void setLastName(String lname)
  {
	  txtLastname.sendKeys(lname);
  }
  public void setEmail(String email)
  { 
	  txtEmail.sendKeys(email);  
  }
  public void setPassword(String pass)
  {
	  txtPassword.sendKeys(pass);
  }
  public void setPrivacyPolicy()
  {
	 //chkdPolicy.click();
	 // chkdPolicy.submit();
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();",chkdPolicy);
	 //chkdPolicy.sendKeys(Keys.RETURN);
	 //WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(100));
	 //mywait.until(ExpectedConditions.elementToBeClickable(chkdPolicy)).click();
  }
  public void clickContiune()
  {
	 //btnContinue.click();
	 //btnContinue.submit();
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();",btnContinue);
	 //btnContinue.sendKeys(Keys.RETURN);
  }
  public String getConfirmationMsg()
  {
   try {
       	return   msgConfirmation.getText();
	   }
   catch (Exception e)
	  {	   
    	   return e.getMessage();
	  }
  }	

}
