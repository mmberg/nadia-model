package net.mmberg.nadia.dialogmodel.definition;

import javax.xml.bind.annotation.XmlElementRef;

import net.mmberg.nadia.processor.dialogmodel.TaskSelector;

public class MetaTaskSelector {

	protected TaskSelector selector;

	@XmlElementRef
	public TaskSelector getSelector() {
		return selector;
	}

	public void setSelector(TaskSelector selector) {
		this.selector = selector;
	}
	
	
}
