package practice_datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		
		//step:1 parse JSon physical 
		//parse=>convert one object to another object
        JSONParser parser = new JSONParser();
       Object obj = parser.parse(new FileReader("C:\\Users\\obisw\\OneDrive\\Desktop\\java\\appCommonData.json"));
        
        //step2: Convert java Object in to JSONObject using DownCasting
       JSONObject map =(JSONObject)obj;
       
       //step 3: get the Value
       System.out.println(map.get("url"));
       
       System.out.println(map.get("browser"));
       System.out.println(map.get("username"));
       System.out.println(map.get("password"));
       System.out.println(map.get("timeout"));
       
       
	}

}
