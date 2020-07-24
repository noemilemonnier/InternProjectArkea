package com.arkea.com.arkea.commons.archetypes.shared.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.arkea.com.arkea.commons.archetypes.client.model.ElementBaseParametreModel;
import com.arkea.com.arkea.commons.archetypes.client.model.ElementModel;


@SuppressWarnings("serial")
public class ElementBaseParametreBean  implements Serializable {

	private List<ElementBean> elements;

	public ElementBaseParametreBean(){
	}

	public ElementBaseParametreBean(ElementBaseParametreModel  model) {
		this();

		for(ElementModel element : model.getElements()){
			elements.add(new ElementBean(element));
		}
	}

	public ElementBaseParametreBean(List<ElementBean> elements) {
		this.elements = elements;
	}

	public List<ElementBean> getElements() {
		return elements;
	}

	public void setElements(List<ElementBean> elements) {
		this.elements = elements;
	}

	public ElementBean getElement(List<ElementBean> elements, int index){
		ElementBean elementBean = new ElementBean();
		elementBean = this.getElements().get(index);
		return elementBean;
	}

	public void setElement(ElementBean element){
		if(this.elements == null){
			this.elements = new ArrayList<ElementBean>();
		}
		this.elements.add(element);
	}
}



