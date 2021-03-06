package com.arkea.com.arkea.commons.archetypes.client.widgets.commons.searchbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.WidgetCommon;
import com.arkea.com.arkea.commons.archetypes.client.widgets.task.profil.ProfilTask.ProfilTaskMessages;
import com.arkea.com.arkea.commons.archetypes.shared.service.BaseParametreService;
import com.arkea.com.arkea.commons.archetypes.shared.service.ProfilUserService;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreRequestBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreResponseBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ProfilUserResponseBean;
import com.arkea.commons.ihm.shared.model.ApplicationException;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;


/**
 * PLEASE PUT SOME COMMENTS ON WIDGET BEHAVIOUR HERE
 * 
 * @EventsCaught : 
 *  TODO : mentioned the events caught by the widget
 * @EventsFired :
 *  TODO : mentioned the events fired by the widget
 * 
 */

public class SearchBar extends WidgetCommon  {
	//public class SearchBar extends WidgetCommon {


	//Declare UIBinder for this widget

	@UiTemplate("SearchBar.ui.xml")
	interface SearchBarUiBinder extends UiBinder<Widget, SearchBar> {
	}
	//UIBinder for building interface 
	private SearchBarUiBinder uiBinder ;

	//UIBinder bindings 
	@UiField FlowPanel rootPanel;
	@UiField SearchBarMessages messages; 
	@UiField Label message;
	@UiField Button BtnSearch;
	@UiField TextBox textBoxAppli;
	@UiField TextBox textBoxSeq;
	@UiField ListBox listBoxEfs;

	@Inject
	private BaseParametreService.IfaceAsync listeDonnesBaseParametreService;	
	@Inject
	private ProfilUserService.IfaceAsync profilUserService;	
	@Inject
	private ProfilTaskMessages messagesP;	
	@Inject
	private ContextClient client;

	/*
	 * Constructor for this widget
	 * @param eventBus the event bus on which events are fired/caught
	 */

	@Inject
	private SearchBar(EventBus eventBus) {
		super(eventBus);
		// create UI
		uiBinder = GWT.create(SearchBarUiBinder.class);
		Widget myWidget = uiBinder.createAndBindUi(this);

		initWidget(myWidget);
	}  

	protected void onLoad() {
		try {
			profilUserService.getProfilUserService(null, new AsyncCallback<ProfilUserResponseBean>() {
				public void onSuccess(ProfilUserResponseBean sortie) {

					// enregistrement du contexte salarie
					contexteClient.setMapFedeAuthorisee(sortie.getMabFederationsAuthorisee());
					contexteClient.setUserConnecte(sortie.getSalarie());

					int i =0;
					// pouvoir afficher tous les codes EFS accessibles par l'utilisateur
					for(String key: contexteClient.getMapFedeAuthorisee().keySet()){
						listBoxEfs.insertItem(contexteClient.getMapFedeAuthorisee().get(key), i);
						listBoxEfs.setValue(i,key);
						i++;
					}
				}
				public void onFailure(Throwable caught) {
					GWT.log("ERREUR ProfilTask - profilUserService.getProfilUserService", caught);
					contexteClient.setApplicationException(new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,messagesP.networkError()+" "+ caught.getMessage()));
					Window.alert("KO") ;
				}
			});
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/* Quand on clique sur le bouton recherche
	 * 
	 * @param clickEvent
	 */
	@UiHandler("BtnSearch")
	protected void onBtnSearch(ClickEvent clickEvent) {
		if(textBoxAppli.getValue().isEmpty()){
			getDonnesBaseParametre(null, listBoxEfs.getSelectedValue(), textBoxSeq.getValue());
		}
		if(textBoxAppli.getValue().isEmpty() && textBoxSeq.getValue().isEmpty()){
			getDonnesBaseParametre(null, listBoxEfs.getSelectedValue(),null);
		}
		if(listBoxEfs.getSelectedValue().isEmpty() && textBoxSeq.getValue().isEmpty()){
			getDonnesBaseParametre(textBoxAppli.getValue(), null, null);
		}
		if(textBoxSeq.getValue().isEmpty()){
			getDonnesBaseParametre(textBoxAppli.getValue(), listBoxEfs.getSelectedValue(), null);
		}
		else{
			getDonnesBaseParametre(textBoxAppli.getValue(), listBoxEfs.getSelectedValue(), textBoxSeq.getValue());
		}
	}

	/* Pour lancer la recherche selon les données rentrées par l'utilisateur
	 * 
	 */
	private void getDonnesBaseParametre(String codeApli, String codeEfs, String numeroSeq) {
		BaseParametreRequestBean requestBase = new BaseParametreRequestBean();

		// DONNES TECHNIQUES ...
		//requestBase.setProfil(profil) ;

		// DONNES APPLICATIVES
		requestBase.setCodeEFSParametre(codeEfs) ;
		requestBase.setCodeAppliParametre(codeApli);
		requestBase.setNumeroSequenceParametre(numeroSeq);

		/* 
		 * pr avoir les criteres de recherche comme demandes
		if(!(codeApli.isEmpty()) && (codeEfs.isEmpty()) && (numeroSeq.isEmpty())){
			requestBase.setCodeEFSParametre(codeEfs) ;
			requestBase.setCodeAppliParametre(null);
			requestBase.setNumeroSequenceParametre(null);
		}
		if(!(codeApli.isEmpty()) && !(codeEfs.isEmpty()) && (numeroSeq.isEmpty())){
			requestBase.setCodeEFSParametre(codeEfs) ;
			requestBase.setCodeAppliParametre(codeApli);
			requestBase.setNumeroSequenceParametre(null);
		}
		if( (codeApli.isEmpty()) && !(codeEfs.isEmpty()) && !(numeroSeq.isEmpty())){
			requestBase.setCodeEFSParametre(null) ;
			requestBase.setCodeAppliParametre(codeApli);
			requestBase.setNumeroSequenceParametre(numeroSeq);
		}
		if((codeApli.isEmpty()) && !(codeEfs.isEmpty()) && (numeroSeq.isEmpty())){
			requestBase.setCodeEFSParametre(null) ;
			requestBase.setCodeAppliParametre(codeApli);
			requestBase.setNumeroSequenceParametre(null);
		}
		else{
			requestBase.setCodeEFSParametre(codeEfs) ;
			requestBase.setCodeAppliParametre(codeApli);
			requestBase.setNumeroSequenceParametre(numeroSeq);
		}

		 */

		try {
			listeDonnesBaseParametreService.searchReservoir(requestBase,  new AsyncCallback<BaseParametreResponseBean>() {
				public void onFailure(Throwable arg0) {
					Window.alert("FAIL");
				}
				public void onSuccess(BaseParametreResponseBean arg0) {
					SearchBarWidgetEvent event = new SearchBarWidgetEvent();
					event.getContext().setAction(SearchBarWidgetEvent.Context.Action.SEARCH) ;

					for(int i = 0; i < (arg0.getListeElementsConsommes().size()); i++){
						event.getContext().setCommentaireBP(arg0.getListeElementsConsommes().get(i).getElement().getCMT());
						event.getContext().setApli(arg0.getListeElementsConsommes().get(i).getElement().getCD_APLI());
						event.getContext().setEfs(arg0.getListeElementsConsommes().get(i).getElement().getCD_EFS());
						event.getContext().setSeq(arg0.getListeElementsConsommes().get(i).getElement().getNO_SEQ());
						event.getContext().setTmstp(arg0.getListeElementsConsommes().get(i).getElement().getTmStp());
						event.getContext().setVlrpar(arg0.getListeElementsConsommes().get(i).getElement().getVlrPar());
						eventBus.fireEvent(event);
					}
				}});

		}catch (Exception e) {
			e.printStackTrace();	
		}
	}






}
