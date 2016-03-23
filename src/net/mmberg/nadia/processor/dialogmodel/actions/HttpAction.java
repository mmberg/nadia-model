package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

import net.mmberg.nadia.dialogmodel.definition.actions.HttpActionModel;

@XmlRootElement
public abstract class HttpAction extends HttpActionModel{

	public HttpAction(){
		super();
	}
	
	public HttpAction(String template){
		super(template);
	}
	
}
