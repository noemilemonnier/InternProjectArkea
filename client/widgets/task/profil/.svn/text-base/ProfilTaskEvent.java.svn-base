package com.arkea.com.arkea.commons.archetypes.client.widgets.task.profil;

import com.arkea.commons.gwt.client.events.BaseEvent;
import com.arkea.commons.gwt.client.events.BaseHandler;
import com.arkea.commons.ihm.client.ihmevent.model.ProfilSalarieBean;

public class ProfilTaskEvent extends BaseEvent<ProfilTaskEvent.Handler> {

	public static interface Handler extends BaseHandler {
		void onProfilTask(ProfilTaskEvent event);
	}
	
  /**
   * Context associated to this event
   * Put all needed informations into this object 
   */
  public static class Context extends BaseEvent.Context {

    /**
     * Action that can be done on the Profilwidget
     */
    public static enum Action {
      NONE,
      DUMMY,
      CONNECT,
      FORBIDDEN,
      NETWORK_ERROR
    }
    
    /** 
     * the action realized on the widget 
     */
    private Action action = Action.NONE;
    
    private ProfilSalarieBean profil = null;
    
    public void setAction(Action action) {
      this.action = action;
    }
    
    public Action getAction() {
      return action;
    }

	public ProfilSalarieBean getProfilSalarieBean() {
		return profil;
	}

	public void setProfilSalarieBean(ProfilSalarieBean profil) {
		this.profil = profil;
	}
  }
  
  /** TYPE of this event */
  public static final Type<ProfilTaskEvent.Handler > TYPE = new Type<ProfilTaskEvent.Handler >();

  /**
   * Default constructor in which a defautl context is 
   * already defined 
   */
  public ProfilTaskEvent() {
    super(new Context());
  }
  
  /**
   * Obtain the GwtEvent.Type of this event
   * @return the type of this event
   */
  public com.google.gwt.event.shared.GwtEvent.Type<ProfilTaskEvent.Handler > getAssociatedType() {
      return TYPE;
  }
  
  /**
   * Obtain the context associated to this event.
   * First Call to this method return a non null Context
   * that can be used. 
   * @return the Context of this event
   */
  public Context getContext() {
    return (Context)super.getContext();
  }
  
  /**
   * Dispatch event to handler
   */
  protected void dispatch(ProfilTaskEvent.Handler handler) {
      handler.onProfilTask(this);
  }
  
}
