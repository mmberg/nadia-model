package net.mmberg.nadia.dialogmodel.definition.aqd;

public abstract class AQDFormModel {

	//TODO old Style.java -> adapt to AQD2
	
	//serializable members
	protected Integer politeness;
	protected Integer formality;
	protected boolean temporal_opener=false;
	
	//Constructors
	public AQDFormModel(){
		
	}
	
	public AQDFormModel(Integer politeness, Integer formality){
		this.politeness=politeness;
		this.formality=formality;
	}
	
	//Serialization getter/setter	
	public Integer getPoliteness() {
		return politeness;
	}
	public void setPoliteness(Integer politeness) {
		this.politeness = politeness;
	}
	public Integer getFormality() {
		return formality;
	}
	public void setFormality(Integer formality) {
		this.formality = formality;
	}
	
	public void setTemporalOpener(boolean active){
		this.temporal_opener=active;
	}
	
	public boolean getTemporalOpener(){
		return this.temporal_opener;
	}

}
