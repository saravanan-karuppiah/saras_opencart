package utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders 
{
	@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
	{
		String path=".//testData/loginddt.xlsx";
		ExcelUtility eu= new ExcelUtility(path);
		int totalrows=eu.getRowCount("Sheet 1");
		int totalcols=eu.getCellCount("Sheet 1", 1);
		String logindata[][]=new String[totalrows][totalcols];
		for (int i=1;i<=totalrows;i++) 
		{
			for (int c=0;c<totalcols;c++)
			{    
				logindata [i-1][c]=eu.getCellData("Sheet 1", i, c);//getting the data from 1 row of the excel(because the oth row contains heading)and storing it into zeroth row of the array
			}
		}
		
		return logindata;
		
	}
	
	
	

}
