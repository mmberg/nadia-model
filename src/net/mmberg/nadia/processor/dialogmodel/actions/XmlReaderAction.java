package net.mmberg.nadia.processor.dialogmodel.actions;

import javax.xml.bind.annotation.XmlRootElement;

import net.mmberg.nadia.dialogmodel.definition.actions.XmlReaderActionModel;

@XmlRootElement
public class XmlReaderAction extends XmlReaderActionModel{

	public XmlReaderAction(){
		super();
	}
	
	public XmlReaderAction(String template){
		super(template);
	}
}
