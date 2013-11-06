package net.mmberg.nadia.dialogmodel.definition.aqd;

import net.mmberg.nadia.processor.dialogmodel.aqd.*;

public abstract class AQDModel {

	//serializable members
	protected AQDForm form;
	protected AQDType type;
	protected AQDContext context;
	
	//Constructors
	public AQDModel(){
		
	}
	
	public AQDModel(AQDType type, AQDContext context, AQDForm form){
		this.type=type;
		this.form=form;
		this.context=context;
	}
	
	//Serialization getter/setter
	public void setType(AQDType type){
		this.type=type;
	}
	
	public AQDType getType(){
		return type;
	}

	public AQDForm getForm() {
		return form;
	}

	public void setForm(AQDForm form) {
		this.form = form;
	}

	public AQDContext getContext() {
		return context;
	}

	public void setContext(AQDContext context) {
		this.context = context;
	}
	
	public void guru(){
		
	}

}
