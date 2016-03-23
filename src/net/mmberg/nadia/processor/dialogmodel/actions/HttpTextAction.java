package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HttpTextAction extends HttpAction{

	public HttpTextAction(){
		super();
	}
	
	public HttpTextAction(String template){
		super(template);
	}
	
	protected String extractResults(String content){
		return "";
	};
}
