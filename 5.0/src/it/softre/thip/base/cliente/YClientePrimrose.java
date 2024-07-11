package it.softre.thip.base.cliente;

import java.sql.SQLException;

import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.softre.thip.base.connettori.legami.YLegameAgenteUtente;
import it.softre.thip.base.connettori.salesToApp.SalesToAppUtils;
import it.softre.thip.base.connettori.salesToApp.TipiAccount;
import it.softre.thip.base.connettori.tabelle.YClientiInseriti;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.base.cliente.ClientePrimrose;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 11/07/2024
 * <br><br>
 * <b>71XXX	DSSOF3	11/07/2024</b>
 * <p>Prima stesura.<br>
 *  
 * </p>
 */

public class YClientePrimrose extends ClientePrimrose {

	@Override
	public int save() throws SQLException {
		int rc = super.save();
		if(rc > 0) {
			integrazioneSalesToApp();
		}
		return rc;
	}

	private void integrazioneSalesToApp() {
		Trace.println(Trace.US1," From : "+getClass().getName());
		try {
			SalesToAppUtils utils = SalesToAppUtils.getInstance();
			YClientiInseriti clienteInserito = YClientiInseriti.recuperaClienteInserito(getIdCliente());
			String url = utils.getURLApiCalls() + SalesToAppUtils.CLIENTI_ENDPOINT;
			String hash = null;
			if(clienteInserito != null) {
				url += SalesToAppUtils.EDIT + "/" + clienteInserito.getHash();
				hash = clienteInserito.getHash();
			}else {
				clienteInserito = (YClientiInseriti) Factory.createObject(YClientiInseriti.class);
				clienteInserito.setIdCliente(getIdCliente());
				clienteInserito.setIdAzienda(getIdAzienda());
				url += SalesToAppUtils.ADD;
			}
			ApiRequest request = new ApiRequest(Method.POST, url);
			request.setBody(getJSONClientePrimrose());
			JSONObject response = utils.sendRequest(request, 3);
			if(response.has("response") && response.get("response") instanceof JSONObject) {
				JSONObject id = response.getJSONObject("response");
				if(id.has("id"))
					hash = id.getString("id");
				clienteInserito.setHash(hash);
				clienteInserito.save();
			}

		}catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}

	}

	public JSONObject getJSONClientePrimrose() {
		JSONObject json = new JSONObject();
		if(getCAP() != null)
			json.put("company_cap", getCAP());
		if(getLocalita() != null)
			json.put("company_city", getLocalita());
		if(getAnagrafico().getIndirizzoBase().getProvincia() != null) 
			json.put("company_district", getAnagrafico().getIndirizzoBase().getProvincia().getDescrizione().getDescrizione());
		if(getCodiceFiscale() != null)
			json.put("company_fiscal_code", getCodiceFiscale());
		if(getRagioneSociale() != null)
			json.put("company_name", getRagioneSociale());
		if(getIdNazione() != null)
			json.put("company_nation", getIdNazione());
		if(getIndirizzo() != null)
			json.put("company_street_name", getIndirizzo());
		if(getPartitaIVA() != null)
			json.put("company_vat", getPartitaIVA());
		try {
			if (getClienteVendita().getAgente() != null) {
				YLegameAgenteUtente legame = (YLegameAgenteUtente) YLegameAgenteUtente.elementWithKey(
						YLegameAgenteUtente.class, getClienteVendita().getAgenteKey(),
						PersistentObject.NO_LOCK);
				if (legame != null) {
					YUtentiSales2App utente = legame.getUtente();
					if (utente != null) {
						json.put("assigns", utente.getId());
					}
				} else {
					json.put("assigns", YPsnDatiConnPthSl2app.getCurrentYPsnDatiConnPthSl2app().getHashUserJolly());
				}
			} else {
				json.put("assigns", YPsnDatiConnPthSl2app.getCurrentYPsnDatiConnPthSl2app().getHashUserJolly());
			}
		} catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		json.put("types", TipiAccount.CLIENTE.getValue());
		if(getAnagrafico().getIndirizzoEmail() != null)
			json.put("email", getAnagrafico().getIndirizzoEmail());
		if(getAnagrafico().getNumeroTelefono() != null)
			json.put("company_mobile", getAnagrafico().getNumeroTelefono());
		json.put("company_region", "non definita");
		return json;
	}
}
