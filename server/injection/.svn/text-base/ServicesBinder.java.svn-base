package com.arkea.com.arkea.commons.archetypes.server.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.gicm.methode.paramfede.ParamFede;

import com.arkea.com.arkea.commons.archetypes.server.injection.ServicesBinder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

/**
 * GuiceModule used to bind interface of services to implementations
 * No gwt data have to be bind here !!!
 * 
 * Add a bind in the method "configure" like this :
 * bind(ThriftService.Iface.class
 * ).to(ThriftServiceImpl.class).in(Scopes.SINGLETON);
 */
public class ServicesBinder extends AbstractModule {

	private final static Logger LOG = LoggerFactory.getLogger(ServicesBinder.class);

	// ce boolean sert ÃƒÆ’Ã‚Â  indiquer si on map sur les implementation ou sur les mock
	private final static boolean MAPPINGMOCK = false; 

	/**
	 * configuration des mappings d'injection
	 */
	protected void configure() {
		LOG.debug("configuration des mappings d'injection");
		// par defaut on va sur l'implementation
		// changez le booleen ci-dessus pour passer en classe de test
		if (MAPPINGMOCK) {
			bindDAOMock();
		} else {
			bindDAO();
		}
	}

	/**
	 * Cette methode reference toutes les classes d'implementation
	 */
	protected void bindDAO() {

		bind(com.arkea.com.arkea.commons.archetypes.server.dao.webstore.WebstoreDAOIface.class)
		.to(com.arkea.com.arkea.commons.archetypes.server.dao.webstore.WebstoreDAOImpl.class)
		.in(Scopes.SINGLETON);
		//	bind(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00prm.TN00PRMDAOIface.class)
		//		.to(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00prm.TN00PRMDAOImpl.class)
		//		.in(Scopes.SINGLETON);
		bind(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.TN00PR0DAOIface.class)
		.to(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.TN00PR0DAOImpl.class)
		.in(Scopes.SINGLETON);
		//-- DO NOT REMOVE Marker Binder DAO Action --//
	}

	/**
	 * Cette methode reference toutes les classes de test
	 */
	protected void bindDAOMock() {

		//-- DO NOT REMOVE Marker Binder DAO Action MOCK --//
	}

	/**
	 * Recuperation de ParamFede par injection
	 */
	@Provides @Singleton
	ParamFede paramfede () {
		try {
			return ParamFede.getInstance();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return null;
		}
	}
	

}
