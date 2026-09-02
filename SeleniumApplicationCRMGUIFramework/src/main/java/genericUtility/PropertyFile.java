package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

		public String getDatafromPropertyFile(String key) throws IOException
		{
	    FileInputStream fis = new FileInputStream("./src/main/resources/commondataForVtiger.properties");
	
		Properties prop = new Properties();
		
		prop.load(fis);
		return prop.getProperty(key);
		
		
		
		
}}

//public static void main(String[] args) throws IOException {
//
//    PropertyFile pf = new PropertyFile();
//
//    System.out.println("Browser :"+pf.getDatafromPropertyFile("browser"));
//    System.out.println("URL :"+pf.getDatafromPropertyFile("url"));
//   System.out.println("Username :"+pf.getDatafromPropertyFile("username"));
//    System.out.println("Password :"+pf.getDatafromPropertyFile("password"));
//}}
