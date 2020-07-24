package com.arkea.com.arkea.commons.archetypes.server.servlet;

import java.util.ArrayList;
import java.util.List;

import com.arkea.com.arkea.commons.archetypes.server.commons.bean.UserSession;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.BaseParametreDAO;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAOResponseBean;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;
import com.arkea.com.arkea.commons.archetypes.shared.service.BaseParametreService;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreRequestBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreResponseBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementConsommeBean;
import com.arkea.commons.ihm.shared.model.ApplicationException;

import net.spy.memcached.compat.log.LoggerFactory;


/**
 * This servlet is the remote entry point for the GWT-RPC service Reservoir.
 */
@Singleton
@SuppressWarnings("serial")
public class BaseParametreGWTServlet  extends AbstractGWTServlet implements BaseParametreService.Iface{

	/**
	 * Logger shared instance
	 */
	private static final net.spy.memcached.compat.log.Logger LOGGER = LoggerFactory.getLogger(BaseParametreGWTServlet.class);


	// Objet de contexte partagé sur le serveur
	@Inject
	Provider<UserSession> userSessionProv;

	@Inject
	BaseParametreDAO BaseParametreDao;

	public BaseParametreResponseBean searchReservoir(BaseParametreRequestBean requestServlet) throws ApplicationException {

		BaseParametreResponseBean responseServlet = new BaseParametreResponseBean();
		responseServlet.setRequest(requestServlet);
		UserSession userSession = userSessionProv.get();


		try {
			// Habilitation minimum nécéssaire pour effectuer l'action
			// pour l'habilitation, passer par des profils renseignés 

			checkHabilitation(userSession, HabilitationUtils.PROFIL_NONHABILITE);

			// Log de l'appel
			if (LOGGER.isDebugEnabled()) {
				StringBuilder affichageLog = new StringBuilder("Acces servlet à la fonction searchReservoir");
				LOGGER.debug(affichageLog.toString());
			}

			List<TN00PR0DAOResponseBean> responseDAO =  BaseParametreDao.findFicherMR(
					userSession.getCtxSalarie().getUser(), 
					requestServlet.getCodeAppliParametre(), 
					requestServlet.getCodeEFSParametre(), 
					requestServlet.getNumeroSequenceParametre());

			ElementConsommeBean elementCB = new ElementConsommeBean();
			ElementBean element = new ElementBean();

			for(int i =0; i< responseDAO.size(); i++){
				element.setCD_APLI(responseDAO.get(i).getCodeAppliParametre()) ;
				element.setCD_EFS(responseDAO.get(i).getCodeEFSParametre());
				element.setNO_SEQ(responseDAO.get(i).getNumeroSequenceParametre());
				element.setCMT(responseDAO.get(i).getCommentaire());
				element.setVlrPar(responseDAO.get(i).getValeurParametre());
				element.setTmStp(responseDAO.get(i).getTimeStamp());
			}


			ArrayList<ElementConsommeBean> listeElementsConsommes = new ArrayList<ElementConsommeBean>();
			elementCB.setElement(element);
			listeElementsConsommes.add(elementCB) ;
			responseServlet.setListeElementsConsommes(listeElementsConsommes);

		} catch (Exception e) {
			LOGGER.error("Erreur searchReservoir pour " + requestServlet.getInfo(), e);
			throw new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,
					e.getClass().getName() + " " + e.getMessage());
		}

		return responseServlet;
	}

}
