package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * This is the one of the classes which has constructor that needs to
 * be invoked explicitly. This class set properties listed in methods.
 */

public class Configuration{
	
	public static Properties properties;
	
	public static String environment;
	public static String browser;
	public static String driverPath;
	public static String url;
	
	public static String userName;
	public static String password;
	
	/*
	 * This constructor when invoked will set up 
	 * Environment, Browser
	 * DriverPath, DriverPath
	 */
	
	public Configuration() {
		Configuration.setEnvironment();
		try {
			Configuration.setBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Configuration.setDriverPath();
		try {
			Configuration.setUrl();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(Configuration.getUserName());
		System.out.println(Configuration.getPassword());
		
	}

	
	/* This method takes a "property name" or "property key" as an input and 
	 * return its respective "property value" from .properties file */
	public static String getProperty(String propertyName) throws IOException {
		
		/* File name that is to be opened
		The environments that can be selected are C1, C2*/
		String fileName = Configuration.environment+".properties";
		
		
		// Opening file using File class by passing location of the file
		File environmentFile = new File(System.getProperty("user.dir")+"/Config/"+fileName);
		FileInputStream fis = new FileInputStream(environmentFile);
		
 
		
		// Using the Properties references to create its object and pass FileInputStream to it 
		Configuration.properties = new Properties();
		Configuration.properties.load(fis);
		
		// Return the values using getProperty method	
		return Configuration.properties.getProperty(propertyName);
	}
	
	/*
	 * This method setup the environment
	 * To create new environments create a new file in Config folder
	 * with .properties extension
	 */
	public static void setEnvironment() {
		
		// Fetching environment
		//Configuration.environment = System.getProperty("environment");
		
		//Environment will be null at first as we have not set it up
		//System.out.println(Configuration.environment);
		
		// This is where the test engineer will set up the environment
		if(Configuration.environment == null) {
			Configuration.environment = "C1";
		}
		
		//System.out.println("Environment is  "+Configuration.environment);
		
	}
	
	public static void setBrowser() throws IOException {
		
		// Fetching the value of browse.
		Configuration.browser = System.getProperty("browser");
		
		// The value of the browser will be null at first
		//System.out.println(Configuration.browser);
		
		if(Configuration.browser == null) {
			Configuration.browser = Configuration.getProperty("browser");
		}
		
		System.out.println("Broswer is "+Configuration.browser);
		
	}
	

	
	public static void setUrl() throws IOException {
		
		// Fetching the value fo the url.
		Configuration.url = System.getProperty("url");
		
		//The Value of the url will be null at first
		//System.out.println(Configuration.url);
		
		if(Configuration.url == null) {
			Configuration.url = Configuration.getProperty("url");
		}
		
		//System.out.println("Url is "+Configuration.url);
	}
	
	
	/* More features to be implemented later based on multi browser selection 
	 * This funciton is to be modified so it can handle cross browser testing
	 */
	public static void setDriverPath() {
		String path = System.getProperty("user.dir");
		String path1  = path + "/Drivers";
		Configuration.driverPath = path1;
		
		//System.out.println(Configuration.driverPath);
		
	}
	
	public static String getUserName() {
		return Configuration.userName = Configuration.properties.getProperty("userName");
	}
	
	public static String getPassword() {
		return Configuration.password = Configuration.properties.getProperty("password");
		
	}
}
