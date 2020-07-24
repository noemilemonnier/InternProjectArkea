package com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean;



@SuppressWarnings("serial")
public class WebstoreDAORequestBean {

	private String path;
	private byte[] data;
	
	
	// Constructeur vide
	public WebstoreDAORequestBean() {
	}


	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}


}
