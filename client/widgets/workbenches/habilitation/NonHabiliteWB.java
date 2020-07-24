package com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.habilitation;

import com.arkea.com.arkea.commons.archetypes.client.widgets.configurator.NavigationUtils;
import com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.WorkbenchCommon;
import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class NonHabiliteWB  extends WorkbenchCommon {

	  private FlowPanel panel;
	  
	  // Interface CSS
	  interface NonHabiliteWBCssResources extends CssResource {
		  String NonHabiliteWB();
		  String NonHabiliteWBTexte();
	  }

	  // Declaration des messages
	  @DefaultLocale("fr")
	  interface NonHabiliteWBMessages extends Messages {
		  @DefaultMessage("Vous n''êtes pas habilité à accéder à cette page")
		  String msgErreur();

		  @DefaultMessage("Problème d''habilitation")
		  String titrePage();
	  }

	  // Declaration des resources
	  interface Resources extends ClientBundle {
		    @Source("NonHabiliteWB.css")
		    NonHabiliteWBCssResources css();
	   }
	  
	  private Resources resources = GWT.create(Resources.class);
	  private NonHabiliteWBMessages messages = GWT.create(NonHabiliteWBMessages.class);
	  
	  /**
	   * Constructor for this widget
	   * @param eventBus the event bus on which events are fired/caught
	   */
	  @Inject
	  public NonHabiliteWB(EventBus eventBus) {
		  // cette page est accessible par tout le monde
		  // même pour une personne non habilite
		  super(eventBus, HabilitationUtils.PROFIL_NONHABILITE, NavigationUtils.URLNONHABILITEWB);

		panel = new FlowPanel();
	    panel.setStyleName(resources.css().NonHabiliteWB());
	    
	    Label labelText = new Label(messages.msgErreur());
	    labelText.setStyleName(resources.css().NonHabiliteWBTexte());
	    panel.add(labelText);
	    setTitle(messages.titrePage());
	    getPanel().add(panel);
	    
	    resources.css().ensureInjected();
	  }  
 
}
