package it.softre.thip.base.connettori;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.cs.DatiComuniEstesiTTM;

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

public class YUtentiSales2AppTM extends TableManager {

	public static final String HASH_USER = "HASH_USER";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String LASTNAME = "LASTNAME";

	public static final String FIRSTNAME = "FIRSTNAME";

	public static final String ID = "ID";

	public static final String EMAIL = "EMAIL";

	public static final String ROLE = "ROLE";

	public static final String PHONE = "PHONE";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YUTENTI_SALES_2_APP";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.YUtentiSales2App.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YUtentiSales2AppTM.class);
		}
		return cInstance;
	}

	public YUtentiSales2AppTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("HashUser", HASH_USER);
		addAttribute("Lastname", LASTNAME);
		addAttribute("FirstName", FIRSTNAME);
		addAttribute("Id", ID, "getIntegerObject");
		addAttribute("Email", EMAIL);
		addAttribute("Role", ROLE);
		addAttribute("Phone", PHONE);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(HASH_USER);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(HASH_USER + ", " + LASTNAME + ", " + FIRSTNAME + ", " + ID + ", " + EMAIL + ", " + ROLE + ", " + PHONE
				+ ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", "
				+ TIMESTAMP_AGG);
	}

}
