package com.arkea.com.arkea.commons.archetypes.server.dao.webstore;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.sardine.DavResource;

import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAOResponseBean;


public class WebstoreDAOMock implements WebstoreDAOIface{
	
	private static Logger LOGGER = LoggerFactory.getLogger(WebstoreDAOMock.class);
	
	
	/**
	 * Création d'un répertoire
	 * @param le répertoire à créer (chemin complet) 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean createDirIfNotExists(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : Création du repertoire " + request.getPath());
		return null;
	}
	
	/**
	 * Suppression d'un fichier
	 * @param le fichier (chemin complet) 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean deleteFile(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : Suppression du repertoire " + request.getPath());
		return null;
	}
	
	/**
	 * vérifiaction d'un fichier ou répertoire
	 * @param le fichier/répertoire (chemin complet)
	 * @return un booleen
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean exists(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : Test d'existence de " + request.getPath());
		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		response.setExist(Boolean.TRUE);
		return response;
	}
	
	/**
	 * Recuperation d'un fichier
	 * @param le fichier (chemin complet)
	 * @return un inputStream
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean getFile(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : recuperation du fichier " + request.getPath());
		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		//TODO The MOCK implementation
		return response;
	}
	
	/**
	 * Recuperation d'une liste de fichiers
	 * @param le répertoire (chemin complet)
	 * @return une liste de ressources
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean listFiles(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : List du repertoire " + request.getPath());
		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		response.setListeRessources(new ArrayList<DavResource>());
		// retourne une liste vide
		return response;
	}
	
	/**
	 * Déposer un fichier
	 * @param le fichier + le chemin 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean storeFile(WebstoreDAORequestBean request) throws Exception{
		
		LOGGER.debug("MOCK : Dépôt du fichier " + request.getPath());
		return null;
	}
	

}