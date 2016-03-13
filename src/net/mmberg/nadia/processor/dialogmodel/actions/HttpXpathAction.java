package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HttpXpathAction extends HttpAction{

	public HttpXpathAction(){
		super();
	}
	
	public HttpXpathAction(String template){
		super(template);
	}
	
	protected String extractResults(String content){
		return "";
	};
}
