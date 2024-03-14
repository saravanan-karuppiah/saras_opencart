package testCases;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class Tc_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"regression","master"})
	public void test_account_registration() 
	{
		logger.info("****   Starting Tc_001_AccountRegistrationTest  ****");
		logger.debug("Application Logs....");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
	    RegistrationPage regp=new RegistrationPage(driver);
	    logger.info("Entering customer information");
		regp.setFirstName(randomstring().toUpperCase());
		regp.setLastName(randomstring().toUpperCase());
		regp.setEmail(randomstring()+"@gmail.com");
		regp.setPassword(randomAlphaNumeric());
		regp.setPrivacyPolicy();	
		regp.clickContiune();
		logger.info("Clicked Continue button");
		
		String act_msg=regp.getConfirmationMsg();
		logger.info("Validating confirmaion msg");
		//Assert.assertEquals(act_msg,"Your Account Has Been Created!!");
		if(act_msg.equals("Your Account Has Been Created!"))
		{
			
			logger.info("Test Passsed");
			AssertJUnit.assertTrue(true);
		}
		else
		{
			logger.error("Confirmation Message mismatch");
			AssertJUnit.fail();
		}
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			AssertJUnit.fail();
		}
		logger.info("****   Finished Tc_001_AccountRegistrationTest  ****");
		
	
	}
	
	
	
	
	
}
