package com.arkea.com.arkea.commons.archetypes.server.generated.host.program;


import com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR;

import net.federalservice.methode.cmpeci02.Tn00cia;

public class TN00PR0 extends Tn00cia {
	/**
	 * Zone applicative
	 */
	private Y00PR0IR zoneApplicative = new Y00PR0IR();
	/**
	 * Nom de programme
	 */
	private String programName = "TN00PR0";
	/**
	 * Constructeur
	 */
	public TN00PR0() {
		super.init(zoneApplicative, programName);
	}
	/**
	 * Renvoie la zone applicative
	 * @return Renvoie la zone applicative
	 */
	public final Y00PR0IR getZoneApplicative() {
		return zoneApplicative;
	}
	/**
	 * Affecte la zone applicative
	 * @param zoneApplicative2 La zone applicative
	 */
	public final void setZoneApplicative(final Y00PR0IR zoneApplicative2) {
		this.zoneApplicative = zoneApplicative2;
	}
	/**
	 * Renvoie le nom de programme
	 * @return Le nom de programme
	 */
	public final String getProgramName() {
		return programName;
	}
	/**
	 * Affecte le nom de programme
	 * @param programName2 Nom de programme
	 */
	public final void setProgramName(final String programName2) {
		this.programName = programName2;
	}
}