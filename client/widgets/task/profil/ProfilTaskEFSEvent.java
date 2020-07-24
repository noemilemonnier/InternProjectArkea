package com.arkea.com.arkea.commons.archetypes.client.widgets.task.profil;


import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.arkea.commons.gwt.client.events.BaseEvent;
import com.arkea.commons.gwt.client.events.BaseHandler;

public class ProfilTaskEFSEvent extends BaseEvent<ProfilTaskEFSEvent.Handler> {

	public interface Handler extends BaseHandler {
		void onProfilTaskEFS(ProfilTaskEFSEvent event);
	}

	public static class Context extends BaseEvent.Context {
		public static enum Action {
			EFS,
			DUMMY,
		}


		/** 
		 * the action realized on the widget 
		 */
		private Action action = Action.EFS;
		private ProfilTask profiltask;
		private ContextClient contextclient;
		
		/**
		 * @return the action
		 */
		public final Action getAction() {
			return action;
		}
		/**
		 * @param action the action to set
		 */
		public final void setAction(Action action) {
			this.action = action;
		}
		/**
		 * @return the profiltask
		 */
		public final ProfilTask getProfiltask() {
			return profiltask;
		}
		/**
		 * @param profiltask the profiltask to set
		 */
		public final void setProfiltask(ProfilTask profiltask) {
			this.profiltask = profiltask;
		}
		/**
		 * @return the contextclient
		 */
		public final String getContextclient() {
			return contextclient.getMapFedeAuthorisee().get("01");
		}
		/**
		 * @param contextclient the contextclient to set
		 */
		public final void setContextclient(ContextClient contextclient) {
			this.contextclient = contextclient;
		}
		
		
		
	}
	/** TYPE of this event */
	public static final Type<ProfilTaskEFSEvent.Handler> TYPE = new Type<ProfilTaskEFSEvent.Handler>();

	/**
	 * Default constructor in which a defautl context is 
	 * already defined 
	 */
	public ProfilTaskEFSEvent() {
		super(new Context());
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProfilTaskEFSEvent.Handler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public Context getContext() {
		return (Context)super.getContext();
	}

	@Override
	protected void dispatch(ProfilTaskEFSEvent.Handler handler) {
		// TODO Auto-generated method stub
		handler.onProfilTaskEFS(this);
	}

}
