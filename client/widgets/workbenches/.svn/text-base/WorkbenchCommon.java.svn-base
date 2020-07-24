package com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches;

import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.arkea.commons.ihm.client.ihmevent.events.IHMContextEvent;
import com.arkea.commons.scaffolding.client.widgets.workbench.WorkbenchWidget;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;


/**
 * Ce workbench permet de mutualiser une partie du code de tous les WorkBenches
 *  
 */
public class WorkbenchCommon extends WorkbenchWidget implements IHMContextEvent.Handler {
	
  /**
   * Contexte partagé par les clients
   */
  @Inject
  protected ContextClient contexteClient;
  
  /** event bus on which to commit */
  protected EventBus eventBus;
  
  /**
   * Constructor for this widget
   * @param eventBus the event bus on which events are fired/caught
   */
  @Inject
  protected WorkbenchCommon(EventBus eventBus, int profil, String idWB) {
		// L'habilitation correspond à l'habilitation minimum pour afficher la page
	    super(eventBus, profil, idWB);
	    this.eventBus = eventBus;
  }  
  
  public void onIhmEvent(IHMContextEvent event) {
	  switch (event.getContext().getAction()) {
		case CONTEXT_RELOAD_MODEL:
			contexteClientReloaded();
			break;
		case APPLICATION_LOADED:
			contexteClientReloaded();
			break;
		case DISPLAY_WIDGET :
			 if (this.isShow(event)) {
				  refreshWB();
			  }
			 break;
		default:
			break;
	  }
  }
  
  protected void onLoad() {
	super.onLoad();
    // connect handler
    handlersRegistration.add(eventBus.addHandler(IHMContextEvent.TYPE, this));
    
    refreshWB();
  }
  
  public void contexteClientReloaded() {
	  // overrider cette methode pour prise en charge
  }
  
  public void refreshWB() {
	  // overrider cette methode pour prise en charge
  }

}
