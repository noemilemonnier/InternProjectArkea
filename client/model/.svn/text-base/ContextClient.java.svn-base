package com.arkea.com.arkea.commons.archetypes.client.model;

import java.util.Map;

import com.arkea.commons.ihm.client.ihmevent.model.IHMContext;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;


/**
 * Dans cette classe on peut ajouter toutes les variables que l'ont veut partager dans le contexte Client.
 *  
 * Elle étend IHMContext donc elle contient déjà des objets utilisés par les ressources IHM
 * (Bandeau, Menu, Error, ...) : ProfilSalarieBean, ApplicationException, ...
 */
@SuppressWarnings("serial")
public class ContextClient extends IHMContext {

	private Map<String,String> mapFedeAuthorisee = null;

	@Inject
	public ContextClient(EventBus bus_) {
		super(bus_);
	}

	public Map<String,String> getMapFedeAuthorisee() {
		return mapFedeAuthorisee;

	}

	public void setMapFedeAuthorisee(Map<String,String> mapFedeAuthorisee) {
		this.mapFedeAuthorisee = mapFedeAuthorisee;
	}


}
