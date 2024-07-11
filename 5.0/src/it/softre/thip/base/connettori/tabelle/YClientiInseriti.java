package it.softre.thip.base.connettori.tabelle;

import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;

import it.thera.thip.base.azienda.Azienda;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public class YClientiInseriti extends YClientiInseritiPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static YClientiInseriti recuperaClienteInserito(String idCliente) {
		YClientiInseriti cliente = null;
		Vector list;
		String where;
		try {
			where = " "+YClientiInseritiTM.ID_CLIENTE+" = '"+idCliente+"' AND "+YClientiInseritiTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' ";
			list = YClientiInseriti.retrieveList(YClientiInseriti.class, where, "", false);
			if(list.size() > 0) {
				cliente = (YClientiInseriti) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		return cliente;
	}
}

