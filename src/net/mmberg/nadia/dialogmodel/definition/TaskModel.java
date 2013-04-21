package net.mmberg.nadia.dialogmodel.definition;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import net.mmberg.nadia.processor.dialogmodel.*;

@XmlType(propOrder={"selector", "ITOs", "action"})
public abstract class TaskModel {

	//serializable members
	protected String name;
	protected String domain;
	protected DialogAct act;
	protected TaskSelector selector;
	protected ArrayList<ITO> itos;//must not be null; otherwise unmarshalling fails
	protected Action action;
		
	//Constructors
	public TaskModel(){
		itos=new ArrayList<ITO>();
	}
	
	public TaskModel(String name){
		this();
		this.name=name;
	}
	
	//Serialization getter/setter

	@XmlAttribute(name="name")
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public DialogAct getAct() {
		return act;
	}

	public void setAct(DialogAct act) {
		this.act = act;
	}

	@XmlElementRef
	public TaskSelector getSelector() {
		return selector;
	}

	public void setSelector(TaskSelector selector) {
		this.selector = selector;
	}

	@XmlElementRef
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@XmlElementWrapper(name="itos")
	@XmlElement(name="ito")
	public ArrayList<ITO> getITOs(){
		return itos;
	}
	
	//Helpers	
	public void addITO(ITO ito){
		this.itos.add(ito);
	}
		
}
