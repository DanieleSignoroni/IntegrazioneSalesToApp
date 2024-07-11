package it.softre.thip.base.connettori.tabelle;

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

public class YClientiInseritiTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID_CLIENTE = "ID_CLIENTE";
	
	public static final String HASH = "HASH";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YCLIENTI_INSERITI";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.tabelle.YClientiInseriti.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(YClientiInseritiTM.class);
		}
		return cInstance;
	}

	public YClientiInseritiTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("IdCliente", ID_CLIENTE);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("Hash",HASH);
		
		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + ID_CLIENTE);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}

