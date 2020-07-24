package com.arkea.com.arkea.commons.archetypes.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBaseParametreBean;
import com.arkea.com.arkea.commons.archetypes.shared.service.bean.ElementBean;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

@SuppressWarnings("serial")
public class ElementBaseParametreModel implements Serializable {
	public interface ElementBPModelProps extends PropertyAccess<ElementBaseParametreModel> {
		@Path("id")
		public ModelKeyProvider<ElementBaseParametreModel> key();
		public ValueProvider<ElementBaseParametreModel, ElementModel> element();
	}

	public static final String ID_COL_ELEMENT = "element";

	private static int IDREF = 0;
	private int id;

	private List<ElementModel> elements;

	public ElementBaseParametreModel(){
		setId(IDREF++);
	}

	public ElementBaseParametreModel(List<ElementModel> elements) {
		this();
		this.elements = elements;
	}

	public ElementBaseParametreModel(ElementBaseParametreBean bean) {
		this();
		elements = new ArrayList<ElementModel>();
		for(ElementBean element : bean.getElements()){
			elements.add(new ElementModel(element));
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ElementModel> getElements() {
		return elements;
	}

	public void setElements(List<ElementModel> elements) {
		this.elements = elements;
	}
}
