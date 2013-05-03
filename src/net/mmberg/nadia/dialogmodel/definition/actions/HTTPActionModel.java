package net.mmberg.nadia.dialogmodel.definition.actions;

import net.mmberg.nadia.processor.dialogmodel.Action;

public abstract class HTTPActionModel extends Action{
	
	protected String url;
	protected String params;
	protected String method;
	protected String xpath;
	
	public HTTPActionModel() {
		super();
	}

	public HTTPActionModel(String template){
		super(template);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
}
