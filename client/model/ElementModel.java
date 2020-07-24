package com.arkea.com.arkea.commons.archetypes.client.model;

import java.io.Serializable;

import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBean;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

/* ElementModel definit ce que chaque element doit avoir
 * 
 */
@SuppressWarnings("serial")
public class ElementModel implements Serializable {

	public interface ElementModelProps extends PropertyAccess<ElementModel> {
		@Path("id")
		public ModelKeyProvider<ElementModel> key();
		public ValueProvider<ElementModel, String> apli();
		public ValueProvider<ElementModel, String> efs();
		public ValueProvider<ElementModel, String> seq();
		public ValueProvider<ElementModel, String> cmt();
		public ValueProvider<ElementModel, String> vlrpar();
		public ValueProvider<ElementModel, String> tmStp();

	}

	public static final String ID_COL_EFS = "efs";
	public static final String ID_COL_APLI = "apli";
	public static final String ID_COL_SEQ = "seq";
	public static final String ID_COL_COMM = "cmt";
	public static final String ID_COL_TMSTP = "tmStp";
	public static final String ID_COL_PAR = "vlrpar";

	private static int IDREF = 0;
	private int id;

	private String efs;
	private String apli;
	private String seq;
	private String cmt;
	private String tmStp;
	private String vlrpar;

	public ElementModel(){
		setId(IDREF++);
	}

	public ElementModel(String aPLI, String eFS, String sEQ,
			String cMT, String vlrPar, String tmStp) {
		this();

		this.apli = aPLI;
		this.efs = eFS;
		this.seq = sEQ;
		this.cmt = cMT;
		this.vlrpar = vlrPar;
		this.tmStp = tmStp;

	}


	public ElementModel(ElementModel model){
		this(model.getApli(), model.getEfs(), model.getSeq(), model.getCmt(), model.getVlrpar(), model.getTmStp());
	}

	public ElementModel(ElementBean bean){
		this(bean.getCD_APLI(), bean.getCD_EFS(), bean.getNO_SEQ(), bean.getCMT(), bean.getVlrPar(), bean.getTmStp());
	}

	/**
	 * @return the iDREF
	 */
	public static final int getIDREF() {
		return IDREF;
	}

	/**
	 * @param iDREF the iDREF to set
	 */
	public static final void setIDREF(int iDREF) {
		IDREF = iDREF;
	}

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the eFS
	 */
	public final String getEfs() {
		return this.efs;
	}

	/**
	 * @param eFS the eFS to set
	 */
	public final void setEfs(String eFS) {
		this.efs = eFS;
	}

	/**
	 * @return the aPLI
	 */
	public final String getApli() {
		return apli;
	}

	/**
	 * @param aPLI the aPLI to set
	 */
	public final void setApli(String aPLI) {
		apli = aPLI;
	}

	/**
	 * @return the sEQ
	 */
	public final String getSeq() {
		return this.seq;
	}

	/**
	 * @param sEQ the sEQ to set
	 */
	public final void setSeq(String sEQ) {
		this.seq = sEQ;
	}

	/**
	 * @return the cMT
	 */
	public final String getCmt() {
		return this.cmt;
	}

	/**
	 * @param cMT the cMT to set
	 */
	public final void setCmt(String cMT) {
		this.cmt = cMT;
	}

	/**
	 * @return the tmStp
	 */
	public final String getTmStp() {
		return tmStp;
	}

	/**
	 * @param tmStp the tmStp to set
	 */
	public final void setTmStp(String tmStp) {
		this.tmStp = tmStp;
	}

	/**
	 * @return the vlrPar
	 */
	public final String getVlrpar() {
		return this.vlrpar;
	}

	/**
	 * @param vlrPar the vlrPar to set
	 */
	public final void setVlrpar(String vlrPar) {
		this.vlrpar = vlrPar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apli == null) ? 0 : apli.hashCode());
		result = prime * result + ((cmt == null) ? 0 : cmt.hashCode());
		result = prime * result + ((efs == null) ? 0 : efs.hashCode());
		result = prime * result + id;
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		result = prime * result + ((tmStp == null) ? 0 : tmStp.hashCode());
		result = prime * result + ((vlrpar == null) ? 0 : vlrpar.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(ElementModel obj) {
		boolean same = false;
		if ((this.apli.equalsIgnoreCase(obj.getApli())) && (this.cmt.equalsIgnoreCase(obj.getCmt())) && (this.efs.equalsIgnoreCase(obj.getEfs())) && (this.seq.equalsIgnoreCase(obj.getSeq())) && (this.vlrpar.equalsIgnoreCase(obj.getVlrpar()))){
			same = true;
		}
		return same;

	}



}
