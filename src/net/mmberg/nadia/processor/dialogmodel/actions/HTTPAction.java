package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

import net.mmberg.nadia.dialogmodel.definition.actions.HTTPActionModel;

@XmlRootElement
public class HTTPAction extends HTTPActionModel{

	public HTTPAction(){
		super();
	}
	
	public HTTPAction(String template){
		super(template);
	}
}
