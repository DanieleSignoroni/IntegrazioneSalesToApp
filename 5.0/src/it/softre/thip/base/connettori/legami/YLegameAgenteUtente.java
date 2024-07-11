package it.softre.thip.base.connettori.legami;

import com.thera.thermfw.common.ErrorMessage;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.thera.thip.base.agentiProvv.Agente;

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

public class YLegameAgenteUtente extends YLegameAgenteUtentePO {

	public ErrorMessage checkDelete() {
		return null;
	}

}
