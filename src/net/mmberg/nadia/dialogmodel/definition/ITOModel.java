package net.mmberg.nadia.dialogmodel.definition;

import javax.xml.bind.annotation.XmlAttribute;

import net.mmberg.nadia.processor.dialogmodel.aqd.AQD;

public abstract class ITOModel {
	
	//serializable members
	protected String name;
	protected int group;
	protected int index;
	protected boolean required;
	protected AQD aqd;
	protected String fallback_question;
	protected boolean useLG=true;

	//Constructors
	public ITOModel(){
		
	}	
	
	public ITOModel(String name, String fallback_question){
		this.name=name;
		this.fallback_question=fallback_question;
	}
	
	public ITOModel(String name, String fallback_question, boolean useLG){
		this.name=name;
		this.fallback_question=fallback_question;
		this.useLG=useLG;
	}
	
	//Serialization getter/setter
	@XmlAttribute(name="name")
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setAQD(AQD aqd){
		this.aqd=aqd;
	}
	
	public AQD getAQD() {
		return aqd;
	}
	
	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getFallback_question() {
		return fallback_question;
	}

	public void setFallback_question(String fallback_question) {
		this.fallback_question = fallback_question;
	}

	public boolean isUseLG() {
		return useLG;
	}

	public void setUseLG(boolean useLG) {
		this.useLG = useLG;
	}
	
}
