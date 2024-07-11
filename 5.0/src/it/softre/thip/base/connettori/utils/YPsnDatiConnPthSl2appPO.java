package it.softre.thip.base.connettori.utils;

import com.thera.thermfw.persist.*;

import java.sql.*;
import java.util.*;

import it.thera.thip.cs.*;

import com.thera.thermfw.common.*;

import it.thera.thip.base.azienda.Azienda;

import com.thera.thermfw.security.*;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public abstract class YPsnDatiConnPthSl2appPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YPsnDatiConnPthSl2app cInstance;

	protected String iApiKey;

	protected String iUserCalls;

	protected String iPwdCalls;

	protected String iUrlCalls;
	
	protected String iHashUserJolly;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YPsnDatiConnPthSl2app)Factory.createObject(YPsnDatiConnPthSl2app.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YPsnDatiConnPthSl2app elementWithKey(String key, int lockType) throws SQLException {
		return (YPsnDatiConnPthSl2app)PersistentObject.elementWithKey(YPsnDatiConnPthSl2app.class, key, lockType);
	}

	public YPsnDatiConnPthSl2appPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setApiKey(String apiKey) {
		this.iApiKey = apiKey;
		setDirty();
	}

	public String getApiKey() {
		return iApiKey;
	}

	public void setUserCalls(String userCalls) {
		this.iUserCalls = userCalls;
		setDirty();
	}

	public String getUserCalls() {
		return iUserCalls;
	}

	public void setPwdCalls(String pwdCalls) {
		this.iPwdCalls = pwdCalls;
		setDirty();
	}

	public String getPwdCalls() {
		return iPwdCalls;
	}

	public void setUrlCalls(String urlCalls) {
		this.iUrlCalls = urlCalls;
		setDirty();
	}

	public String getUrlCalls() {
		return iUrlCalls;
	}
	
	public String getHashUserJolly() {
		return iHashUserJolly;
	}

	public void setHashUserJolly(String iHashUserJolly) {
		this.iHashUserJolly = iHashUserJolly;
		setDirty();
	}

	public void setIdAzienda(String idAzienda) {
		iAzienda.setKey(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(key);
	}

	public String getKey() {
		return getIdAzienda();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YPsnDatiConnPthSl2appTM.getInstance();
	}

}

