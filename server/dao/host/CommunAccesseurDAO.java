package com.arkea.com.arkea.commons.archetypes.server.dao.host;


import net.federalservice.methode.cmpeci02.Tn00cia;


public class CommunAccesseurDAO {
	/**
	 * Constructeur privé pour classe utilitaire
	 */
	private CommunAccesseurDAO() {

	}

	/**
	 * Alimente la zone technique commune
	 * 
	 * @param accesseurApp
	 *            accesseur
	 * @param fonction
	 *            code de la fonction à appeler
	 * @param profil
	 *            profil du user
	 * @return l'accesseur avec la la zone technique commune alimentée
	 */
	public static Tn00cia setZoneTechniqueCommune(Tn00cia accesseurApp, String fonction, String user) {

		Tn00cia accesseur = accesseurApp;

		// Zone technique
		accesseur.m_zoneTechnique.setY00cia__Cd__Si("001");
		accesseur.m_zoneTechnique.setY00cia__Cd__Efs("01");
		accesseur.m_zoneTechnique.setY00cia__No__Sal(user);
		accesseur.m_zoneTechnique.setY00cia__Cd__Ret__Pgm((short) 0);
		accesseur.m_zoneTechnique.setY00cia__No__Pgm__Cics__App(accesseurApp.m_programName);
		accesseur.m_zoneTechnique.setY00cia__No__Pgm__Cics__At("BASEPARM");
		accesseur.m_zoneTechnique.setY00cia__Cd__Mes__Err("");
		accesseur.m_zoneTechnique.setY00cia__Fct__Dem(fonction);

		return accesseur;
	}
}



