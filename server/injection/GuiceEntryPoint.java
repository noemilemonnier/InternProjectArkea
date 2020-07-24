package com.arkea.com.arkea.commons.archetypes.server.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Specify the EntryPoint for GuiceModule Configuration.
 * If you want to define non default Module (Jetty loading use case/test purpose), just provide
 * them.
 * @author herviou
 *
 */
public class GuiceEntryPoint extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new AbstractModule[]{
    		// register the service binder
    		new ServicesBinder()
          
    		// register the url mapping
    		, new ServletMapping()

		, new MemCachedBinder()
	, new DAOThriftBinder()
//-- DO NOT REMOVE Marker Guice ADDON --//
    	});
   	}
}
