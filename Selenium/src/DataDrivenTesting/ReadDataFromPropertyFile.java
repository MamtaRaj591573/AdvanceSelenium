package DataDrivenTesting;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFile 
{

	public static void main(String[] args) throws Throwable
	{
		//convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./TestResources/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String BROWSER=pro.getProperty("browser");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		System.out.println(URL+"\n"+BROWSER+"\n"+USERNAME+"\n"+PASSWORD);
		WebDriver driver=new ChromeDriver();
		driver.get(URL);

	}

}
