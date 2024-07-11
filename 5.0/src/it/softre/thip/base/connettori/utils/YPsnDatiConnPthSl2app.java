package it.softre.thip.base.connettori.utils;

import java.sql.SQLException;
import java.util.Hashtable;

import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.Cacheable;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.PersistentObjectCache;

import it.thera.thip.base.azienda.Azienda;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 16/10/2023
 * <br><br>
 * <b>71261	DSSOF3	16/10/2023</b>	<p>Prima stesura.</p>
 */

public class YPsnDatiConnPthSl2app extends YPsnDatiConnPthSl2appPO implements Cacheable {

	@SuppressWarnings("rawtypes")
	protected static Hashtable iHistory_YPsnDatiConnPthSl2app = new Hashtable();

	public static YPsnDatiConnPthSl2app getCurrentYPsnDatiConnPthSl2app()
	{
		return getYPsnDatiConnPthSl2app(Azienda.getAziendaCorrente());
	}

	@SuppressWarnings("unchecked")
	public static YPsnDatiConnPthSl2app getYPsnDatiConnPthSl2app(String iIdAzienda)
	{
		if (iIdAzienda == null)
			return null;

		YPsnDatiConnPthSl2app iYPsnDatiConnPthSl2app = null;

		try
		{
			if(PersistentObjectCache.isEnabled())
			{
				return (YPsnDatiConnPthSl2app)PersistentObject.readOnlyElementWithKey(YPsnDatiConnPthSl2app.class, iIdAzienda);
			}
			else
			{
				if(iHistory_YPsnDatiConnPthSl2app.containsKey(iIdAzienda))
					return (YPsnDatiConnPthSl2app)iHistory_YPsnDatiConnPthSl2app.get(iIdAzienda);
				else
				{
					iYPsnDatiConnPthSl2app=YPsnDatiConnPthSl2app.elementWithKey(iIdAzienda, PersistentObject.OPTIMISTIC_LOCK);
					if(iYPsnDatiConnPthSl2app != null)
						iHistory_YPsnDatiConnPthSl2app.put(iIdAzienda,iYPsnDatiConnPthSl2app);
				}
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		return iYPsnDatiConnPthSl2app;
	}

	@SuppressWarnings("unchecked")
	public int saveOwnedObjects(int rc) throws SQLException{
		rc += super.saveOwnedObjects(rc);

		if(rc >= 0)
			iHistory_YPsnDatiConnPthSl2app.put(this.getIdAzienda(),this);

		return rc;
	}

	public ErrorMessage checkDelete() {
		return null;
	}

}

