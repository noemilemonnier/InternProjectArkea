package com.arkea.com.arkea.commons.archetypes.server.commons.memcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ResourceBundle;

import net.federalservice.methode.cmpeci02.RequeteException;
import net.federalservice.methode.cmpeci02.Tn00cia;

/**
 * Classe permettant d'historiser les appels au cache
 * 
 */
public class CacheUtils {


	public final static String TTL_COURT 		= "ttl.court";
	public final static String TTL_LONG			= "ttl.long";
	public final static String TTL_TRESLONG		= "ttl.treslong";
	public final static String TIME_COURT 		= "60";
	public final static String TIME_LONG 		= "3600";
	public final static String TIME_TRESLONG 	= "10800";
	
	/**
	 * Gestion des LOG
	 */
	private static Logger LOG = LoggerFactory.getLogger(CacheUtils.class);
	
	/**
	 * Liste des memcached du fichier properties memcached.properties
	 */
	private static List<String> listObjMemcached;
	
	/**
	 * Liste permettant de stocker l'historique des ajout Memcached Cela peut
	 * permettre une gestion (purge totale,...)
	 */
	private static List<CacheBean> listObjCachBean;
	
	/**
	 * Liste cle TTL utilisables
	 */
	private static Map<String, String> listKeyTTL;

	/**
	 * constructeur
	 */
	private CacheUtils(){}
	
	/**
	 * Recuperation de la liste des objets stockés dans le cache
	 * avec initialisation si vide
	 * 
	 * @return liste
	 */
	public static List<CacheBean> getListObjCachBean() {

		if (listObjCachBean == null) {
			listObjCachBean = new ArrayList<CacheBean>();
		}
		return listObjCachBean;
	}
	
	/**
	 * Recuperation de la liste des identifiants memcached
	 * avec initialisation si vide
	 * 
	 * @return liste
	 */
	public static List<String> getListObjMemcached() {
		
		if (listObjMemcached == null) {
			listObjMemcached = new ArrayList<String>();
		}
		return listObjMemcached;
	}

	/**
	 * Recuperation de la liste des clé TTL utilisable
	 * avec initialisation si vide
	 * 
	 * @return liste
	 */
	public static Map<String, String> getListKeyTTL() {

		if (listKeyTTL == null) {
			listKeyTTL = new HashMap<String, String>();
			listKeyTTL.put(TTL_COURT,TIME_COURT);
			listKeyTTL.put(TTL_LONG,TIME_LONG);
			listKeyTTL.put(TTL_TRESLONG,TIME_TRESLONG);
		}
		return listKeyTTL;
	}
	
	/**
	 *Ajout d'un identifiant memcache dans la liste
	 * avec test d'existence
	 * 
	 * @param val valeur
	 */
	public static void addListObjMemcached(String val) {
		// verify if key don't exist
		if (!getListObjMemcached().contains(val)) {
			getListObjMemcached().add(val);
		}
	}
	
	/**
	 *Ajout d'une clé TTL dans la liste
	 * avec test d'existence
	 * 
	 * @param key clé
	 * @param val valeur
	 */
	public static void addListKeyTTL(String key, String val) {
		// verify if key don't exist
		if (getListKeyTTL().get(key) == null) {
			getListKeyTTL().put(key, val);
		}
	}
	
	/**
	 *Ajout d'une requete de mise en cache dans la liste
	 * 
	 * @param objCach objet
	 */
	public static void addListObjCachBean(CacheBean objCach) {
		getListObjCachBean().add(objCach);
	}

	/**
	 * Generation d'une clé SHA256 à partir du tableau de byte en entréé
	 * 
	 *  @param tabKey tableau
	 *  @return String key
	 */
	public static String formatKeySHA256(byte[] tabKey) {

		MessageDigest md = null;
		StringBuilder sb = null;
		try {
			// recuperation de l'algorythme
			md = MessageDigest.getInstance("SHA-256");
			sb = new StringBuilder();

			// creation du hash
			byte[] hash = md.digest(tabKey);

			// formatage en String
			for (byte b : hash) {
				if (b < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(b & 0xff));
			}

			// renvoi du resultat
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage());
		}

		return null;
	}

	/**
	 * Generation d'un commentaire host à partir du prog
	 * 
	 *  @param prog Tn00cia programme 
	 *  @return commentaire
	 */
	public static String formatCommentsHost(Tn00cia prog) {
		StringBuilder retour = new StringBuilder();

		retour.append("EFS:").append(prog.m_zoneTechnique.getY00cia__Cd__Efs());
		retour.append("_PROG:").append(prog.m_programName);
		retour.append("_FCT:").append(
				prog.m_zoneTechnique.getY00cia__Fct__Dem());

		return retour.toString();
	}

	/**
	 * Verification de l'existence d'un appel host en cache
	 * si oui on retourne
	 * si non on appel et on stocke le resultat en cache
	 * si keyTTL est "ttl.nocache" (-1) on ne passe pas par le cache
	 * @param prog programme
	 * @param memcached cache
	 * @param appli application
	 * @param codeEFS efs
	 * @param keyTTL cle
	 * @throws RequeteException exception
	 */
	public static void executeHostCachedTTL(Tn00cia prog, 
			CacheInterface memcached, String appli, String codeEFS,
			String keyTTL) throws RequeteException {

		if ("ttl.nocache".equals(keyTTL)) {
			prog.execute(appli, codeEFS);
			if (LOG.isDebugEnabled()) {
				LOG.debug("CacheUtils -> executeHostCachedTTL : Appel Host");
			}
		} else {
			String key = CacheUtils.formatKeySHA256(prog.getCommarea());
			String comment = CacheUtils.formatCommentsHost(prog);
			byte[] val = (byte[]) memcached.get(key);
			if (val == null) {
				// Appel du cics
				prog.execute(appli, codeEFS);
				memcached.put(key, comment, prog.getCommarea(), keyTTL);
				if (LOG.isDebugEnabled()) {
					LOG.debug("CacheUtils -> executeHostCachedTTL : Appel Host");
				}
			} else {
				// recuperation du memcached
				prog.splitCommarea(val);
				if (LOG.isDebugEnabled()) {
					LOG.debug("CacheUtils -> executeHostCachedTTL : Recuperation Memcached");
				}
			}
		}
	}
	
	/**
	 * Appel Host sans passer par le cache
	 * 
	 * @param prog programme
	 * @param appli application
	 * @param codeEFS efs
	 * @throws RequeteException exception
	 */
	public static void executeHostWithoutCached(Tn00cia prog, String appli, String codeEFS) throws RequeteException {
			prog.execute(appli, codeEFS);
			if (LOG.isDebugEnabled()) { LOG.debug("CacheUtils -> executeHostCachedTTL : Appel Host");}
	}
	
	/**
	 * Enregistrement des informations issues du fichier memcached.properties
	 * 
	 * @param bundle bundle
	 */
	public static void digestProperties(ResourceBundle bundle){
		// recuperation de la liste des memcached en properties
		String listMemcached = bundle.getString("listeMemcached");
		if (listMemcached != null) {
			String[] tabMemcached = listMemcached.split("\\|");
			for (String chaine : tabMemcached) {
				addListObjMemcached(chaine);
			}
		}

		// Boucle sur les properties du fichier memcached.properties
		// pour récupérer les TTL
		for (Object key : bundle.keySet()) {
			String cle = (String) key;
			if (cle.startsWith("ttl.")) {
				// recuperation dans CacheUtils si c'est un TTL
				addListKeyTTL(cle, bundle.getString(cle));
			} 
		}
	}


}
