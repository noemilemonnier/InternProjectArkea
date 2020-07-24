package com.arkea.com.arkea.commons.archetypes.shared.service;

import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreRequestBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreResponseBean;
import com.arkea.commons.ihm.shared.model.ApplicationException;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public class BaseParametreService {

	private BaseParametreService() {}

	/**
	 *  Interface Synchrone avec la declaration pour la servlet
	 * @author  generated by Archetype
	 *
	 */
	@RemoteServiceRelativePath("gwt/BaseParametreService")
	public interface Iface extends RemoteService{
		public BaseParametreResponseBean searchReservoir(BaseParametreRequestBean entree) throws ApplicationException;
	}


	/**
	 *  Interface ASynchrone 
	 * @author  generated by Archetype
	 *
	 */
	public interface IfaceAsync {
		public void searchReservoir(
				BaseParametreRequestBean entree, 
				AsyncCallback<BaseParametreResponseBean> sortie) throws ApplicationException;
	}
}