package net.mmberg.nadia.dialogmodel.definition.actions;

import net.mmberg.nadia.processor.dialogmodel.Action;

public abstract class GroovyActionModel extends Action{

	protected String code;
	
	public GroovyActionModel(){
		super();
	}
	
	public GroovyActionModel(String template){
		super(template);
	}
	
	//TODO CDATA
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
