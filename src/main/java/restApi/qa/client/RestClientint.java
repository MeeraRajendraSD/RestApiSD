package restApi.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;

public interface RestClientint {
	
	/*
	public CloseableHttpResponse creatClientConnection(String url) throws ClientProtocolException, IOException;
	
	public int getStatusCode(CloseableHttpResponse closableHttpResponse);
	
	public JSONObject getResponseJSONObj(CloseableHttpResponse closableHttpResponse) throws ParseException, IOException;
	
	public HashMap<String,String> getHeaders(CloseableHttpResponse closableHttpResponse);
	*/
	
	public void get(String url) throws ClientProtocolException, IOException;
		
	

}
