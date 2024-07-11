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

public class YContattiInseritiTM extends TableManager {

	public static final String R_ANAGRAFICO = "R_ANAGRAFICO";

	public static final String R_SEQUENZA_RUB = "R_SEQUENZA_RUB";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YCONTATTI_INSERITI";

	public static final String HASH = "HASH";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.tabelle.YContattiInseriti.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(YContattiInseritiTM.class);
		}
		return cInstance;
	}

	public YContattiInseritiTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}


	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("RAnagrafico", R_ANAGRAFICO);
		addAttribute("RSequenzaRub", R_SEQUENZA_RUB);
		addAttribute("Hash",HASH);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(R_ANAGRAFICO + "," + R_SEQUENZA_RUB);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}


	private void init() throws SQLException {
		configure();
	}

}

