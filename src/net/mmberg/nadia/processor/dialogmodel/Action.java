package net.mmberg.nadia.processor.dialogmodel;

import net.mmberg.nadia.dialogmodel.definition.*;

public abstract class Action extends ActionModel{
	
	public Action(){
		super();
	}
	
	public Action(String utteranceTemplate){
		super(utteranceTemplate);
	}

}
