package com.arkea.com.arkea.commons.archetypes.client;



import com.arkea.com.arkea.commons.archetypes.client.injection.GInjector;
import com.arkea.com.arkea.commons.archetypes.client.widgets.mainwidget.MainWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.arkea.commons.scaffolding.client.Scaffolding;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Test extends Scaffolding implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		GInjector ginjector = GWT.create(GInjector.class);
		
		//
		// Create a widget
		//
		MainWidget myMainWidget = ginjector.getMainWidget();
		RootPanel.get().add(myMainWidget);
	}
	  
}
