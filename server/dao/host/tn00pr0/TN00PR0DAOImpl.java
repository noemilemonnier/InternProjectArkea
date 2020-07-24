package com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0;

import java.util.ArrayList;
import java.util.List;

import com.arkea.artimon.embed.jarjar.org.apache.commons.lang.StringUtils;
//import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.dao.TN00PR0DAO;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean.TN00PR0DAOResponseBean;

import net.federalservice.methode.cmpeci02.RequeteAccesseurTypeCIAException;
import net.gicm.methode.qos.traceid.TraceId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkea.com.arkea.commons.archetypes.server.commons.memcached.CacheInterface;
import com.arkea.com.arkea.commons.archetypes.server.commons.memcached.CacheUtils;



import com.google.inject.Inject;
import com.google.inject.name.Named;

public class TN00PR0DAOImpl implements TN00PR0DAOIface {
	private static final Logger LOG = LoggerFactory.getLogger(TN00PR0DAOImpl.class);

	/**
	 * Injection du memcached pour l'appel host
	 * NB: Verifier son activation dans memcached.properties
	 */
	@Inject
	protected @Named("cache.daohost") CacheInterface<byte[]> service;

	/**
	 * Ce service est fait pour être injecté, pas de "NEW" autorisé
	 */
	//TODO CHANGER pour TEST JUNIT
	@Inject
	public TN00PR0DAOImpl() {}

	/**
	 * @param entreeDAO bean d'entree
	 * @return bean de sortie
	 * @throws Exception exception
	 */
	public List<TN00PR0DAOResponseBean> lectureBaseParametre(TN00PR0DAORequestBean entreeDAO) throws Exception {

		TN00PR0DAO tnXX = new TN00PR0DAO();

		// Zone technique
		tnXX.m_zoneTechnique.setY00cia__Cd__Si(entreeDAO.getCodeSI());
		tnXX.m_zoneTechnique.setY00cia__Cd__Efs(entreeDAO.getCodeEFS());
		tnXX.m_zoneTechnique.setY00cia__No__Sal(entreeDAO.getNoSal());
		tnXX.m_zoneTechnique.setY00cia__Cd__Ret__Pgm((short) 0);
		tnXX.m_zoneTechnique.setY00cia__No__Pgm__Cics__App("TN00PR0");
		tnXX.m_zoneTechnique.setY00cia__No__Pgm__Cics__At("TN00PR0");
		tnXX.m_zoneTechnique.setY00cia__Cd__Mes__Err("");
		tnXX.m_zoneTechnique.setY00cia__Fct__Dem(entreeDAO.getNoFonction());

		String msgErreur = "";
		short cdRetourProgramme;
		short cdRetourAppli;

		// Trace QOS
		TraceId.setId(entreeDAO.getNoSal());

		/**
		 *  TODO implementer les parametres d'appel
		 */
		// == Autogenerate _AL values ==
		//	tnXX.getZoneApplicative().setY00pr0__Cd__Efs__Al(java.lang.String aY00pr0__Cd__Efs__Al);
		//	tnXX.getZoneApplicative().setY00pr0__Cd__Apli__Al(java.lang.String aY00pr0__Cd__Apli__Al);
		//	tnXX.getZoneApplicative().setY00pr0__No__Seq__Al(java.lang.String aY00pr0__No__Seq__Al);
		//	tnXX.getZoneApplicative().setY00pr0__Idt__Uti__Al(java.lang.String aY00pr0__Idt__Uti__Al);
		//	tnXX.getZoneApplicative().setY00pr0__Idc__Repr__Al(java.lang.String aY00pr0__Idc__Repr__Al);

		// Appel host avec verification si une entree identique est présente dans le memcached
		//   * le memcached doit être activé dans memcached.properties
		//   * les clés TTL sont dans memcached.properties et les 3 clées défaut (TTL_COURT, TTL_LONG, TTL_TRESLONG)
		// Pour ne pas faire de cache, on utilise CacheUtils.executeHostWithoutCached

		if (!StringUtils.isEmpty(entreeDAO.getCodeEFSParametre())) {
			tnXX.getZoneApplicative().setY00pr0__Cd__Efs__Al(entreeDAO.getCodeEFSParametre());
		}
		if (!StringUtils.isEmpty(entreeDAO.getCodeAppliParametre())) {
			tnXX.getZoneApplicative().setY00pr0__Cd__Apli__Al(entreeDAO.getCodeAppliParametre());
		}

		if (!StringUtils.isEmpty(entreeDAO.getNumeroSequenceParametre())) {				
			tnXX.getZoneApplicative().setY00pr0__No__Seq__Al(entreeDAO.getNumeroSequenceParametre());			
		}
		try {

			CacheUtils.executeHostWithoutCached(tnXX, "Test", entreeDAO.getCodeEFS());

		} catch (RequeteAccesseurTypeCIAException e) {

			LOG.error(tnXX.m_zoneTechnique.getY00cia__Cd__Mes__Err()) ;
			LOG.error(tnXX.m_zoneTechnique.getY00cia__Lib__Cpl__Mes__Err()) ;

		}




		// Gestion des codes retour
		cdRetourProgramme = tnXX.m_zoneTechnique.getY00cia__Cd__Ret__Pgm();
		cdRetourAppli = tnXX.m_zoneTechnique.getY00cia__Cd__Ret__Apli();
		msgErreur = tnXX.m_zoneTechnique.getY00cia__Cd__Mes__Err();
		tnXX.m_zoneTechnique.getY00cia__Lib__Cpl__Mes__Err();
		if (LOG.isDebugEnabled()) {
			LOG.debug("cdRetourProgramme : " + cdRetourProgramme);
			LOG.debug("cdRetourAppli : " + cdRetourAppli);
			LOG.debug("msgErreur : " + msgErreur);
		}

		if (cdRetourProgramme <= 4) {
			/** 
			 * TODO exploiter les paramètres de retour
			 */
			// ex: retour.setOut_...(tnXX.getZoneApplicative().get...();

			List<TN00PR0DAOResponseBean> listeSortie = new ArrayList<TN00PR0DAOResponseBean>();

			//Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG[]  retour = 
			tnXX.getZoneApplicative().getY00pr0__Lig() ;

			TN00PR0DAOResponseBean sortieDAO = new TN00PR0DAOResponseBean();	

			sortieDAO.setCodeAppliParametre(tnXX.getZoneApplicative().getY00pr0__Cd__Apli__Al());
			sortieDAO.setCodeEFSParametre(tnXX.getZoneApplicative().getY00pr0__Cd__Efs__Al());
			sortieDAO.setNumeroSequenceParametre(tnXX.getZoneApplicative().getY00pr0__No__Seq__Al());
			sortieDAO.setCommentaire(tnXX.getZoneApplicative().getY00pr0__Wk__Zon__Par__1());
			sortieDAO.setTimeStamp(tnXX.getZoneApplicative().getY00pr0__Tm__Stp());	
			sortieDAO.setValeurParametre(tnXX.getZoneApplicative().getY00pr0__Wk__Zon__Par());

			listeSortie.add(sortieDAO) ;


			return listeSortie;
		} else {
			LOG.error("Abend : "
					+ tnXX.m_zoneTechnique.getY00cia__Cd__Abend());
			throw new Exception("Erreur d'execution du TN00PR0");
		}
	}
}