package com.arkea.com.arkea.commons.archetypes.server.dao.webstore;

import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAORequestBean;
import com.arkea.com.arkea.commons.archetypes.server.dao.webstore.bean.WebstoreDAOResponseBean;

public interface WebstoreDAOIface {

	public abstract WebstoreDAOResponseBean createDirIfNotExists(WebstoreDAORequestBean resquest)throws Exception;
	public abstract WebstoreDAOResponseBean deleteFile(WebstoreDAORequestBean resquest)throws Exception;
	public abstract WebstoreDAOResponseBean exists(WebstoreDAORequestBean resquest)throws Exception;
	public abstract WebstoreDAOResponseBean getFile(WebstoreDAORequestBean resquest)throws Exception;
	public abstract WebstoreDAOResponseBean listFiles(WebstoreDAORequestBean resquest)throws Exception;
	public abstract WebstoreDAOResponseBean storeFile(WebstoreDAORequestBean resquest)throws Exception;
	
}
