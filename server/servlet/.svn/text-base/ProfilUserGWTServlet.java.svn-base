package com.arkea.com.arkea.commons.archetypes.server.servlet;

import java.util.HashMap;

import javax.annotation.Nullable;

import net.gicm.methode.clientgestioncontexte.bo.ContexteSalarieBean;
import net.gicm.methode.clientgestioncontexte.bo.HabilitationBean;
import net.gicm.methode.clientgestioncontexte.bo.MapHabilitationBean;
import net.gicm.methode.clientgestioncontexte.servlet.ClientGestionContexteLiaison;
import net.gicm.methode.paramfede.ParamFede;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.commons.ihm.client.ihmevent.model.ProfilSalarieBean;
import com.arkea.commons.ihm.shared.model.ApplicationException;

import com.arkea.com.arkea.commons.archetypes.server.commons.bean.UserSession;
import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;
import com.arkea.com.arkea.commons.archetypes.shared.service.ProfilUserService;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ProfilUserRequestBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ProfilUserResponseBean;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * This servlet is the remote entry point for the GWT-RPC service ProfilUser.
 */
@Singleton
@SuppressWarnings("serial")
public class ProfilUserGWTServlet extends AbstractGWTServlet implements ProfilUserService.Iface {

  /**
   * Logger shared instance
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(ProfilUserGWTServlet.class);
  
    // Objet de contexte partagé sur le serveur
    @Inject
    Provider<UserSession> userSessionProv;
    
    @Inject @Nullable
    ParamFede paramFede;
    
    /**
     * Servlet de recuperation du profil salarié connecté
     * @param entree
     * @return
     * @throws ApplicationException
     */
    public ProfilUserResponseBean getProfilUserService(ProfilUserRequestBean entree) throws ApplicationException {
	
    	ProfilUserResponseBean sortie = new ProfilUserResponseBean();
    	
    	try {
    		UserSession userSession = userSessionProv.get();
    		ContexteSalarieBean ctxSalarie = userSession.getCtxSalarie();
    
    		//initialisation de l'environement par defaut
    		userSession.setCodeEfsTravail(ctxSalarie.getCodeEFSHab());
    		userSession.setCodeSiTravail(ctxSalarie.getCodeSIHab());
    		MapHabilitationBean listHabil = ClientGestionContexteLiaison.rechercheMapHabilitationParEFS(ctxSalarie.getUser(), userSession.getCodeEfsTravail() , HabilitationUtils.KEY_HABILITATION);
    		userSession.setContexteHabilitation(listHabil);

    		
    	 	  int habSalarie = 0;
        	  //Recuperation du contexte salarie
        	  if (userSession.getContexteHabilitation() != null) {
        		  try {
        			  HabilitationBean strHabSalarie = userSession.getContexteHabilitation().getMapHabilitations().get(userSession.getCodeEfsTravail());
        			  if (strHabSalarie != null) {
        				  habSalarie = Integer.parseInt(strHabSalarie.getNiveauDelegation());
        			  }
        			} catch (Exception e) {
        				throwTechException(e);
        			}
        	  }
        	  
        	  // Ajout de log pour la connexion
        	  if (LOGGER.isDebugEnabled()) {
        	    	StringBuilder affichageLog = new StringBuilder("Connection de ").append(ctxSalarie.getUser());
        	    	if (habSalarie > 0) {
        	    		affichageLog.append(" avec le niveau d'habilitation ").append(habSalarie);
        	    	} else {
        	    		affichageLog.append(" sans habilitation ");
        	    	}
        	    	affichageLog.append(" pour le codeEFS ").append(ctxSalarie.getCodeEFSHab());
        	    	LOGGER.debug(affichageLog.toString());
        	  }
        	  
        	  // Récupération du niveau d'habilitation
        	  // alimentation du profil pour la partie cliente
        	  ProfilSalarieBean profil = new ProfilSalarieBean();
        	  profil.setNomUsu(ctxSalarie.getNomUsuel());
        	  profil.setUser(ctxSalarie.getUser());
        	  profil.setHabilitation(habSalarie);
        	  profil.setCdEfs(ctxSalarie.getCodeEFSHab());
        	  sortie.setSalarie(profil);
        	  
        	  
        	 
          
         	  HashMap<String, String> tabFede = new HashMap<String, String>();
        	  for(String efs: userSession.getContexteHabilitation().keySet()) {
        		  String libEfs = efs;
        		  if (paramFede != null) {
        			  LOGGER.info("appel paramFede");
        			  libEfs = (String) paramFede.getParamFede(efs, "", "LIB-FED").get(0);
        			  LOGGER.info("retour paramFede");
        			  libEfs.trim();
        		  } else {
        			  LOGGER.error("Erreur de chargement de paramFede");
        		  }
        		  tabFede.put(efs,libEfs);
        	  }
        	  sortie.setMabFederationsAuthorisee(tabFede);
        	} catch (ApplicationException e) {
        		LOGGER.error("ProfilUserGWTServlet.getProfilUserService", e);
        		throw e;
        	} catch (Exception e) {
        		  LOGGER.error("ProfilUserGWTServlet.getProfilUserService", e);
        		throw new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,e.getMessage());
        	}
          
          return sortie;
    }
}
