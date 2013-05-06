package net.mmberg.nadia.dialogmodel.definition;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import net.mmberg.nadia.processor.dialogmodel.*;

@XmlType(propOrder={"domain","act","metaselector", "ITOs", "metaaction","followup"})
public abstract class TaskModel {

	//serializable members
	protected String name;
	protected String domain;
	protected String act;
	protected MetaTaskSelector metaselector;
	protected ArrayList<ITO> itos;//must not be null; otherwise unmarshalling fails
	protected MetaActionModel metaaction;
	protected FollowUp followup;

	
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

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@XmlElement(name="selector", required=false)
	public MetaTaskSelector getMetaselector() {
		return metaselector;
	}

	public void setMetaselector(MetaTaskSelector metaselector) {
		this.metaselector = metaselector;
	}
	
	@XmlElement(name="action", required=false)
	public MetaActionModel getMetaaction() {
		return metaaction;
	}

	public void setMetaaction(MetaActionModel metaaction) {
		this.metaaction = metaaction;
	}


	@XmlElementWrapper(name="itos", required=true)
	@XmlElement(name="ito", required=true)
	public ArrayList<ITO> getITOs(){
		return itos;
	}
	
	public FollowUp getFollowup() {
		return followup;
	}

	public void setFollowup(FollowUp followup) {
		this.followup = followup;
	}
	
	//Helpers	
	public void addITO(ITO ito){
		this.itos.add(ito);
	}
	
	//non-serializable
	
	@XmlTransient
	public Action getAction() {
		//return action;
		if(getMetaaction()!=null){
			return getMetaaction().getAction();	
		}
		else return null;
	}

	public void setAction(Action action) {
		MetaActionModel mam = new MetaActionModel();
		mam.setAction(action);
		setMetaaction(mam);
	}
	
	@XmlTransient
	public TaskSelector getSelector() {
		return getMetaselector().getSelector();
	}

	public void setSelector(TaskSelector selector) {
		MetaTaskSelector mts = new MetaTaskSelector();
		mts.setSelector(selector);
		setMetaselector(mts);
	}
}
