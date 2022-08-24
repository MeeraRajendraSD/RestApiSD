package restApi.qa.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public  class RestClient implements RestClientint{
	
	public CloseableHttpResponse creatClientConnection(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closableHttpResponse= httpClient.execute(httpGet);
		return closableHttpResponse;
	}

	public int getStatusCode(CloseableHttpResponse closableHttpResponse) {
		int statusCode=closableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Http Response: "+statusCode);
		return statusCode;
	}

	public JSONObject getResponseJSONObj(CloseableHttpResponse closableHttpResponse) throws ParseException, IOException {
		String responseStr= EntityUtils.toString(closableHttpResponse.getEntity(),"UTF-8");
		System.out.println("Response String : "+ responseStr);
		JSONObject responseJSONObj= new JSONObject(responseStr);
		System.out.println("Response JOSON Object : "+responseJSONObj);
		return responseJSONObj;
	}

	public HashMap<String, String> getHeaders(CloseableHttpResponse closableHttpResponse) {
		Header[] headerArray = closableHttpResponse.getAllHeaders();
		HashMap<String,String> headerInfo = new HashMap<String,String>();		
		for(Header header: headerArray) {
			headerInfo.put(header.getName(), header.getValue());
		}
		System.out.println("Header info : "+headerInfo);		
		return headerInfo;
	}
	
	

	
	// Get Method 
	public void get(String url) throws ClientProtocolException, IOException {
		//create one client connection 
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closableHttpResponse= httpClient.execute(httpGet);
		
		//StatusCode
		int statusCode=closableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Http Response: "+statusCode);
		
		//JOSN String
		String responseStr= EntityUtils.toString(closableHttpResponse.getEntity(),"UTF-8");
		
		System.out.println("Response String : "+ responseStr);
		
		JSONObject responseJSONObj= new JSONObject(responseStr);
		
		System.out.println("Response JOSON Object : "+responseJSONObj);
		
		//Header info
		Header[] headerArray = closableHttpResponse.getAllHeaders();
		
		HashMap<String,String> headerInfo = new HashMap<String,String>();
		
		for(Header header: headerArray) {
			headerInfo.put(header.getName(), header.getValue());
		}
		System.out.println("Header info : "+headerInfo);
		
		
	}

	

}
	