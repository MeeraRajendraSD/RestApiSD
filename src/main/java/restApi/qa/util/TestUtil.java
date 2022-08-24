package restApi.qa.util;

import java.lang.reflect.Array;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	
	public static Hashtable<String,String> parseJOSONObj(JSONObject responseJSONObj){
		
		Hashtable<String,String> response= new Hashtable<String,String>();
		
		//response.put("Employee Name",(String)responseJSONObj.get("data"));
		
		Object json= responseJSONObj.get("data");
		String msg= responseJSONObj.getString("message");
		response.put("Message", msg);
		System.out.println(msg);
		System.out.println(json.toString());
		
		String data= json.toString();
		data= data.replace("{","");
		data= data.replace("}", "");
		//data= data.replace("\"", "");
		String[] dataArr =data.split(",");
		
		for(String attribute: dataArr) {
			String [] data1= attribute.split(":");
			response.put(data1[0].replace("\"", ""), data1[1].replace("\"", ""));
		}

		return response;
		
	}

}
