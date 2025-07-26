package Utilities;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.TypeToken;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;



public class DataUtils {
	
	public static List<Map<String,String>> getDataFromJson(String filepath) throws FileNotFoundException{
		try {
		FileReader reader = new FileReader(filepath);
		Type type = new TypeToken<List<Map<String,String>>>(){}.getType();
		List<Map<String,String>> rawData = new Gson().fromJson(reader,type);
		
		for(Map<String,String> data : rawData) {
			for(Map.Entry<String, String>field : data.entrySet()) {
				if(field.getValue().contains("{{UUID}}")) {
					String generateUUID = UUID.randomUUID().toString().replace("-", "").toString().substring(0, 8);
					field.setValue(field.getValue().replace("{{UUID}}", generateUUID));
				}
				}
			}
		return rawData;
		
		
		
		
        }catch(Exception e) {
            throw new RuntimeException("Failed to read or process JSON test data: " + e.getMessage());

    }
}
}
	




