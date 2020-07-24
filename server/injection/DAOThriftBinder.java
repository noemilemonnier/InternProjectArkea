package com.arkea.com.arkea.commons.archetypes.server.injection;

import java.util.HashMap;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.thrift.TServiceClientFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransportFactory;

import com.arkea.commons.thrift.pool.PoolableTServiceClientFactory;
import com.arkea.commons.thrift.pool.THttpClientFactory;
import com.arkea.commons.thrift.pool.TServiceClientPool;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

//-- DO NOT REMOVE Marker Binding DAO Import--//

public class DAOThriftBinder extends AbstractModule {
	
	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(DAOThriftBinder.class.getName());
	
	@Override
	protected void configure() {
	
		try {
			// chargement du fichier properties
			ResourceBundle bundle = PropertyResourceBundle.getBundle("thriftDAO");
			
			// Boucle sur les properties et stockage pour l'injection
			HashMap<String, String> properties = new HashMap<String, String>();
			for (Object key : bundle.keySet()) {
				properties.put((String) key, bundle.getString((String) key));
			}
			// Injection des properties
			Names.bindProperties(binder(), properties);

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	//-- DO NOT REMOVE Marker Provide Action --//
}
