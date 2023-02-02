package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertiesFile
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./TestResources/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		pro.put("os","windows");
		FileOutputStream fos=new FileOutputStream("./TestResources/commondata.properties");
		pro.store(fos, "updated successfully");

	}

}
