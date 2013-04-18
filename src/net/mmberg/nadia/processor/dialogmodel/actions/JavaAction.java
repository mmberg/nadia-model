package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

import net.mmberg.nadia.dialogmodel.definition.actions.JavaActionModel;

@XmlRootElement
public class JavaAction extends JavaActionModel{	
	
	public JavaAction(){
		super();
	}
	
	public JavaAction(String template){
		super(template);
	}
}
