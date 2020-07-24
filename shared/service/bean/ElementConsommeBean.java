package com.arkea.com.arkea.commons.archetypes.shared.service.bean;

import java.io.Serializable;

import com.arkea.com.arkea.commons.archetypes.client.model.ElementConsommeModel;

@SuppressWarnings("serial")
public class ElementConsommeBean implements Serializable {

	private ElementBean element;
	private ElementBaseParametreBean elementsBaseParametre;

	public ElementConsommeBean() {
	}

	public ElementConsommeBean(ElementConsommeModel model) {
		this();

		element = new ElementBean(model.getElement());
		elementsBaseParametre = new ElementBaseParametreBean(model.getElementBaseParametre());
	}

	public ElementBean getElement() {
		return element;
	}

	public void setElement(ElementBean element) {
		this.element = element;
	}

	public ElementBaseParametreBean getElementBaseParametre() {
		return elementsBaseParametre;
	}

	public void setElementReservoir(ElementBaseParametreBean elementsBaseParametre) {
		this.elementsBaseParametre = elementsBaseParametre;
	}
}

