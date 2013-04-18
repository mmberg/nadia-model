package net.mmberg.nadia.dialogmodel.definition;

import javax.xml.bind.annotation.XmlSeeAlso;

import net.mmberg.nadia.processor.dialogmodel.actions.*;

@XmlSeeAlso ({JavaAction.class, GroovyAction.class})
public abstract class ActionModel {

	//serializable features
	protected boolean returnAnswer=true;
	protected String utteranceTemplate=""; //e.g. "The temperature in %getWeatherCity is #temperature!"
	
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
	
}
