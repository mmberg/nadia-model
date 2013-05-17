package net.mmberg.nadia.processor.dialogmodel;

import net.mmberg.nadia.dialogmodel.definition.*;

public class ITO extends ITOModel{
	public ITO(){
		super();
	}	
	
	public ITO(String name, String fallback_question){
		super(name, fallback_question);
	}
	
	public ITO(String name, String fallback_question, boolean useLG){
		super(name, fallback_question, useLG);
	}
}
