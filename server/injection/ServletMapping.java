package com.arkea.com.arkea.commons.archetypes.server.injection;

import com.arkea.commons.cas.GicmCASFilter;
import com.arkea.commons.cas.gwt.GwtCasFilter;
import com.google.inject.servlet.ServletModule;
import com.arkea.commons.cas.gwt.RewriteUrlFragmentFilter;

/**
 * URL Mapping 
 */
public class ServletMapping extends ServletModule {


	@Override
	protected void configureServlets() {

		//
		// map url to service key
		// service key are mapped to implementation with help of ServletBinder
		//

		// CAS GWT
		bind(GwtCasFilter.class).asEagerSingleton();
		filter("/*").through(GwtCasFilter.class);  

		// CAS
		bind(GicmCASFilter.class).asEagerSingleton();
		filter("/*").through(GicmCASFilter.class);

		// permet de re-transformer l'history token en dièse lorsque la session a expiré
		bind(RewriteUrlFragmentFilter.class).asEagerSingleton();
		filter("/*").through(RewriteUrlFragmentFilter.class);




		mappingServlet();

	}

	private void mappingServlet() {

		serve("/Test/gwt/ProfilUserService").with(com.arkea.com.arkea.commons.archetypes.server.servlet.ProfilUserGWTServlet.class);  
		serve("/Test/gwt/BaseParametreService").with(com.arkea.com.arkea.commons.archetypes.server.servlet.BaseParametreGWTServlet.class);

		//-- DO NOT REMOVE Marker Mapper Serve Action --//
	}

}
