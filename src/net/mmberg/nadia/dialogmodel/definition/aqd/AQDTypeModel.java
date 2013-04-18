package net.mmberg.nadia.dialogmodel.definition.aqd;

public abstract class AQDTypeModel {

	//serializable members
	protected String answerType;
	
	//Constructors
	public AQDTypeModel(){
		
	}
	
	public AQDTypeModel(String answerType){
		this.answerType=answerType;
	}
	
	//Serialization getter/setter
	public String getAnswerType(){
		return answerType;
	}
	
	public void setAnswerType(String answerType){
		this.answerType=answerType;
	}
	
}
