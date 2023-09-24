package practiceDataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//Step 1: Parse Json Physical file into Java Object using jasonParser class
		JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader("C:\\Users\\QSP-Trainer6\\Desktop\\data\\appCommonData.json"));
		
		//Step 2: Convert Java Object into JsonObject using Downcasting
		JSONObject map=(JSONObject)object;
		
		//Get the value from Json file using key
		System.out.println(map.get("timeOut"));
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("userName"));
		System.out.println(map.get("password"));
		
		
	}
}
