 package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class SampleSDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		//step 1 : get the java representation of the physical file
		FileInputStream fis= new FileInputStream("C:\\Users\\obisw\\OneDrive\\Desktop\\commondata.properties");
		//step 2 : using properties class , load  all the keys
		Properties prop = new Properties();
		prop.load(fis);
		//step 3 : get the value based on key
		System.out.println(prop.getProperty("url"));
	}
}
