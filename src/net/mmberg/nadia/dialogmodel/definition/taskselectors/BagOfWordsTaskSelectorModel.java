package net.mmberg.nadia.dialogmodel.definition.taskselectors;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import net.mmberg.nadia.processor.dialogmodel.TaskSelector;

public abstract class BagOfWordsTaskSelectorModel extends TaskSelector{

	protected ArrayList<String> words;
	
	public BagOfWordsTaskSelectorModel(){
		
	}
	
	public BagOfWordsTaskSelectorModel(ArrayList<String> words){
		this.words=words;
	}
	
	
	@XmlElementWrapper(name="bagOfWords")
	@XmlElement(name="word")
	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	
}
