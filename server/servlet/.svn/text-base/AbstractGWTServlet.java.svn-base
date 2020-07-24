package com.arkea.com.arkea.commons.archetypes.server.servlet;

import net.gicm.methode.clientgestioncontexte.bo.HabilitationBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;
import com.arkea.com.arkea.commons.archetypes.server.commons.bean.UserSession;
import com.arkea.commons.ihm.shared.model.ApplicationException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Singleton;

/**
 * Cette servlet permet de faire partager des fonctions à toutes les servlet.
 * Notemment la gestion d'habilitation, et la construction d'ApplicationException...
 * Toutes les servlet GWT doivent l'étendre.
 */
@Singleton
@SuppressWarnings("serial")
public abstract class AbstractGWTServlet extends RemoteServiceServlet {

  /**
   * Logger shared instance
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGWTServlet.class);
	
  /**
   * Cete méthode controle le niveau d'habilitation du service en fonction du user connecté
   * @param userSession
   * @param habilService
   * @throws ApplicationException
   */
  protected void checkHabilitation(UserSession userSession,int habilService) throws ApplicationException {
		if (habilService != HabilitationUtils.PROFIL_NONHABILITE) {
			if ((userSession.getContexteHabilitation() == null) 
			 || (!userSession.getContexteHabilitation().getMapHabilitations().containsKey(userSession.getCodeEfsTravail())) ) {
				if (LOGGER.isDebugEnabled()) {
					StringBuilder affichageLog = new StringBuilder(userSession.getCtxSalarie().getUser());
					affichageLog.append("n'a aucune habilitation pour le codeEFS ").append(userSession.getCodeEfsTravail());
			    	LOGGER.debug(affichageLog.toString());
				}
				throwException("Vous n'êtes pas habilité à faire cette demande.");
			} else {
				HabilitationBean habilit = userSession.getContexteHabilitation().getMapHabilitations().get(userSession.getCodeEfsTravail());
				int habSalarie = 0;
				if (null != habilit){
					try {
						habSalarie = Integer.parseInt(habilit.getNiveauDelegation());
					} catch (Exception e) {
						throwTechException(e);
					}
					if (habSalarie < habilService) {
						throwException("Vous n'êtes pas habilité à faire cette demande.");
					}
				} else {
					throwException("Vous n'êtes pas habilité à faire cette demande.");
				}
			}
		}
	}
  
  /**
   * Generation d'une ApplicationException (client) à partie d'un message
   * @param message
   * @throws ApplicationException
   */
	public void throwException(String message) throws ApplicationException {
		LOGGER.error(message);
		throw new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,message);
	}
	
	/**
	 * Generation d'une ApplicationException TECHNIQUE (client) à partie d'une exception
	 * 
	 * @param e
	 * @throws ApplicationException
	 */
	public void throwTechException(Exception e) throws ApplicationException {
		LOGGER.error(e.getMessage());
		throw new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,e.getMessage());
	}
	
	/**
	 * 
	 * Generation d'une ApplicationException APPLICATIVE (client) à partie d'une exception
	 * @param e
	 * @throws ApplicationException
	 */
	public void throwApplicationException(Exception e) throws ApplicationException {
		LOGGER.error(e.getMessage());
		throw new ApplicationException(ApplicationException.TYPE_EXCEPTION.APPLICATIVE,e.getMessage());
	}
}
