
package it.softre.thip.base.connettori.legami;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.thera.thip.base.agentiProvv.Agente;
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
 *         Estensione entita' in cui posso legare un {@link Agente} ad un
 *         {@link YUtentiSales2App}
 *         </p>
 */

public class YLegameAgenteUtenteTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String R_AGENTE = "R_AGENTE";

	public static final String R_UTENTE = "R_UTENTE";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YLEGAME_AGENTE_UTENTE";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.legami.YLegameAgenteUtente.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YLegameAgenteUtenteTM.class);
		}
		return cInstance;
	}

	public YLegameAgenteUtenteTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdAgente", R_AGENTE);
		addAttribute("IdUtenteS2App", R_UTENTE);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + R_AGENTE);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(ID_AZIENDA + ", " + R_AGENTE + ", " + R_UTENTE + ", " + STATO + ", " + R_UTENTE_CRZ + ", "
				+ TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
