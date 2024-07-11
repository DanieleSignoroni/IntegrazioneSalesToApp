package it.softre.thip.base.connettori.legami.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;
import com.thera.thermfw.web.servlet.GridActionAdapter;

import it.softre.thip.base.connettori.legami.YLegameAgenteUtente;
import it.thera.thip.base.agentiProvv.Agente;
import it.thera.thip.base.agentiProvv.AgenteTM;
import it.thera.thip.base.azienda.Azienda;

/**
 * 
 * <h1>Softre Solutions</h1> <br>
 * 
 * @version 1.0
 * @author Daniele Signoroni 03/11/2023 <br>
 *         <br>
 *         <b>71289 DSSOF3 03/11/2023</b>
 *         <p>
 *         Popolare con tutti gli agenti di def.
 *         </p>
 */

public class YLegameAgenteUtenteGridActionAdapter extends GridActionAdapter {

	private static final long serialVersionUID = 1L;

	protected static final String RES = "it.softre.thip.base.connettori.legami.resources.YLegameAgenteUtente";

	public static final String POPOLA_DEFAULT = "POPOLA_DEFAULT";

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton showRighe = new WebToolBarButton("PopolaDefault", "action_submit", "same", "infoArea", RES,
				"POPOLA_TUTTI", "it/thera/thip/base/documenti/ViewRighe.gif", POPOLA_DEFAULT, "none", false);
		toolBar.addButton(showRighe);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String action = se.getRequest().getParameter(ACTION);
		if (action.equals(POPOLA_DEFAULT)) {
			try {
				String where = " " + AgenteTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "' ";
				Vector<Agente> agenti = Agente.retrieveList(Agente.class, where, "", false);
				for (Iterator iterator = agenti.iterator(); iterator.hasNext();) {
					Agente agente = (Agente) iterator.next();
					YLegameAgenteUtente legame = (YLegameAgenteUtente) Factory.createObject(YLegameAgenteUtente.class);
					legame.setKey(agente.getKey());
					if (legame.retrieve()) {
						legame.setOnDB(true); // per andare in update
					}
					if (legame.save() >= 0) {
						ConnectionManager.commit();
					} else {
						ConnectionManager.rollback();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.callShowGrid(se);
		} else {
			super.otherActions(cadc, se);
		}
	}
}
