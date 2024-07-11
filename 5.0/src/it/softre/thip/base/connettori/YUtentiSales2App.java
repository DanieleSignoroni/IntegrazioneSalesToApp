package it.softre.thip.base.connettori;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.thera.thermfw.common.ErrorMessage;

import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;

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

public class YUtentiSales2App extends YUtentiSales2AppPO {

	@Override
	public void setTimestamp(Timestamp t) throws SQLException {
	}

	public ErrorMessage checkDelete() {
		return null;
	}

}
