package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc_003_LoginDDTTest extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
   public void verifyLoginDDt(String email,String pass,String exp_res)
   {
	   
		logger.info("*** Starting Tc_003_LoginDDTTest ***");
		logger.debug("Starting Appliation logs");
	   try {    
    	HomePage hp= new HomePage(driver);
    	hp.clickMyAccount();
    	logger.info("Clicked myaccount link from Homepage");
    	hp.clickLogin();
    	logger.info("Clicked login link  from Homepage");
    	
    	LoginPage lp=new LoginPage(driver);
    	lp.enterEmail(email);
    	lp.enterPassword(pass);
    	logger.info("Entered login details");
    	lp.clickLogin();
    	logger.info("clicked login button");
    	
    	MyAccountPage macc=new MyAccountPage(driver);
    	boolean tar_page = macc.isMyAccountPageexists();
    	
    	if(exp_res.equalsIgnoreCase("valid"))	
    	 {
    		if(tar_page==true)
    		{
    		 Assert.assertTrue(true);
    		 logger.info("test scenario passed");
    		 macc.clickLogout();
    		
    		}
    	   else 
    	    {
    		Assert.fail();
    		logger.error("Target page doen't appear");
    	    }
    		
    	 }
    	if(exp_res.equalsIgnoreCase("invalid"))
    	{
    		if(tar_page==true)
    	     {
    		logger.error("login failed invalid data but target page appears");
    		macc.clickLogout();
    		Assert.fail();
    	     }
    		else
    		{
    			Assert.assertTrue(true);
    			logger.info("test secanrio passed");
    		}
    	}
	   }
	   catch(Exception e)
	   {
		   Assert.fail(e.getMessage());
	   }
	   logger.debug("Ending Appliation logs");
		logger.info("*** Finished Tc_003_LoginDDTTest t***");
	   
   }
}
