package restApi.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public static Properties prop;
	
public TestBase () {
		
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("/Users/kashyapbhatt/eclipse-Selenium-Java-workspace/RestApi/src/main/java/restApi/qa/config/config.properties");
			prop.load(ip);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
