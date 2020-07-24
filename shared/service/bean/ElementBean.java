package com.arkea.com.arkea.commons.archetypes.shared.service.bean;



import java.io.Serializable;

import com.arkea.com.arkea.commons.archetypes.client.model.ElementModel;


@SuppressWarnings("serial")
public class ElementBean implements Serializable {

	private String CD_APLI;
	private String CD_EFS;
	private String NO_SEQ;
	private String CMT;
	private String vlrPar;
	private String TmStp;



	public ElementBean(){
	}

	public ElementBean(ElementModel model) {
		this();

		this.CD_APLI = model.getApli();
		this.CD_EFS = model.getEfs();
		this.NO_SEQ = model.getSeq();
		this.CMT =  model.getCmt() ;
		this.vlrPar = model.getVlrpar() ;
		this.TmStp = model.getTmStp() ;


	}

	public ElementBean(String cD_APLI, String cD_EFS, String nO_SEQ,
			String cMT, String vlrPar, String tmStp) {
		super();
		this.CD_APLI = cD_APLI;
		this.CD_EFS = cD_EFS;
		this.NO_SEQ = nO_SEQ;
		this.CMT = cMT;
		this.vlrPar = vlrPar;
		this.TmStp = tmStp;

	}


	/**
	 * @return the cMT
	 */
	public final String getCMT() {
		return CMT;
	}

	/**
	 * @param cMT the cMT to set
	 */
	public final void setCMT(String cMT) {
		CMT = cMT;
	}

	/**
	 * @return the tmStp
	 */
	public final String getTmStp() {
		return TmStp;
	}

	/**
	 * @param tmStp the tmStp to set
	 */
	public final void setTmStp(String tmStp) {
		TmStp = tmStp;
	}

	/**
	 * @return the daCre
	 */
	public final String getVlrPar() {
		return vlrPar;
	}

	/**
	 * @param daCre the daCre to set
	 */
	public final void setVlrPar(String vlrPar) {
		this.vlrPar = vlrPar;
	}

	/**
	 * @return the cD_APLI
	 */
	public final String getCD_APLI() {
		return CD_APLI;
	}

	/**
	 * @param cD_APLI the cD_APLI to set
	 */
	public final void setCD_APLI(String cD_APLI) {
		CD_APLI = cD_APLI;
	}

	/**
	 * @return the cD_EFS
	 */
	public final String getCD_EFS() {
		return CD_EFS;
	}

	/**
	 * @param cD_EFS the cD_EFS to set
	 */
	public final void setCD_EFS(String cD_EFS) {
		CD_EFS = cD_EFS;
	}

	/**
	 * @return the nO_SEQ
	 */
	public final String getNO_SEQ() {
		return NO_SEQ;
	}

	/**
	 * @param nO_SEQ the nO_SEQ to set
	 */
	public final void setNO_SEQ(String nO_SEQ) {
		NO_SEQ = nO_SEQ;
	}

	public String getInfo(){
		return   getCD_EFS() + "/" +
				getNO_SEQ() + "/" +
				getCD_APLI() + "/" +
				getCMT() + "/" +
				getVlrPar() + "/" +
				getTmStp() ;

	}
}

