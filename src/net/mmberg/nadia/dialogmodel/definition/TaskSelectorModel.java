package net.mmberg.nadia.dialogmodel.definition;

import javax.xml.bind.annotation.XmlSeeAlso;

import net.mmberg.nadia.processor.dialogmodel.taskselectors.BagOfWordsTaskSelector;

@XmlSeeAlso({BagOfWordsTaskSelector.class})
public abstract class TaskSelectorModel {

	public TaskSelectorModel(){
		
	}
	
}
