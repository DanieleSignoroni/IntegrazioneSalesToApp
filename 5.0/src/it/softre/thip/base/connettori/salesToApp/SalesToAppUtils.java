package it.softre.thip.base.connettori.salesToApp;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.Factory;

import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiClient;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;

public class SalesToAppUtils {

	public static final String ADD = "/add";

	public static final String EDIT = "/edit";

	public static final String LOGIN_ENDPOINT = "/account/login";

	public static final String CLIENTI_ENDPOINT = "/customers";

	public static final String CONTATTI_ENDPOINT = "/contacts";

	public static final String USERS_ENDPOINT = "/users/list_qlik";

	private static SalesToAppUtils instance = null;

	private static YPsnDatiConnPthSl2app persDati = null;

	public static SalesToAppUtils getInstance() {
		if(instance == null) {
			//questa mi va bene single instance tanto il token ha durata giornaliera
			instance = (SalesToAppUtils) Factory.createObject(SalesToAppUtils.class);
		}
		persDati = YPsnDatiConnPthSl2app.getCurrentYPsnDatiConnPthSl2app(); //questa fuori in caso di cambiamenti di parametri e di cancellazione cache
		return instance;
	}

	private String token = null;

	public SalesToAppUtils() {

	}

	public JSONObject sendRequest(ApiRequest apiRequest,int retryCount) {
		JSONObject result = new JSONObject();
		ApiClient apiClient = new ApiClient("");
		ApiResponse apiResponse;
		try {
			apiResponse = apiClient.send(apiRequest);
			StatusType status = apiResponse.getStatus();
			if(status.getStatusCode() == Status.UNAUTHORIZED.getStatusCode()) {
				if (retryCount > 0) {
					retrieveToken();
					return sendRequest(apiRequest, retryCount - 1);
				} else {
					result.put("error", "Maximum retries exceeded for unauthorized request.");
				}
			}else {
				String resp = apiResponse.getBodyAsString();
				if(!resp.isEmpty())
					result = new JSONObject(resp);
			}
			Trace.println(Trace.US1," Sales To App : ");
			Trace.println(Trace.US1," URL : "+apiRequest.getURL());

			if(apiRequest.getMethod() == Method.POST)
				Trace.println(Trace.US1," BODY : "+apiRequest.getBody().toString());
			else
				Trace.println(Trace.US1," URL : "+apiRequest.getParameters().toString());

			Trace.println(Trace.US1," STATUS : "+apiResponse.getStatus().getStatusCode());
		} catch (KeyManagementException e) {
			e.printStackTrace(Trace.excStream);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(Trace.excStream);
		}
		return result;
	}

	private void retrieveToken() {
		ApiClient apiClient = new ApiClient("");
		ApiRequest apiRequest = new ApiRequest(Method.GET, getBaseURLApiCalls()+LOGIN_ENDPOINT);
		Map<String,String> params = new HashMap<String, String>();
		params.put("username", persDati.getUserCalls());
		params.put("password", persDati.getPwdCalls());
		apiRequest.getParameters().putAll(params);
		try {
			ApiResponse apiResponse = apiClient.send(apiRequest);
			if(apiResponse.success()) {
				JSONObject response = new JSONObject(apiResponse.getBodyAsString());
				if(response.has("response")) {
					JSONObject token = (JSONObject) response.get("response");
					this.token = token.getString("authToken");
				}
			}
			Trace.println(Trace.US1," Sales To App : ");
			Trace.println(Trace.US1," URL : "+apiRequest.getURL());
			Trace.println(Trace.US1," URL : "+apiRequest.getParameters().toString());
			Trace.println(Trace.US1," STATUS : "+apiResponse.getStatus().getStatusCode());
		} catch (KeyManagementException e) {
			e.printStackTrace(Trace.excStream);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(Trace.excStream);
		}

	}

	public String getBaseURLApiCalls() {
		//Esempio, dove 'softre' e' l'ApiKey
		//https://app.sales2app.it/api/v1.1/softre 
		String url = null;
		if(persDati == null) 
			return null;
		url = persDati.getUrlCalls();
		if(url.charAt(url.length()-1)!='/')
			url = url + "/";
		url += persDati.getApiKey();
		return url;
	}

	public String getURLApiCalls() {
		if(this.token == null)
			retrieveToken();
		String url = "";
		url = getBaseURLApiCalls();
		if(url.charAt(url.length()-1)!='/')
			url = url + "/";
		url += this.token;
		return url;
	}
}
