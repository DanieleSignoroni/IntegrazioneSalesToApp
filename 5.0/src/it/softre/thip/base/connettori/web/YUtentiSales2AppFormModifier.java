package it.softre.thip.base.connettori.web;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.thera.thermfw.web.WebFormModifier;

import it.softre.thip.base.connettori.salesToApp.SalesToAppUtils;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;

/**
 * 
 * <h1>Softre Solutions</h1> <br>
 * 
 * @version 1.0
 * @author Daniele Signoroni 03/11/2023 <br>
 *         <br>
 *         <b>71289 DSSOF3 03/11/2023</b>
 *         <p>
 *         Estensione entita' in cui posso registrare gli utenti di Sales 2 App
 *         che prendo tramite chiamata http, con parametri presenti in
 *         {@link YPsnDatiConnPthSl2app}
 *         </p>
 */

public class YUtentiSales2AppFormModifier extends WebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyStartElements(JspWriter out) throws IOException {
		try {
			SalesToAppUtils utils = SalesToAppUtils.getInstance();
			ApiRequest apiRequest = new ApiRequest(Method.GET, utils.getURLApiCalls() + SalesToAppUtils.USERS_ENDPOINT);
			JSONObject response = utils.sendRequest(apiRequest, 3);
			JSONArray arr = response.getJSONArray("response");
			JsonArray arrJSON = new JsonArray();
			for (int i = 0; i < arr.length(); i++) {
				JsonParser p = new JsonParser();
				JSONObject obj = arr.getJSONObject(i);
				arrJSON.add(p.parse(obj.toString()));
			}
			out.print("<script>");
			out.print("var json = '" + arrJSON.toString() + "';");
			out.print("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFormStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {

	}

}
