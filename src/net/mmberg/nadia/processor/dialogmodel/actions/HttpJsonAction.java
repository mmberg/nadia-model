package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HttpJsonAction extends HttpAction{

	public HttpJsonAction(){
		super();
	}
	
	public HttpJsonAction(String template){
		super(template);
	}
	
	protected String extractResults(String content){
		return "";
	};
}
