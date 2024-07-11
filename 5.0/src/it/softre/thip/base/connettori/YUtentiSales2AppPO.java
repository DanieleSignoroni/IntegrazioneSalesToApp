package it.softre.thip.base.connettori;

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
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.cs.DatiComuniEstesi;

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

public abstract class YUtentiSales2AppPO extends PersistentObject
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YUtentiSales2App cInstance;

	protected String iHashUser;

	protected String iLastname;

	protected String iFirstName;

	protected Integer iId;

	protected String iEmail;

	protected String iRole;

	protected String iPhone;

	protected DatiComuniEstesi iDatiComuniEstesi;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YUtentiSales2App) Factory.createObject(YUtentiSales2App.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YUtentiSales2App elementWithKey(String key, int lockType) throws SQLException {
		return (YUtentiSales2App) PersistentObject.elementWithKey(YUtentiSales2App.class, key, lockType);
	}

	public YUtentiSales2AppPO() {
		iDatiComuniEstesi = (DatiComuniEstesi) Factory.createObject(DatiComuniEstesi.class);
		iDatiComuniEstesi.setOwner(this);

	}

	public void setHashUser(String hashUser) {
		this.iHashUser = hashUser;
		setDirty();
		setOnDB(false);
	}

	public String getHashUser() {
		return iHashUser;
	}

	public void setLastname(String lastname) {
		this.iLastname = lastname;
		setDirty();
	}

	public String getLastname() {
		return iLastname;
	}

	public void setFirstName(String firstName) {
		this.iFirstName = firstName;
		setDirty();
	}

	public String getFirstName() {
		return iFirstName;
	}

	public void setId(Integer id) {
		this.iId = id;
		setDirty();
	}

	public Integer getId() {
		return iId;
	}

	public void setEmail(String email) {
		this.iEmail = email;
		setDirty();
	}

	public String getEmail() {
		return iEmail;
	}

	public void setRole(String role) {
		this.iRole = role;
		setDirty();
	}

	public String getRole() {
		return iRole;
	}

	public void setPhone(String phone) {
		this.iPhone = phone;
		setDirty();
	}

	public String getPhone() {
		return iPhone;
	}

	public DatiComuniEstesi getDatiComuniEstesi() {
		return iDatiComuniEstesi;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YUtentiSales2AppPO yUtentiSales2AppPO = (YUtentiSales2AppPO) obj;
		iDatiComuniEstesi.setEqual(yUtentiSales2AppPO.iDatiComuniEstesi);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setHashUser(key);
	}

	public String getKey() {
		return getHashUser();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YUtentiSales2AppTM.getInstance();
	}

}
