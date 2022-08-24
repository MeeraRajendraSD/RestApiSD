package restApi.qa.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restApi.qa.base.TestBase;
import restApi.qa.client.RestClient;
import restApi.qa.util.TestUtil;

public class GetApiTest extends TestBase {
	
	TestBase testBase;
	String url1;
	String apiUrl1;
	String apiUrl2;
	String url;
	RestClient restClient;
	Hashtable<String,Object> getRequestResponse;
	JSONObject responseJSONObj;
	
	@BeforeMethod
	
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		url1= prop.getProperty("url");
		apiUrl1= prop.getProperty("serviceUrl1");
		apiUrl2= prop.getProperty("serviceUrl2");
		restClient= new RestClient();
		
		
		
	}
	
	@Test (priority=1)
	public void	getApiTest() throws ClientProtocolException, IOException {
		url= url1+apiUrl1;
		restClient.get(url);
		
		//check status is 200
		CloseableHttpResponse closableHttpResponse =restClient.creatClientConnection(url);
		int statusCode= restClient.getStatusCode(closableHttpResponse);
		Assert.assertEquals(statusCode,200,"Status code is "+statusCode);
		
		//Check response code in header
		//JSONObject responseJSONObj= restClient.getResponseJSONObj(closableHttpResponse);
		HashMap<String,String> headerInfo = restClient.getHeaders(closableHttpResponse);
		Assert.assertEquals(headerInfo.get("Response"), "200", "Response in header is "+headerInfo.get("Response"));
		
		
		
	}
	
	@Test (priority=2)
	public void	getEmployeePersonalDataTest() throws ClientProtocolException, IOException {
		url= url1+apiUrl2;
		//check status is 200
		CloseableHttpResponse closableHttpResponse =restClient.creatClientConnection(url);
		int statusCode= restClient.getStatusCode(closableHttpResponse);
		Assert.assertEquals(statusCode,200,"Status code is "+statusCode);
		
		//Check response code in header
		//JSONObject responseJSONObj= restClient.getResponseJSONObj(closableHttpResponse);
		HashMap<String,String> headerInfo = restClient.getHeaders(closableHttpResponse);
		Assert.assertEquals(headerInfo.get("Response"), "200", "Response in header is "+headerInfo.get("Response"));
		
		//Get employee personal data form api
		JSONObject responseJSONObj= restClient.getResponseJSONObj(closableHttpResponse);
		Hashtable<String,String> response= TestUtil.parseJOSONObj(responseJSONObj);
		System.out.println(response.size());
		System.out.println(response.get("employee_name"));
		Set<String> keys=response.keySet();
		for (String key:keys ) {
			System.out.println(key+ " : "+ response.get(key));
			
		}
		
		
	}
	
	

}
