package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_002_LoginTest extends BaseClass

{     
    @Test(groups= {"sanity","master"})
	public void verify_LoginTest() 
	{
       logger.info("*** Starting LoginTest***");
       
    	HomePage hp= new HomePage(driver);
    	hp.clickMyAccount();
    	logger.info("Clicked myaccount link from Homepage");
    	hp.clickLogin();
    	logger.info("Clicked login link  from Homepage");
    	
    	LoginPage lp=new LoginPage(driver);
    	lp.enterEmail(p.getProperty("email"));
    	lp.enterPassword(p.getProperty("password"));
    	logger.info("Entered login details");
    	lp.clickLogin();
    	logger.info("clicked login button");
    	
    	MyAccountPage macc=new MyAccountPage(driver);
    	if(macc.isMyAccountPageexists())
    			{
    		 Assert.assertTrue(true);
    		 logger.info("$$$LOGIN IS SUCCESSFULL$$$");
    		 macc.clickLogout();
    		 logger.info("Clicked logout");
    		
    			}
    	else
    	{
    		logger.error("login failed");
    		Assert.fail();

    	}
		logger.info("*** Finished LoginTest***");
		
	}
	
	
	
	
	
	
	
	
	
	
}
