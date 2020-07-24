package com.arkea.com.arkea.commons.archetypes.client.widgets.commons;

import java.util.ArrayList;

import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.arkea.commons.ihm.client.ihmevent.events.IHMContextEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.HandlerRegistration;


/**
 * Ce workbench permet de mutualiser une partie du code de tous les Widgets communs
 * 
 */
public abstract class WidgetCommon extends Composite implements IHMContextEvent.Handler {
	
  @Inject
  protected ContextClient contexteClient;
  
  /** event bus on which to commit */
  protected EventBus eventBus;
  
  /**
   * Handlers the widget registers
   */
  protected ArrayList<HandlerRegistration> handlersRegistration ;

  /**
   * Constructor for this widget
   * @param eventBus the event bus on which events are fired/caught
   */
  @Inject
  protected WidgetCommon(EventBus eventBus) {
	    this.eventBus = eventBus;
		this.handlersRegistration = new ArrayList<HandlerRegistration>();
  }  
  
    
  protected void onLoad() {
	super.onLoad();
    // connect handler
    handlersRegistration.add(eventBus.addHandler(IHMContextEvent.TYPE, this));
  }
  
  protected void onUnload() {
    super.onUnload();
    // remove handlers registration
    for(HandlerRegistration hr : handlersRegistration) {
      hr.removeHandler();
    }
    handlersRegistration.clear();
  }
  
  /**
   * Deplace le Widget dans l'arbre DOM d'une page (pour les widget partagés)
   * @param newPanel le nouvel Element dans lequel on veu s'ajouter
   */
  public void ajouteWidgetPanel(final Panel newPanel) {
	  this.removeFromParent();
	  newPanel.add(this);
  }
  
  public void onIhmEvent(IHMContextEvent event) {
	
  }
  
}
