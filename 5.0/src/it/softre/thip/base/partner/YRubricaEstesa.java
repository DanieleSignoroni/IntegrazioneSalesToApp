package it.softre.thip.base.partner;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.softre.thip.base.connettori.legami.YLegameAgenteUtente;
import it.softre.thip.base.connettori.salesToApp.SalesToAppUtils;
import it.softre.thip.base.connettori.tabelle.YClientiInseriti;
import it.softre.thip.base.connettori.tabelle.YContattiInseriti;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.base.cliente.ClientePrimroseTM;
import it.thera.thip.base.partner.RubricaEstesa;

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

public class YRubricaEstesa extends RubricaEstesa {

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
			YContattiInseriti contattiInseriti = YContattiInseriti.recuperaContattoInserito(getIdAnagrafico(),getIdSequenzaRubrica());
			String url = utils.getURLApiCalls() + SalesToAppUtils.CONTATTI_ENDPOINT;
			String hash = null;
			if(contattiInseriti != null) {
				url += SalesToAppUtils.EDIT + "/" + contattiInseriti.getHash();
				hash = contattiInseriti.getHash();
			}else {
				contattiInseriti = (YContattiInseriti) Factory.createObject(YContattiInseriti.class);
				contattiInseriti.setRAnagrafico(getIdAnagrafico());
				contattiInseriti.setRSequenzaRub(getIdSequenzaRubrica());
				url += SalesToAppUtils.ADD;
			}
			ApiRequest request = new ApiRequest(Method.POST, url);
			request.setBody(getJSONRubricaEstesa());
			JSONObject response = utils.sendRequest(request, 3);
			if(response.has("response") && response.get("response") instanceof JSONObject) {
				JSONObject id = response.getJSONObject("response");
				if(id.has("id"))
					hash = id.getString("id");
				contattiInseriti.setHash(hash);
				contattiInseriti.save();
			}
		}catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}

	}

	@SuppressWarnings("rawtypes")
	public static ClientePrimrose recuperaClienteDaRubrica(RubricaEstesa rubrica) {
		ClientePrimrose cliente = null;
		Vector list;
		String where;
		try {
			where = " "+ClientePrimroseTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' AND "+ClientePrimroseTM.R_ANAGRAFICO+" = '"+rubrica.getIdAnagrafico()+"' ";
			list = ClientePrimrose.retrieveList(ClientePrimrose.class, where, "", false);
			if(list.size() > 0)
				cliente = (ClientePrimrose) list.get(0);
		}catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		return cliente;
	}

	public JSONObject getJSONRubricaEstesa() {
		JSONObject json = new JSONObject();
		ClientePrimrose cliente = recuperaClienteDaRubrica(this);
		if(cliente != null) {
			if(getNome() != null)
				json.put("firstname", getNome());
			if(getCognome() != null)
				json.put("lastname", getCognome());
			if(getNumeroTelefono() != null)
				json.put("phone", getNumeroTelefono());
			if(getIndirizzoPersonale() != null && getIndirizzoPersonale().getCellulare() != null)
				json.put("personal_phone", getIndirizzoPersonale().getCellulare());
			if(getNumeroCellulare() != null)
				json.put("mobile", getNumeroCellulare());
			if(getIndirizzoEmail() != null)
				json.put("email", getIndirizzoEmail());
			if(getTitoloDesc() != null)
				json.put("title", getTitoloDesc());
			if(getDataNascita() != null) {
				SimpleDateFormat f2app = new SimpleDateFormat("YYYY-MM-DD");
				json.put("birth_date", f2app.format(f2app));
			}
			if(getNote() != null)
				json.put("note", getNote());
			try {
				if (cliente.getClienteVendita().getAgente() != null) {
					YLegameAgenteUtente legame = (YLegameAgenteUtente) YLegameAgenteUtente.elementWithKey(
							YLegameAgenteUtente.class, cliente.getClienteVendita().getAgenteKey(),
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
		}
		YClientiInseriti clienteInserito = YClientiInseriti.recuperaClienteInserito(cliente.getIdCliente());
		if(clienteInserito != null) {
			json.put("customer", clienteInserito.getHash());
		}
		return json;
	}
}
