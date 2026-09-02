   package genericUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	
	public String getDataFromJsonfile(String key) throws IOException, ParseException {
		FileReader fileR = new FileReader("./testdata/appCommonData.json");
		   JSONParser parser = new JSONParser();
	       Object obj = parser.parse(fileR);
	        
	        //step2: Convert java Object in to JSONObject using DownCasting
	       JSONObject map =(JSONObject)obj;
	       
	     String data= (String)map.get(key);
	     
	     return data;
	     
	}
}
