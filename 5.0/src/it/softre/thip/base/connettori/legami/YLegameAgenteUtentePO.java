
package it.softre.thip.base.connettori.legami;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.thera.thip.base.agentiProvv.Agente;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;

/**
 * 
 * <h1>Softre Solutions</h1> <br>
 * 
 * @version 1.0
 * @author Daniele Signoroni 03/11/2023 <br>
 *         <br>
 *         <b>71289 DSSOF3 03/11/2023</b>
 *         <p>
 *         Estensione entita' in cui posso legare un {@link Agente} ad un
 *         {@link YUtentiSales2App}
 *         </p>
 */

public abstract class YLegameAgenteUtentePO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YLegameAgenteUtente cInstance;

	protected Proxy iAgente = new Proxy(it.thera.thip.base.agentiProvv.Agente.class);

	protected Proxy iUtente = new Proxy(it.softre.thip.base.connettori.YUtentiSales2App.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YLegameAgenteUtente) Factory.createObject(YLegameAgenteUtente.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YLegameAgenteUtente elementWithKey(String key, int lockType) throws SQLException {
		return (YLegameAgenteUtente) PersistentObject.elementWithKey(YLegameAgenteUtente.class, key, lockType);
	}

	public YLegameAgenteUtentePO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setAgente(Agente agente) {
		String idAzienda = getIdAzienda();
		if (agente != null) {
			idAzienda = KeyHelper.getTokenObjectKey(agente.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iAgente.setObject(agente);
		setDirty();
		setOnDB(false);
	}

	public Agente getAgente() {
		return (Agente) iAgente.getObject();
	}

	public void setAgenteKey(String key) {
		iAgente.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getAgenteKey() {
		return iAgente.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setIdAgente(String idAgente) {
		String key = iAgente.getKey();
		iAgente.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idAgente));
		setDirty();
		setOnDB(false);
	}

	public String getIdAgente() {
		String key = iAgente.getKey();
		String objIdAgente = KeyHelper.getTokenObjectKey(key, 2);
		return objIdAgente;
	}

	public void setUtente(YUtentiSales2App utente) {
		this.iUtente.setObject(utente);
		setDirty();
	}

	public YUtentiSales2App getUtente() {
		return (YUtentiSales2App) iUtente.getObject();
	}

	public void setUtenteKey(String key) {
		iUtente.setKey(key);
		setDirty();
	}

	public String getUtenteKey() {
		return iUtente.getKey();
	}

	public void setIdUtenteS2App(String idUtenteS2App) {
		iUtente.setKey(idUtenteS2App);
		setDirty();
	}

	public String getIdUtenteS2App() {
		String key = iUtente.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YLegameAgenteUtentePO yLegameAgenteUtentePO = (YLegameAgenteUtentePO) obj;
		iAgente.setEqual(yLegameAgenteUtentePO.iAgente);
		iUtente.setEqual(yLegameAgenteUtentePO.iUtente);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdAgente(KeyHelper.getTokenObjectKey(key, 2));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String idAgente = getIdAgente();
		Object[] keyParts = { idAzienda, idAgente };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YLegameAgenteUtenteTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iAgente.getKey();
		iAgente.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
	}

}
