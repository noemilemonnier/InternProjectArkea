package com.arkea.com.arkea.commons.archetypes.client.injection;



import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.researchresult.ResearchResult;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.searchbar.SearchBar;
import com.arkea.com.arkea.commons.archetypes.client.widgets.mainwidget.MainWidget;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Gin Injector for getting instance of what we want
 */
@GinModules({GinModule.class})
public interface GInjector extends Ginjector {

	/**
	 * The Main Widget
	 */
	MainWidget getMainWidget();

	/*
	 * The Search Widget Provider.
	 */

	SearchBar  getSearchBarWidget();

	/*
	 * The ResearchResult Widget Provider.
	 */
	ResearchResult getResearchResult();

}
