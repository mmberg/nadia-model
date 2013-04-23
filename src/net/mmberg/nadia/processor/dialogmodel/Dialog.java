package net.mmberg.nadia.processor.dialogmodel;

import javax.xml.bind.annotation.*;

import net.mmberg.nadia.dialogmodel.definition.*;

@XmlRootElement
public class Dialog extends DialogModel{
	
	public Dialog(){
		
	}
	
	public Dialog(String name){
		super(name);
	}
}
