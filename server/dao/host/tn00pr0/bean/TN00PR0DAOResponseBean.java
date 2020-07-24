package com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.bean;

@SuppressWarnings("serial")
public class TN00PR0DAOResponseBean {

	//donnees pr la response
	private String codeEFSParametre;
	private String codeAppliParametre;
	private String numeroSequenceParametre;
	private String commentaire;
	private String valeurParametre;
	private String timeStamp;


	/**
	 *  Constructeur vide
	 */
	public TN00PR0DAOResponseBean() {
		codeEFSParametre = null;
		codeAppliParametre = null;
		numeroSequenceParametre = null;
		commentaire = null;
		valeurParametre = null;
		timeStamp = null;
		
	}

	/** Constructeur parametrisé
	 * 
	 * @param CDEFS
	 * @param CDAPPL
	 * @param NOSEQ
	 * @param COMM
	 * @param timeStp
	 */
	public TN00PR0DAOResponseBean(String CDAPPL, String CDEFS, String NOSEQ, String COMM, String valeurPrm, String timeStp) {
		this.codeAppliParametre = CDAPPL ;
		this.codeEFSParametre = CDEFS;
		this.numeroSequenceParametre = NOSEQ;
		this.commentaire = COMM ;
		this.valeurParametre = valeurPrm;
		this.timeStamp = timeStp;

	}
	/**
	 * @return the codeEFSParametre
	 */
	public final String getCodeEFSParametre() {
		return codeEFSParametre;
	}

	/**
	 * @param codeEFSParametre the codeEFSParametre to set
	 */
	public final void setCodeEFSParametre(String codeEFSParametre) {
		this.codeEFSParametre = codeEFSParametre;
	}

	/**
	 * @return the codeAppliParametre
	 */
	public final String getCodeAppliParametre() {
		return codeAppliParametre;
	}

	/**
	 * @param codeAppliParametre the codeAppliParametre to set
	 */
	public final void setCodeAppliParametre(String codeAppliParametre) {
		this.codeAppliParametre = codeAppliParametre;
	}

	/**
	 * @return the numeroSequenceParametre
	 */
	public final String getNumeroSequenceParametre() {
		return numeroSequenceParametre;
	}

	/**
	 * @param numeroSequenceParametre the numeroSequenceParametre to set
	 */
	public final void setNumeroSequenceParametre(String numeroSequenceParametre) {
		this.numeroSequenceParametre = numeroSequenceParametre;
	}

	/**
	 * @return the commentaire
	 */
	public final String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public final void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * @return the timeStamp
	 */
	public final String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public final void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the valeurParametre
	 */
	public final String getValeurParametre() {
		return valeurParametre;
	}

	/**
	 * @param valeurParametre the valeurParametre to set
	 */
	public final void setValeurParametre(String valeurParametre) {
		this.valeurParametre = valeurParametre;
	}




}
