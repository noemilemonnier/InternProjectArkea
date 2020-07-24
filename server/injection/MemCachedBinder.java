package com.arkea.com.arkea.commons.archetypes.server.injection;

import java.util.HashMap;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.com.arkea.commons.archetypes.server.commons.memcached.CacheInterface;
import com.arkea.com.arkea.commons.archetypes.server.commons.memcached.CacheMemCachedImpl;
import com.arkea.com.arkea.commons.archetypes.server.commons.memcached.CacheUtils;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class MemCachedBinder extends AbstractModule {

	private final static Logger LOG = LoggerFactory.getLogger(MemCachedBinder.class);

	@Override
	protected void configure() {
		try {
			// chargement du fichier properties
			ResourceBundle bundle = PropertyResourceBundle
					.getBundle("memcached");

			// enregistrement des données utiles dans CacheUtils 
			// (liste des memcached, liste des TTL,. ..)
			CacheUtils.digestProperties(bundle);

			// Boucle sur les properties et stockage pour l'injection
			HashMap<String, String> properties = new HashMap<String, String>();
			for (Object key : bundle.keySet()) {
				properties.put((String) key, bundle.getString((String) key));
			}
			Names.bindProperties(binder(), properties);

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		// -- DO NOT REMOVE Marker Binding Action--//
	}

	/**
	 * Provider of Cache implementation using MemcachedClientHelper (Memcached
	 * infrastructure)
	 * 
	 * @param context contexte
	 * @param timeLimit limite
	 * @param service service
	 * @param enable boolean
	 * @return implementation of CacheInterface<String>
	 */
	@Named("cache.default")
	@Provides
	@Singleton
	public CacheInterface<byte[]> provideCacheDefault(
			@Named("cache.default.context") String context,
			@Named("cache.default.timelimit") Integer timeLimit,
			@Named("cache.default.service") String service,
			@Named("cache.default.enable") boolean enable) {
		return new CacheMemCachedImpl("cache.default", service, context,
				timeLimit, enable);
	}

	/**
	 * Provider of Cache implementation using MemcachedClientHelper (Memcached
	 * infrastructure)
	 * 
	 * @param context contexte
	 * @param timeLimit limite
	 * @param service service
	 * @param enable boolean
	 * @return implementation of CacheInterface
	 */
	@Named("cache.daohost")
	@Provides
	@Singleton
	public CacheInterface<byte[]> provideCacheHost(
			@Named("cache.daohost.context") String context,
			@Named("cache.daohost.timelimit") Integer timeLimit,
			@Named("cache.daohost.service") String service,
			@Named("cache.daohost.enable") boolean enable) {
		return new CacheMemCachedImpl("cache.daohost", service, context,
				timeLimit, enable);
	}

	// -- DO NOT REMOVE Marker Providing Action--//
}
