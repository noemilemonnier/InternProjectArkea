package com.arkea.com.arkea.commons.archetypes.client.widgets.commons.searchbar;

import java.util.ArrayList;
import java.util.List;

import com.arkea.com.arkea.commons.archetypes.client.model.ElementModel;
import com.arkea.commons.gwt.client.events.BaseEvent;
import com.arkea.commons.gwt.client.events.BaseHandler;

public class SearchBarWidgetEvent extends BaseEvent<SearchBarWidgetEvent.Handler> {

	public interface Handler extends BaseHandler {
		void onRechercheBaseParametre(SearchBarWidgetEvent event);
	}

	/**
	 * Context associated to this event
	 * Put all needed informations into this object 
	 */
	public static class Context extends BaseEvent.Context {
		/*Données nécessaires dans SearchBar a déclarer pr etre dans le response bean
		 * 
		 */
		String commentaireBP; 
		String apli;
		String efs;
		String seq;
		String vlrpar;
		String tmstp;

		List<ElementModel> listeElements = new ArrayList<ElementModel>();


		/**
		 * Action that can be done on the RechercheBaseParametreWB
		 */
		public static enum Action {
			SEARCH,
			DUMMY, 
			//TODO : to be completed with further actions
		}

		/** 
		 * the action realized on the widget 
		 */
		private Action action = Action.SEARCH;


		public void setAction(Action action) {
			this.action = action;
		}

		public Action getAction() {
			return action;
		}


		/**
		 * @return the listeElements
		 */
		public final List<ElementModel> getListeElements() {
			return listeElements;
		}

		/**
		 * @param listeElements the listeElements to set
		 */
		public final void setListeElements(List<ElementModel> listeElements) {
			this.listeElements = listeElements;
		}

		/**
		 * @return the commentaireBP
		 */
		public final String getCommentaireBP() {
			return commentaireBP;
		}

		/**
		 * @param commentaireBP the commentaireBP to set
		 */
		public final void setCommentaireBP(String commentaireBP) {
			this.commentaireBP = commentaireBP;
		}

		/**
		 * @return the apli
		 */
		public final String getApli() {
			return apli;
		}

		/**
		 * @param apli the apli to set
		 */
		public final void setApli(String apli) {
			this.apli = apli;
		}

		/**
		 * @return the efs
		 */
		public final String getEfs() {
			return efs;
		}

		/**
		 * @param efs the efs to set
		 */
		public final void setEfs(String efs) {
			this.efs = efs;
		}

		/**
		 * @return the seq
		 */
		public final String getSeq() {
			return seq;
		}

		/**
		 * @param seq the seq to set
		 */
		public final void setSeq(String seq) {
			this.seq = seq;
		}

		/**
		 * @return the tmstp
		 */
		public final String getTmstp() {
			return tmstp;
		}

		/**
		 * @param tmstp the tmstp to set
		 */
		public final void setTmstp(String tmstp) {
			this.tmstp = tmstp;
		}

		/**
		 * @return the vlrpar
		 */
		public final String getVlrpar() {
			return vlrpar;
		}

		/**
		 * @param vlrpar the vlrpar to set
		 */
		public final void setVlrpar(String vlrpar) {
			this.vlrpar = vlrpar;
		}



		//TODO : add objects into this event if you need to transport more information.
	}


	/** TYPE of this event */
	public static final Type<SearchBarWidgetEvent.Handler> TYPE = new Type<SearchBarWidgetEvent.Handler>();

	/**
	 * Default constructor in which a defautl context is 
	 * already defined 
	 */
	public SearchBarWidgetEvent() {
		super(new Context());
	}

	/**
	 * Obtain the GwtEvent.Type of this event
	 * @return the type of this event
	 */
	public com.google.gwt.event.shared.GwtEvent.Type<SearchBarWidgetEvent.Handler> getAssociatedType() {
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
	protected void dispatch(SearchBarWidgetEvent.Handler handler) {
		handler.onRechercheBaseParametre(this);
	}


}
