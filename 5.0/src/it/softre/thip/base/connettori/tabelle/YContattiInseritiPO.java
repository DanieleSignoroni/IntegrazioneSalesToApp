package it.softre.thip.base.connettori.tabelle;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import com.thera.thermfw.security.*;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public abstract class YContattiInseritiPO extends PersistentObject implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YContattiInseriti cInstance;

	protected Integer iRAnagrafico;

	protected Integer iRSequenzaRub;

	protected DatiComuniEstesi iDatiComuniEstesi;

	protected String iHash;

	public String getHash() {
		return iHash;
	}

	public void setHash(String iHash) {
		this.iHash = iHash;
	}

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YContattiInseriti)Factory.createObject(YContattiInseriti.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YContattiInseriti elementWithKey(String key, int lockType) throws SQLException {
		return (YContattiInseriti)PersistentObject.elementWithKey(YContattiInseriti.class, key, lockType);
	}

	public YContattiInseritiPO() {
		iDatiComuniEstesi = (DatiComuniEstesi) Factory.createObject(DatiComuniEstesi.class);
		iDatiComuniEstesi.setOwner(this);
		lockType = NO_LOCK;
	}

	public void setRAnagrafico(Integer rAnagrafico) {
		this.iRAnagrafico = rAnagrafico;
		setDirty();
		setOnDB(false);
	}

	public Integer getRAnagrafico() {
		return iRAnagrafico;
	}

	public void setRSequenzaRub(Integer rSequenzaRub) {
		this.iRSequenzaRub = rSequenzaRub;
		setDirty();
		setOnDB(false);
	}

	public Integer getRSequenzaRub() {
		return iRSequenzaRub;
	}

	public DatiComuniEstesi getDatiComuniEstesi() {
		return iDatiComuniEstesi;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YContattiInseritiPO yContattiInseritiPO = (YContattiInseritiPO)obj;
		iDatiComuniEstesi.setEqual(yContattiInseritiPO.iDatiComuniEstesi);
	}
	@Override
	public void setTimestamp(Timestamp t) throws SQLException {
		return;
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setRAnagrafico(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 1)));
		setRSequenzaRub(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
	}

	public String getKey() {
		Integer rAnagrafico = getRAnagrafico();
		Integer rSequenzaRub = getRSequenzaRub();
		Object[] keyParts = {rAnagrafico, rSequenzaRub};
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YContattiInseritiTM.getInstance();
	}

}

