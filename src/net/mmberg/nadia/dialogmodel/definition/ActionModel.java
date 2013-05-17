package net.mmberg.nadia.dialogmodel.definition;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.mmberg.nadia.dialogmodel.adapters.MapAdapter;
import net.mmberg.nadia.processor.dialogmodel.actions.*;

@XmlSeeAlso ({JavaAction.class, GroovyAction.class, HTTPAction.class})
public abstract class ActionModel {

	//serializable features
	protected boolean returnAnswer=true;
	protected String utteranceTemplate=""; //e.g. "The temperature in %getWeatherCity is #temperature!"
//	@XmlJavaTypeAdapter(MapAdapter.class) 
//	protected HashMap<String, String> mapping;
	
	//Constructors
	public ActionModel(){
		
	}
	
	public ActionModel(String utteranceTemplate){
		this.utteranceTemplate=utteranceTemplate;
	}
	
	//Serialization getters/setters
	public boolean isReturnAnswer() {
		return returnAnswer;
	}

	public void setReturnAnswer(boolean returnAnswer) {
		this.returnAnswer = returnAnswer;
	}
	

	public String getUtteranceTemplate() {
		return utteranceTemplate;
	}

	public void setUtteranceTemplate(String utteranceTemplate) {
		this.utteranceTemplate = utteranceTemplate;
	}

//	public HashMap<String, String> getMapping() {
//		return mapping;
//	}
//
//	public void setMapping(HashMap<String, String> mapping) {
//		this.mapping = mapping;
//	}
	
}
