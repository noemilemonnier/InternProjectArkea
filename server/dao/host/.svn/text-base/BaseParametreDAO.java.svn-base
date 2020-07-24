package com.arkea.com.arkea.commons.archetypes.server.dao.host;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.arkea.artimon.embed.jarjar.org.apache.commons.lang.StringUtils;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.TN00PR0DAOImpl;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAOResponseBean;
import com.arkea.com.arkea.commons.archetypes.server.generated.host.program.TN00PR0;

import net.federalservice.methode.cmpeci02.RequeteException;


public class BaseParametreDAO {

	/**
	 * Log
	 */
	private static final  Logger LOG = LoggerFactory.getLogger(BaseParametreDAO.class);

	/** 
	 * Programme cobol pour l'accès aux réservoirs
	 */
	private TN00PR0 tn00pr0;
	List<TN00PR0DAOResponseBean> sortieDAOBean;


	/**
	 * Permet de trouver les fichiers se trouvant actuellement dans un réservoir
	 * en fonction du nom du réservoir (et de son ETS pour le moment)
	 * 
	 * @param reservoirdynamique
	 *            : reservoirdynamique recherché
	 * @param ets
	 *            : ets du reservoirdynamique
	 * 
	 * @return une liste d'éléments recherchés
	 * @throws RequeteException
	 *             : exception
	 */
	public  List<TN00PR0DAOResponseBean> findFicherMR(String user, String CD_APLI, String CD_EFS, String NO_SEQ) throws Exception {

		boolean isOk = true;

		if (LOG.isTraceEnabled()) {
			(LOG).trace("Recherche des fichiers par la méthode findFicherMR " + ", CD_APLI " + CD_APLI
					+ ", EFS " + CD_EFS + ")");
		}

		/* Préparation appel à l'accesseur */
		tn00pr0 = new TN00PR0();

		tn00pr0 = (TN00PR0) CommunAccesseurDAO.setZoneTechniqueCommune(tn00pr0, "005", user);


		/* Zone Applicative Aller */
		if(CD_EFS != null){
			tn00pr0.getZoneApplicative().setY00pr0__Cd__Efs__Al(CD_EFS);
			isOk = isOk && true;
		}

		if(CD_APLI != null){
			tn00pr0.getZoneApplicative().setY00pr0__Cd__Apli__Al(CD_APLI);
			isOk = isOk && true;
		}

		if( !StringUtils.isEmpty(NO_SEQ)) {
			tn00pr0.getZoneApplicative().setY00pr0__No__Seq__Al(NO_SEQ);
			isOk = isOk && true;
		}


		if (!isOk){
			return preparerDonnees(user, "", "", "", "005");
		} else {
			return preparerDonnees(user, CD_APLI, CD_EFS, NO_SEQ, "001");
		}

	}


	private  List<TN00PR0DAOResponseBean> preparerDonnees(String user, String CD_APLI, String CD_EFS, String NO_SEQ, String numeroFonction) throws Exception {

		//avoir une request de la DAO
		TN00PR0DAOImpl entreeDAO = new TN00PR0DAOImpl();
		TN00PR0DAORequestBean entreeDAOBean = new TN00PR0DAORequestBean();

		// DONNES TECHNIQUES
		entreeDAOBean.setCodeSI("001");
		entreeDAOBean.setCodeEFS("01");
		entreeDAOBean.setNoFonction(numeroFonction);
		entreeDAOBean.setNoSal(user);


		// DONNES APPLICATIVES
		entreeDAOBean.setCodeAppliParametre(CD_APLI) ;
		entreeDAOBean.setCodeEFSParametre(CD_EFS);
		entreeDAOBean.setNumeroSequenceParametre(NO_SEQ);


		// utiliser la methode lecturebaseparametre pr avoir une request et une response
		sortieDAOBean = entreeDAO.lectureBaseParametre(entreeDAOBean);

		return sortieDAOBean ; 

	}
}
