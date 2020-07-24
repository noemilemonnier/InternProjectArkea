package com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean;

import java.io.InputStream;
import java.util.List;

import com.googlecode.sardine.DavResource;



/**
 * @author Gaetan.Le-Hen
 *
 */
@SuppressWarnings("serial")
public class WebstoreDAOResponseBean {
	
	private InputStream resultat;
	private Boolean exist;
	private List<DavResource> listeRessources;

	// Constructeur vide
		public WebstoreDAOResponseBean() {
		}

		/**
		 * @return the resultat
		 */
		public InputStream getResultat() {
			return resultat;
		}

		/**
		 * @param resultat the resultat to set
		 */
		public void setResultat(InputStream resultat) {
			this.resultat = resultat;
		}

		/**
		 * @return the exist
		 */
		public Boolean getExist() {
			return exist;
		}

		/**
		 * @param exist the exist to set
		 */
		public void setExist(Boolean exist) {
			this.exist = exist;
		}

		/**
		 * @return the listeRessources
		 */
		public List<DavResource> getListeRessources() {
			return listeRessources;
		}

		/**
		 * @param listeRessources the listeRessources to set
		 */
		public void setListeRessources(List<DavResource> listeRessources) {
			this.listeRessources = listeRessources;
		}

		

	
	

}
