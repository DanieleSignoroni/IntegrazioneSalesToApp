package it.softre.thip.base.connettori.utils;

import com.thera.thermfw.persist.*;

import java.sql.*;

import com.thera.thermfw.base.*;

import it.thera.thip.cs.*;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public class YPsnDatiConnPthSl2appTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String API_KEY = "API_KEY";

	public static final String USER_CALLS = "USER_CALLS";

	public static final String PWD_CALLS = "PWD_CALLS";

	public static final String URL_CALLS = "URL_CALLS";

	public static final String HASH_USER_JOLLY = "R_HASH_USER_JOLLY";
	
	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YPSN_DATI_CONN_PTH_SL2APP";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(YPsnDatiConnPthSl2appTM.class);
		}
		return cInstance;
	}

	public YPsnDatiConnPthSl2appTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("ApiKey", API_KEY);
		addAttribute("UserCalls", USER_CALLS);
		addAttribute("PwdCalls", PWD_CALLS);
		addAttribute("UrlCalls", URL_CALLS);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("HashUserJolly", HASH_USER_JOLLY);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}

