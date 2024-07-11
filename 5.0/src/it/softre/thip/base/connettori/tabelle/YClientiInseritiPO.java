package it.softre.thip.base.connettori.tabelle;

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

public abstract class YClientiInseritiPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YClientiInseriti cInstance;

	protected String iIdCliente;
	
	protected String iHash;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YClientiInseriti)Factory.createObject(YClientiInseriti.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YClientiInseriti elementWithKey(String key, int lockType) throws SQLException {
		return (YClientiInseriti)PersistentObject.elementWithKey(YClientiInseriti.class, key, lockType);
	}

	public YClientiInseritiPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdCliente(String idCliente) {
		this.iIdCliente = idCliente;
		setDirty();
		setOnDB(false);
	}

	public String getIdCliente() {
		return iIdCliente;
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

	public String getHash() {
		return iHash;
	}

	public void setHash(String iHash) {
		this.iHash = iHash;
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
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdCliente(KeyHelper.getTokenObjectKey(key, 2));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String idCliente = getIdCliente();
		Object[] keyParts = {idAzienda, idCliente};
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YClientiInseritiTM.getInstance();
	}

}

