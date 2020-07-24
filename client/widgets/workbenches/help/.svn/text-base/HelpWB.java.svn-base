package com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.help;

import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;
import com.arkea.com.arkea.commons.archetypes.client.widgets.configurator.NavigationUtils;
import com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.WorkbenchCommon;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class HelpWB  extends WorkbenchCommon {

	  private FlowPanel panel;
	  
	  // Interface CSS
	  interface HelpWBCssResources extends CssResource {
		  String HelpWB();
		  String HelpWBTexte();
	  }

	  // Declaration des messages
	  @DefaultLocale("fr")
	  interface HelpWBMessages extends Messages {
		  @DefaultMessage("Vous pouvez implémenter l''aide de votre application sur cette page.")
		  String msgInfo();

		  @DefaultMessage("Aide")
		  String titrePage();
	  }

	  // Declaration des resources
	  interface Resources extends ClientBundle {
		    @Source("HelpWB.css")
		    HelpWBCssResources css();
	   }
	  
	  private Resources resources = GWT.create(Resources.class);
	  private HelpWBMessages messages = GWT.create(HelpWBMessages.class);
	  
	  /**
	   * Constructor for this widget
	   * @param eventBus the event bus on which events are fired/caught
	   */
	  @Inject
	  public HelpWB(EventBus eventBus) {
		  //cette page n'est accessible qu'aux utilisateurs connectés
		  super(eventBus, HabilitationUtils.PROFIL_CONNECTE, NavigationUtils.URLAIDEWB);
	    
	    panel = new FlowPanel();
	    panel.setStyleName(resources.css().HelpWB());
	    
	    Label labelText = new Label(messages.msgInfo());
	    labelText.setStyleName(resources.css().HelpWBTexte());
	    panel.add(labelText);
	    setTitle(messages.titrePage());
	    getPanel().add(panel);
	    
	    resources.css().ensureInjected();
	  }  
 
}
