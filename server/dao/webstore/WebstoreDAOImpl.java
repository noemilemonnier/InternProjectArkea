package com.arkea.com.arkea.commons.archetypes.server.dao.webstore;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAOResponseBean;

import com.googlecode.sardine.Sardine;
import com.googlecode.sardine.SardineFactory;
import com.googlecode.sardine.impl.SardineException;

public class WebstoreDAOImpl implements WebstoreDAOIface{

	private static Logger LOG = LoggerFactory.getLogger(WebstoreDAOImpl.class);


	/**
	 * Création d'un répertoire
	 * @param le répertoire à créer (chemin complet) 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean createDirIfNotExists(WebstoreDAORequestBean request) throws Exception{

		try {
			LOG.debug("Enter createDirIfNotExist");
			final Sardine sardine = SardineFactory.begin();
			try {
				if (!this.exists(request).getExist()) {
					sardine.createDirectory(request.getPath());
				}
			} catch (final IOException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}
			LOG.debug("Exit createDirIfNotExist");
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Suppression d'un fichier
	 * @param le fichier (chemin complet) 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean deleteFile(WebstoreDAORequestBean request) throws Exception{

		try {
			LOG.debug("Enter deleteFile");
			final Sardine sardine = SardineFactory.begin();
			try {
				sardine.delete(request.getPath());
			} catch (final IOException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}
			LOG.debug("Exit deleteFile");
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	/**
	 * vérifiaction d'un fichier ou répertoire
	 * @param le fichier/répertoire (chemin complet)
	 * @return un booleen
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean exists(WebstoreDAORequestBean request) throws Exception{

		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		Boolean exists = Boolean.FALSE;
		try {
			LOG.debug("Enter exists");
			final Sardine sardine = SardineFactory.begin();

			if (request.getPath() == null) {
				exists = false;
			} else {
				if (!request.getPath().endsWith("/")) {
					// On est dans le cas d'un fichier
					try {
						exists = sardine.exists(request.getPath());
					} catch (final IOException e) {
						LOG.error(e.getMessage(), e);
						throw e;
					}
				} else {
					// Dans le cas d'un répertoire, il ne faut pas utiliser "exists"
					// (bloqué)
					try {
						sardine.list(request.getPath(), 0);
						exists = true;
					} catch (final SardineException se) {
						exists = false;
					} catch (final IOException e) {
						LOG.error(e.getMessage(), e);
						throw e;
					}
				}
			}
			LOG.debug("Exit exists");
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		}
		response.setExist(exists);
		return response;
	}

	/**
	 * Recuperation d'un fichier
	 * @param le fichier (chemin complet)
	 * @return un inputStream
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean getFile(WebstoreDAORequestBean request) throws Exception{

		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		try {
			LOG.debug("Enter getFile");

			final Sardine sardine = SardineFactory.begin();

			try {
				response.setResultat(sardine.get(request.getPath()));
			} catch (final IOException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}
			LOG.debug("Exit getFile");

			return response;

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Recuperation d'une liste de fichiers
	 * @param le répertoire (chemin complet)
	 * @return une liste de ressources
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean listFiles(WebstoreDAORequestBean request) throws Exception{

		WebstoreDAOResponseBean response = new WebstoreDAOResponseBean();
		try {
			LOG.debug("Enter listFiles");
			final Sardine sardine = SardineFactory.begin();

			try {
				response.setListeRessources(sardine.list(request.getPath()));
			} catch (final IOException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}

			LOG.debug("Exit listFiles");
			return response;

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Déposer un fichier
	 * @param le fichier + le chemin 
	 * @return
	 * @throws Exception
	 */
	public WebstoreDAOResponseBean storeFile(WebstoreDAORequestBean request) throws Exception{

		try {
			LOG.debug("Enter storeFile");
			final Sardine sardine = SardineFactory.begin();
			try {
				sardine.put(request.getPath(), request.getData());
			} catch (final IOException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}
			LOG.debug("Exit storeFile");
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}


}