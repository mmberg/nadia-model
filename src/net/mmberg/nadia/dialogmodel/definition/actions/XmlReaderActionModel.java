package net.mmberg.nadia.dialogmodel.definition.actions;

import net.mmberg.nadia.processor.dialogmodel.Action;

public abstract class XmlReaderActionModel extends Action{
	
	protected String url;
	protected String xpath;
	
	public XmlReaderActionModel() {
		super();
	}

	public XmlReaderActionModel(String template){
		super(template);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
}
