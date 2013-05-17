package net.mmberg.nadia.dialogmodel.definition;

import javax.xml.bind.annotation.XmlElementRef;

import net.mmberg.nadia.processor.dialogmodel.Action;

public class MetaActionModel {

	protected Action action;

	@XmlElementRef
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}
