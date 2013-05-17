package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

import net.mmberg.nadia.dialogmodel.definition.actions.GroovyActionModel;

@XmlRootElement
public class GroovyAction extends GroovyActionModel{

	public GroovyAction(){
		super();
	}
	
	public GroovyAction(String template){
		super(template);
	}
}
