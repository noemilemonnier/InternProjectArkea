package com.arkea.com.arkea.commons.archetypes.client.widgets.commons.researchresult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;


import com.arkea.com.arkea.commons.archetypes.client.model.ElementModel;
import com.arkea.com.arkea.commons.archetypes.client.model.ElementModel.ElementModelProps;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.WidgetCommon;
import com.arkea.com.arkea.commons.archetypes.client.widgets.commons.searchbar.SearchBarWidgetEvent;
import com.arkea.com.arkea.commons.archetypes.shared.service.ProfilUserService;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.BaseParametreResponseBean;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.EmptyValidator;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowExpander;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;



/**
 * PLEASE PUT SOME COMMENTS ON WIDGET BEHAVIOUR HERE
 * 
 * @EventsCaught : 
 *  TODO : mentioned the events caught by the widget
 * @EventsFired :
 *  TODO : mentioned the events fired by the widget
 * 
 */
public class ResearchResult extends WidgetCommon implements  SearchBarWidgetEvent.Handler {


	/*
	 * Declaration variables
	 */
	ElementModelProps props = GWT.create(ElementModelProps.class);	
	ListStore<ElementModel> store = new ListStore<ElementModel>(props.key());

	//elements necessaires pr ajouter
	Window window = new Window();
	Button validerAjout = new Button();
	Label cdApli, cdEfs, noSeq, cmt, vlrPrm, tmstp ;

	// elements necessaires pr supprimer
	Window window2 = new Window(); 
	Button validerSupprimer = new Button();
	List<ElementModel> listDelete;

	// elements necessaires pr la confirmation d'ajout
	Window window3  = new Window(); 
	Button ok = new Button();
	Button annuler = new Button(); 


	// pr checkbox
	IdentityValueProvider<ElementModel> identity = new IdentityValueProvider<ElementModel>();
	final CheckBoxSelectionModel<ElementModel> selectionModel = new CheckBoxSelectionModel<ElementModel>(identity);

	/*
	 * Declare UIBinder for this widget
	 */
	@UiTemplate("ResearchResult.ui.xml")
	interface ResearchResultUiBinder extends UiBinder<Widget, ResearchResult> {
	}
	/* UIBinder for building interface */
	private ResearchResultUiBinder uiBinder ;

	//listboxefs 
	@Inject
	private ProfilUserService.IfaceAsync profilUserService;	

	/* UIBinder bindings */
	@UiField FlowPanel rootPanel;
	@UiField ResearchResultMessages messages; 
	@UiField Label message;
	@UiField FlowPanel gridPanel;
	@UiField VerticalPanel researchResultPanel;
	@UiField Button BtnAjout;
	@UiField Button BtnSupprimer;
	@UiField Button BtnClear;

	/*
	 * Constructor for this widget
	 * @param eventBus the event bus on which events are fired/caught
	 */
	@Inject
	private ResearchResult(EventBus eventBus) {
		super(eventBus);

		// create UI
		uiBinder = GWT.create(ResearchResultUiBinder.class);
		Widget myWidget = uiBinder.createAndBindUi(this);


		// connect handler
		handlersRegistration.add(eventBus.addHandler(SearchBarWidgetEvent.TYPE, this));		

		/*
		 * Row Expander
		 */
		RowExpander<ElementModel> rowExpander = new RowExpander<ElementModel>( new AbstractCell<ElementModel>(){
			@Override
			public void render(Context context, ElementModel value, SafeHtmlBuilder sb){
				sb.appendHtmlConstant("<p style='margin: 5px 5px 10px'><b>Commentaire: </b>" + value.getCmt() + "</p>");
				sb.appendHtmlConstant("<p style='margin: 5px 5px 10px'><b>Valeur parametre: </b> " + value.getVlrpar()+ "</p>");
				sb.appendHtmlConstant("<p style='margin: 5px 5px 10px'><b>Time Stamp: </b> " + value.getTmStp());
			}
		});

		/*
		 * Creation de la barre de recherche avec 4 colonnes
		 */ 
		ColumnConfig<ElementModel, String> nameCol1 = new ColumnConfig<ElementModel, String>(props.apli(), 160, "Code application");
		ColumnConfig<ElementModel, String> nameCol2 = new ColumnConfig<ElementModel, String>(props.efs(), 160, "Code EFS");
		ColumnConfig<ElementModel, String> nameCol3 = new ColumnConfig<ElementModel, String>(props.seq(), 250, "Numéro de Séquence");
		ColumnConfig<ElementModel, String> nameCol4 = new ColumnConfig<ElementModel, String>(props.cmt(), 350, "Commentaire");

		/*
		 * CheckBox 
		 */
		SimpleComboBox<String> typeCombo = new SimpleComboBox<String>(new StringLabelProvider<String>());
		typeCombo.setTriggerAction(TriggerAction.ALL);
		typeCombo.setEditable(false);
		typeCombo.setWidth(100);
		typeCombo.addSelectionHandler(new SelectionHandler<String>(){
			public void onSelection(SelectionEvent<String> event){
				selectionModel.deselectAll();
			}
		});

		/*
		 * Ajout des columns
		 */
		List<ColumnConfig<ElementModel, ?>> columns = new ArrayList<ColumnConfig<ElementModel, ?>>();
		columns.add(selectionModel.getColumn());
		columns.add(rowExpander);
		columns.add(nameCol1);
		columns.add(nameCol2);
		columns.add(nameCol3);
		columns.add(nameCol4);


		ColumnModel<ElementModel> cm = new ColumnModel<ElementModel>(columns);

		final Grid<ElementModel> grid = new Grid<ElementModel>(store, cm);

		/*
		 * Grid Editor
		 */
		GridEditing<ElementModel> editing = new GridInlineEditing<ElementModel>(grid);

		// Add field validator to the text field
		TextField textField = new TextField();
		textField.addValidator(new EmptyValidator<String>()); // or textField.setAllowBlank(false);
		textField.addValidator(new RegExValidator("^[^a-z]+$", "edited"));

		// what can be edited
		editing.addEditor(nameCol1, textField);
		editing.addEditor(nameCol2, textField);
		editing.addEditor(nameCol3, textField);
		editing.addEditor(nameCol4, textField);

		// wire it up to the grid
		rowExpander.initPlugin(grid);

		store.setAutoCommit(true);

		/*
		 * Grid characteristics
		 */
		grid.setSelectionModel(selectionModel); // add checkbox
		grid.setAllowTextSelection(true);
		grid.getView().setAutoExpandColumn(nameCol1);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.setBorders(false);
		grid.setColumnReordering(true);
		grid.setHeight(370);
		gridPanel.add(grid);

		/*
		 * Elements necessaires a la Window quand on clique sur le bouton Ajouter
		 */
		VerticalPanel panel = new VerticalPanel();

		cdApli = new Label("Code Application: ");
		panel.add(cdApli);
		final TextBox textboxApli = new TextBox();
		panel.add(textboxApli);

		cdEfs = new Label("Code EFS: ");
		panel.add(cdEfs);
		final TextBox listboxEfs = new TextBox();
		panel.add(listboxEfs);

		noSeq = new Label("Numéro Séquence: ");
		panel.add(noSeq);
		final TextBox textboxSeq = new TextBox();
		panel.add(textboxSeq);

		cmt = new Label("Commentaire: ");
		panel.add(cmt);
		final TextBox textboxCmt = new TextBox();
		panel.add(textboxCmt);

		vlrPrm = new Label("Valeur paramètre: ");
		panel.add(vlrPrm);
		final TextBox textboxVlr = new TextBox();
		panel.add(textboxVlr);

		tmstp = new Label("Time Stamp: ");
		panel.add(tmstp);
		final TextBox textboxTm = new TextBox();
		textboxTm.setReadOnly(true);
		panel.add(textboxTm);

		validerAjout.setPixelSize(60, 25);
		validerAjout.setText("Valider");
		panel.add(validerAjout);	
		panel.setPixelSize(500, 300);

		/*
		 * Window characteristics
		 */
		window.add(panel);
		window.setShadow(true);
		window.setHeadingText("Ajouter un paramètre");
		window.setPosition(550,300);
		window.setResizable(false);
		window.setClosable(true);
		window.getDraggable();

		/*
		 * Window de confirmation de l'ajout 
		 */
		VerticalPanel panelConfirmer = new VerticalPanel();
		Label text2= new Label("CONFIRMEZ-VOUS L'AJOUT DE CE PARAMETRE: ");
		panelConfirmer.add(text2);

		Label cdApli2 = new Label("Code Application: ");
		panelConfirmer.add(cdApli2);
		final TextBox textboxApli2 = new TextBox();
		textboxApli2.setReadOnly(true);
		panelConfirmer.add(textboxApli2);

		Label cdEfs2 = new Label("Code EFS: ");
		panelConfirmer.add(cdEfs2);
		final TextBox listboxEfs2 = new TextBox();
		listboxEfs2.setReadOnly(true);
		panelConfirmer.add(listboxEfs2);

		Label noSeq2 = new Label("Numéro Séquence: ");
		panelConfirmer.add(noSeq2);
		final TextBox textboxSeq2 = new TextBox();
		textboxSeq2.setReadOnly(true);
		panelConfirmer.add(textboxSeq2);

		Label cmt2 = new Label("Commentaire: ");
		panelConfirmer.add(cmt2);
		final TextBox textboxCmt2 = new TextBox();
		textboxCmt2.setReadOnly(true);
		panelConfirmer.add(textboxCmt2);

		Label vlrPrm2 = new Label("Valeur paramètre: ");
		panelConfirmer.add(vlrPrm2);
		final TextBox textboxVlr2 = new TextBox();
		textboxVlr2.setReadOnly(true);
		panelConfirmer.add(textboxVlr2);

		Label tmstp2 = new Label("Time Stamp: ");
		panelConfirmer.add(tmstp2);
		final TextBox textboxTm2 = new TextBox();
		textboxTm2.setReadOnly(true);
		panelConfirmer.add(textboxTm2);

		ok.setPixelSize(60, 25);
		ok.setText("OK");
		panelConfirmer.add(ok);	

		annuler.setPixelSize(60, 25);
		annuler.setText("Annuler");
		panelConfirmer.add(annuler);
		panelConfirmer.setPixelSize(500, 300);

		/*
		 * Window 3 characteristics
		 */
		window3.add(panelConfirmer);
		window3.setShadow(true);
		window3.setHeadingText("Confirmation d'ajout d'un paramètre");
		window3.setPosition(550,300);
		window3.setResizable(false);
		window3.setClosable(false);
		window3.getDraggable();


		/*
		 * When user clicks on "Ajouter"
		 */
		BtnAjout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event){
				//pour avoir la date et l'heure mis a jour a chaque ouverture de la fenetre
				Date date = new Date();
				DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy.MM.dd.HH.mm.ss");
				textboxTm.setText(dtf.format(date, TimeZone.createTimeZone(-60)));
				window.setVisible(true);

				validerAjout.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event){
						// pour que la fenetre de confirmation affiche les donnees rentrees precedemment par le user
						textboxApli2.setText(textboxApli.getText());
						listboxEfs2.setText(listboxEfs.getText());
						textboxSeq2.setText(textboxSeq.getText());
						textboxCmt2.setText(textboxCmt.getText());
						textboxVlr2.setText(textboxVlr.getText());
						textboxTm2.setText(textboxTm.getText());
						// afficher la fenetre de confirmation
						window3.setVisible(true);
					}
				});
			}

		});


		//si le parametre est OK alors ajouter au store et les 2 windows se ferment
		ok.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event){
				// ajouter l'element dans le store
				store.add(new ElementModel(textboxApli.getText(), listboxEfs.getText(), textboxSeq.getText(), textboxCmt.getText(), textboxVlr.getText(), textboxTm.getValue()));
				// ferme la fenetre de confirmation et la page d'ajout
				window3.setVisible(false);
				window.setVisible(false);
				// reinitialiser les textbox
				textboxApli.setText("");
				textboxApli.setText("");
				listboxEfs.setText("");
				textboxSeq.setText("");
				textboxCmt.setText("");
				textboxVlr.setText("");
				textboxTm.setValue("");
			}
		});

		// si erreur, window 3 se ferme et user retombe sur la window de l'ajout
		annuler.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event){
				// si l'element se creait dans le store i lsera supprimer
				store.remove(new ElementModel(textboxApli.getText(), listboxEfs.getText(), textboxSeq.getText(), textboxCmt.getText(),  textboxVlr.getText(), textboxTm.getValue()));
				// la fenetre de confirmation se ferme
				window3.setVisible(false);
			}
		});



		/*
		 * Boutton Supprimer
		 */
		VerticalPanel panel2 = new VerticalPanel();
		Label text = new Label("Confirmez-vous la suppression de l'élément sélectionné?");
		panel2.add(text);

		validerSupprimer.setPixelSize(60, 25);
		validerSupprimer.setText("Valider");
		panel2.add(validerSupprimer);	

		panel2.setPixelSize(350, 150);
		window2.add(panel2);

		window2.setShadow(true);
		window2.setHeadingText("Supprimer un paramètre");
		window2.setPosition(600,300);
		window2.setResizable(false);
		window2.setClosable(true);
		window2.getDraggable();

		BtnSupprimer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				window2.setVisible(true);
			}

		});
		// validation de la suppression 
		validerSupprimer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event){
				listDelete = new ArrayList<ElementModel>(selectionModel.getSelectedItems());
				for(ElementModel element : listDelete) {
					for(int i = 0; i< store.size(); i++){
						if(store.get(i) == element){
							store.remove(store.get(i));
						}
					}
				}
				window2.setVisible(false);
			}
		});

		/*
		 * Button réinitialiser le store pr de nouvelles recherches
		 */
		BtnClear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				store.clear();
			}
		});
		initWidget(myWidget);
	}

	/*
	 * Results in the grid
	 */
	public void onRechercheBaseParametre(SearchBarWidgetEvent event) {

		store.clear();//(arg0.getListeElementsConsommes().size()
		store.add(new ElementModel(event.getContext().getApli(), event.getContext().getEfs(), event.getContext().getSeq(), event.getContext().getCommentaireBP(),  event.getContext().getVlrpar() , event.getContext().getTmstp()));

		//store.add(new ElementModel(event.getContext().getApli(), event.getContext().getEfs(), event.getContext().getSeq(), event.getContext().getCommentaireBP(),  event.getContext().getVlrpar() , event.getContext().getTmstp()));

	}
}  



