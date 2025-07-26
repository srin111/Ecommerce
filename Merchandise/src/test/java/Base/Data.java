package Base;


	import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import Utilities.DataUtils;



	public class Data {
		
		@DataProvider(name = "JsonCardDetails")
		public Object[][] provideCardDetails() throws FileNotFoundException{
			List<Map<String,String>> prodData = DataUtils.getDataFromJson("/Merchandise/src/main/java/Utilities/CardData.json");
			Object [][] data = new Object[prodData.size()][1];
			
			for(int i=0;i<prodData.size();i++) {
				data[i][0] = prodData.get(i);
			}
			
			return data;
	       }

}
