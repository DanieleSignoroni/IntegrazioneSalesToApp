package it.softre.thip.base.connettori.tabelle;

import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public class YContattiInseriti extends YContattiInseritiPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static YContattiInseriti recuperaContattoInserito(Integer idAnagrafico, Integer idSequenzaRubrica) {
		YContattiInseriti cliente = null;
		Vector list;
		String where;
		try {
			where = " "+YContattiInseritiTM.R_ANAGRAFICO+" = '"+idAnagrafico+"' AND "+YContattiInseritiTM.R_SEQUENZA_RUB+" = '"+idSequenzaRubrica+"' ";
			list = YContattiInseriti.retrieveList(YContattiInseriti.class, where, "", false);
			if(list.size() > 0) {
				cliente = (YContattiInseriti) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		return cliente;
	}

}

