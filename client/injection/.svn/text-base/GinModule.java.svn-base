package com.arkea.com.arkea.commons.archetypes.client.injection;


import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;


/**
 * Ginjection module bindings for display
 */
public class GinModule extends AbstractGinModule {

  @Override
  protected void configure() {
    
	  bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();
	  bind(ContextClient.class).asEagerSingleton();
	  
  }
  
}