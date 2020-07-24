package com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0;

import java.util.List;

import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAOResponseBean;

public interface TN00PR0DAOIface {

	/**
	 * @param entreeDAO bean d'entree
	 * @return bean de sortie
	 * @throws Exception exception
	 */
	public abstract List<TN00PR0DAOResponseBean> lectureBaseParametre(TN00PR0DAORequestBean entreeDAO) throws Exception;

}
