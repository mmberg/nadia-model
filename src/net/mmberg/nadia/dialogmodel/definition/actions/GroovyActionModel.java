package net.mmberg.nadia.dialogmodel.definition.actions;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import net.mmberg.nadia.processor.dialogmodel.Action;

public abstract class GroovyActionModel extends Action{

	protected String code;
	
	public GroovyActionModel(){
		super();
	}
	
	public GroovyActionModel(String template){
		super(template);
	}
	
	@XmlCDATA //not supported by JAXB, so we use MOXy instead (see jaxb.properties file)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
