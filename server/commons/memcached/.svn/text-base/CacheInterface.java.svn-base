package com.arkea.com.arkea.commons.archetypes.server.commons.memcached;

/**
 * 
 * Cache pour un contexte donné.
 * 
 * @version $Revision: 1.0 $
 * @author dm
 * 
 */
public interface CacheInterface<T> {

    /**
     * Obtient le contexte du cache (sujet)
     * 
     * @return le contexte.
     */
    public String getContext();

    /**
     * Lecture dans le cache d'un objet désigné par une clé.<br/> renvoie <code>null</code> si l'objet n'est pas
     * présent dans le cache, ou est obsolète.
     * 
     * @param key la clé designant l'objet.
     * @return l'objet lu dans le cache.
     */
    public T get(final String key);

    /**
     * Stockage dans le cache d'un objet désigné par une clé.
	 * 
	 * @param key
	 *            cle
	 * @param comment
	 *            commentaire
	 * @param obj
	 *            objet
	 * @param keyTTL
	 *            cle ttl
	 */
    public void put(final String key, final String comment, final T obj, final String keyTTL);
    
    /**
     * Recuperation du TimeLimit par defaut
     * @return ttl
     */
    public int getTimelimit();
    
    /**
     * Recuperation du nom du service
     * @return nom du service
     */
    public String getServiceName();
    
    /**
     * Recuperation de l'indicateur permettant de connaitre l'état d'activation (true ou false)
     * @return booleen
     */
    public boolean isMemcachedEnable();
    
}
