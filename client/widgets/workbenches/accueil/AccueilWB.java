package com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.accueil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

import com.arkea.com.arkea.commons.archetypes.client.injection.GInjector;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.researchresult.ResearchResult;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.searchbar.SearchBar;
import com.arkea.com.arkea.commons.archetypes.client.widgets.configurator.NavigationUtils;
import com.arkea.com.arkea.commons.archetypes.client.widgets.workbenches.WorkbenchCommon;
import com.arkea.com.arkea.commons.archetypes.shared.commons.HabilitationUtils;

/**
 * Workbench d'accueil de l'application
 * 
 */
public class AccueilWB extends WorkbenchCommon {

	// Interface CSS
	interface AccueilWBCssResources extends CssResource {
		String AccueilWB();
		String AccueilWBTexte();
	}
	// Declaration des resources
	interface Resources extends ClientBundle {
		@Source("AccueilWB.css")
		AccueilWBCssResources css();
	}
	private Resources resources = GWT.create(Resources.class);
	private AccueilWBMessages messages = GWT.create(AccueilWBMessages.class);
	private FlowPanel myWidget = null;
	@Inject
	private SearchBar mySearchBar;
	@Inject
	private ResearchResult myResearchResult;

	/**
	 * Constructor for this widget
	 * @param eventBus the event bus on which events are fired/caught
	 */
	@Inject
	private AccueilWB(EventBus eventBus) {
		// L'habilitation correspond à l'habilitation minimum pour afficher la page
		super(eventBus, HabilitationUtils.PROFIL_CONNECTE,NavigationUtils.URLACCUEILWB);

		GInjector ginjector = GWT.create(GInjector.class);

		myWidget = new FlowPanel();
		myWidget.setStyleName(resources.css().AccueilWB());



		Label labelText = new Label(messages.texteBienvenue());
		labelText.setStyleName(resources.css().AccueilWBTexte());
		myWidget.add(labelText);
		mySearchBar = ginjector.getSearchBarWidget() ;
		myWidget.add(mySearchBar);
		
		myResearchResult = ginjector.getResearchResult();
		myWidget.add(myResearchResult);

		resources.css().ensureInjected();

		setTitle(messages.titrePage());
		// implantation de mon Widget dans le WorkbenchWidget
		getPanel().add(myWidget);
	}  

}
