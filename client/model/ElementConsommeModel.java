package com.arkea.com.arkea.commons.archetypes.client.model;

import java.io.Serializable;
import java.util.List;

import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBaseParametreBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementConsommeBean;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

@SuppressWarnings("serial")
public class ElementConsommeModel implements Serializable {
	public interface ElementConsommeModelProps extends PropertyAccess<ElementConsommeModel> {
		@Path("id")
		public ModelKeyProvider<ElementConsommeModel> key();
		public ValueProvider<ElementConsommeModel, ElementModel> element();
		public ValueProvider<ElementConsommeModel, List<ElementBaseParametreModel>> elementBParam();
	}

	public static final String ID_COL_ELEMENT = "element";
	public static final String ID_COL_ELEMENT_BParam = "elementBParam";

	private static int IDREF = 0;
	private int id;

	private ElementModel element;
	private ElementBaseParametreModel elementBaseParametre;

	public ElementConsommeModel(){
		setId(IDREF++);
	}

	public ElementConsommeModel(ElementModel element, ElementBaseParametreModel elementBaseParametre) {
		this();

		this.element = element;
		this.elementBaseParametre = elementBaseParametre;
	}

	public ElementConsommeModel(ElementBean element, ElementBaseParametreBean elementBaseParametre) {
		this();
		
		this.element = new ElementModel(element);
		this.elementBaseParametre = new ElementBaseParametreModel(elementBaseParametre);
	}

	public ElementConsommeModel(ElementConsommeModel model){
		this(model.getElement(), model.getElementBaseParametre());
	}

	public ElementConsommeModel(ElementConsommeBean bean) {
		this(bean.getElement(), bean.getElementBaseParametre());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ElementModel getElement() {
		return element;
	}

	public void setElement(ElementModel element) {
		this.element = element;
	}

	public ElementBaseParametreModel getElementBaseParametre() {
		return elementBaseParametre;
	}

	public void setElementReservoir(ElementBaseParametreModel elementBaseParametre) {
		this.elementBaseParametre = elementBaseParametre;
	}
}
