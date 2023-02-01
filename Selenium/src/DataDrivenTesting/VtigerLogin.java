package DataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VtigerLogin
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./TestResources/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		long time=Long.parseLong(pro.getProperty("timeouts"));
		//String BROWSER=pro.getProperty("browser");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		boolean status=wait.until(ExpectedConditions.titleContains("Home"));
		//System.out.println(status);
		
		if(status)
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		driver.quit();
		
		
		

	}

}
