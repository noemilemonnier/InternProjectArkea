package com.arkea.com.arkea.commons.archetypes.server.commons.memcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.commons.memcached.MemcachedClientHelper;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Exemple d'implémentation d'un cache HOST
 * 
 */
public class CacheMemCachedImpl<T> implements CacheInterface<T> {
	/**
	 * Gestion des LOG
	 */
	private static Logger LOG = LoggerFactory.getLogger(CacheMemCachedImpl.class);

	/**
	 * ID du Memcached utilisé (réferencé dans le fichier properties)
	 */
	private final String idCached;
	
	/**
	 * Nom du service Memcached utilisé pour ce Cache
	 */
	private final String serviceName;

	/**
	 * contexte du cache (sujet)
	 */
	private final String context;

	/**
	 * La durée de vie max (en secondes) des objets placés dans ce cache. Aucune
	 * limite par défaut.
	 */
	private final int timelimitdefault;
	
	/**
	 * Indicateur d'activation ou non du memcached
	 */
	private final boolean memcachedEnable;

	/**
	 * Construit un nouveau Cache avec une limite
	 * 
	 * @param idCached
	 *            Identifiant du cache.
	 * @param serviceName
	 *            Nom du service Memcached utilisé pour ce cache.
	 * @param context
	 *            le contexte (sujet) du cache.
	 * @param timelimit
	 *            la durée de vie max (en secondes)
	 * @param enable
	 *            indicateur d'activation
	 */
	@Inject
	public CacheMemCachedImpl(@Assisted String idCached,
			@Assisted String serviceName, @Assisted String context,
			@Assisted Integer timelimit, @Assisted boolean enable) {
		this.context = context;
		this.timelimitdefault = timelimit;
		this.serviceName = serviceName;
		this.memcachedEnable = enable;
		this.idCached = idCached;

		if (LOG.isDebugEnabled()) {
			LOG.debug("Contexte du cache (sujet) : " + this.context);
		}
	}

	/**
	 * Recuperation du time limit defaut
     * @return ttl 
	 */
	public int getTimelimit() {
		return timelimitdefault;
	}

	/**
	 * Test de l'activation ou non
	 * @return boolean
	 */
	public boolean isMemcachedEnable() {
		return memcachedEnable;
	}

	/**
	 * Recuperation du nom du service
	 * @return nom du service
	 */
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * Recuperation du contexte
	 * @return context
	 */
	public final String getContext() {
		return context;
	}

	/**
	 * Creation de la clé
	 * @param key cle
	 * @return cle
	 */
	private String getRealKey(String key) {
		StringBuilder sb = new StringBuilder(context);
		sb.append('.');
		sb.append(key);
		return sb.toString();
	}

	/**
	 * Methode de recuperation d'une clé dans le memcached
	 * 
	 * @param key
	 * 			clé dans le cache
	 * @return T
	 */
	public T get(String key) {
		// prepare le 'contexte' du cache à la clé fournie
		final String realKey = getRealKey(key);

		// Si on a pas activé le memcached on ne s'y connecte pas
		if (!memcachedEnable) {
			return null;
		}

		/**
		 * lecture dans le cache Utilisation de MemcachedClientHelper à chaque
		 * utilisation afin de bénéficier de la résolution dynamique
		 * 
		 * @See "go/memcached"
		 */
		try {
			@SuppressWarnings("unchecked")
			final T o = (T) MemcachedClientHelper.getInstance(context,
					serviceName).get(realKey);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Lecture en cache de [" + realKey + "]: "
						+ ((null == o) ? "introuvable" : "trouve"));
			}
			return o;
		} catch (Exception e) {
			LOG.error("Erreur Lecture Memcached : ", e);
			return null;
		}
	}

	/**
	 * Methode d'ajout d'une clé dans le memcached
	 * 
	 * @param key
	 * 			clé dans le cache
	 * @param comment
	 * 			commentaire utilisé par le CacheUtils
	 * @param obj
	 * 			Objet associé a la clé
	 * @param keyTTL
	 * 			Duree de vie dans le cache
	 */
	
	public void put(String key, String comment, T obj, String keyTTL) {
		String realKey = getRealKey(key);
		int ttl = timelimitdefault;

		// recuperation du TTL particulier
		if (keyTTL != null) {
			int ttltmp = 0;
			try {
				ttltmp = Integer.parseInt(CacheUtils.getListKeyTTL()
						.get(keyTTL));

				if ((ttltmp <= 0) || (ttltmp > 86400)) {
					LOG.error("Par convention, la valeur du ttl doit être > 0 (unlimited) et < 86400 (1 day).");
				} else {
					ttl = ttltmp;
				}
			} catch (Exception e) {
				LOG.error("La valeur du ttl n'est pas bonne ou n'a pas été trouvé.");
			}
		}

		// Verification de l'activation du memcached
		if (!memcachedEnable) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Memcached " + serviceName + " - " + context + " non activé");
			}
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Stockage en cache de [" + realKey + "] pour " + ttl
						+ " secondes");
			}

			/**
			 * Utilisation de MemcachedClientHelper à chaque utilisation afin de
			 * bénéficier de la résolution dynamique
			 * 
			 * @See "go/memcached"
			 */
			try {
				MemcachedClientHelper.getInstance(context, serviceName).set(
						realKey, ttl, obj);
				CacheUtils.addListObjCachBean(new CacheBean(realKey, comment
						.toString(), idCached, ttl));
			} catch (Exception e) {
				LOG.error("Erreur Ecriture Memcached : ", e);
			}
		}
	}

}
