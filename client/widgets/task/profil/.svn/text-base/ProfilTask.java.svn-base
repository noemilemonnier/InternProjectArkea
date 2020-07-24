package com.arkea.com.arkea.commons.archetypes.client.widgets.task.profil;

import com.arkea.com.arkea.commons.archetypes.client.model.ContextClient;
import com.arkea.com.arkea.commons.archetypes.shared.service.ProfilUserService;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ProfilUserResponseBean;
import com.arkea.commons.ihm.shared.model.ApplicationException;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * <p>
 * Tache permettant de récupérer le profil de l'utilisateur et de déclencher un
 * évènement sur le bus notifiant l'utilisateur connecté.
 * </p>
 * <p>
 * Son niveau d'habilitation, son nom
 * </p>
 */
public class ProfilTask implements Command {

	@DefaultLocale("fr")
	public interface ProfilTaskMessages extends Messages {
	  
	  @DefaultMessage("Problème de login. Vérifiez vos droits d''accès")
	  String loginError();
	  
	  
	  @DefaultMessage("Problème de connection serveur")
	  String networkError();
	}
	
	@Inject
	private ProfilUserService.IfaceAsync profilUserService;

	@Inject
	private ContextClient contexteClient;
	
	@Inject
	private ProfilTaskMessages messages;

	/**
	 * Default constructor this widget
	 */
	public ProfilTask() {}

	public void execute() {
		try {
			profilUserService.getProfilUserService(null, new AsyncCallback<ProfilUserResponseBean>() {
				 
						public void onSuccess(ProfilUserResponseBean sortie) {
							// enregistrement du contexte salarie
							contexteClient.setMapFedeAuthorisee(sortie.getMabFederationsAuthorisee());
							contexteClient.setUserConnecte(sortie.getSalarie());
							
							// new TYPEEvent
							/// Event <-- SEARCH BAR ....
							/// Contexte --> MAPBEAN ..
							// ACTION/TYPE --> PARAMETRAGEEFS
							// evenBus.FireEvent(SearchBarEvent)
							
						}
						
						public void onFailure(Throwable caught) {
							GWT.log("ERREUR ProfilTask - profilUserService.getProfilUserService", caught);
							contexteClient.setApplicationException(new ApplicationException(ApplicationException.TYPE_EXCEPTION.TECHNIQUE,messages.networkError()+" "+ caught.getMessage()));
						}
					});
		} catch (ApplicationException e) {
			contexteClient.setApplicationException(e);
		}
	}
}
