package org.utils.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class applicationread 
{
	public static Properties getConfig() {

		Properties properties = new Properties();

		String path = "C:\\Users\\Administrator\\eclipse-workspace\\DemoWebBDDHybridFramework\\src\\test\\resources\\Application1.properties";

		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
