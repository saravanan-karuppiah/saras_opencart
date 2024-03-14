package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	   static public WebDriver driver;//we are making webdriver as static because we are using the same driver in capture screen methods(because we are refering the same driver instance in Extentrepotutility class
	   public Logger logger;
	   public Properties p;
	     
	   
		@BeforeClass(groups={"sanity","regression","master"})
		@Parameters({"os", "browser"})
		public void setup(String os,String br) throws IOException
		{  
			FileReader file=new FileReader("./src/test/resources/config.properties");
		     p=new Properties();
		     p.load(file);
		     logger=LogManager.getLogger(this.getClass());
		     
		     if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		     {
		        DesiredCapabilities cap= new DesiredCapabilities();
		    	 
		         switch(os.toLowerCase())
		          {
		            case"windows":cap.setPlatform(Platform.WIN11);break;
		            case"mac":cap.setPlatform(Platform.MAC);break;
		            case"linux":cap.setPlatform(Platform.LINUX);break;
		            default:System.out.println("***NO MATCHING OS***");
		            return ;
		          }
		    
		         switch(br.toLowerCase())
		          {
		            case "chrome" : cap.setBrowserName("chrome");break;
			        case "edge" : cap.setBrowserName("microsoftedge");break;
			        case "firefox" : cap.setBrowserName("firefox");break;
			        case "safari" : cap.setBrowserName("safari");break;
			        default:System.out.println("***NO MATCHING BROWSER***");
			        return;
		    
		          }
		       driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);//this link is a fixed one
		    	 
		     }
		     
		  
		    else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		    {
			   switch(br.toLowerCase())
			    {
				case "chrome" : driver= new ChromeDriver();break;
				case "edge" : driver= new EdgeDriver();break;
				case "firefox" : driver= new FirefoxDriver();break;
				case "safari" : driver= new SafariDriver();break;
				default:System.out.println("no matching browser...");
				return;
			     }
		     }
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appurl"));
			driver.manage().window().maximize();
		}	
		
		
		@AfterClass(groups={"sanity","regression","master"})
		public void teardown()
		{
			driver.quit();;
		}
		
		//capturescreenshot method for extent report generation
		
		public String captureScreen(String resname) throws IOException
		{
			String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot tc=(TakesScreenshot)driver;
			File sourcefile=tc.getScreenshotAs(OutputType.FILE);
			String tar_filepath=System.getProperty("user.dir")+"//screenshots//"+resname+"_"+timestamp+".png";
			File targetfile=new File(tar_filepath);	
			sourcefile.renameTo(targetfile);
			//Files.copy(sourcefile, targetfile);
			return tar_filepath;			
		}
	
		
		public String randomstring()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;	
		}
		
		public String randomNumber()
		{
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
		public String randomAlphaNumeric()
		{
			String str=RandomStringUtils.randomAlphabetic(4);
			String num=RandomStringUtils.randomNumeric(4);
			return (str+"@"+num);
		}


}
