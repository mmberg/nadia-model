package net.mmberg.nadia.dialogmodel.definition;

import java.util.HashMap;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.mmberg.nadia.dialogmodel.adapters.MapAdapter;
import net.mmberg.nadia.processor.dialogmodel.ITO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FollowUpModel {

	protected ITO ito;
	@XmlJavaTypeAdapter(MapAdapter.class) 
	protected HashMap<String, String> answerMapping=new HashMap<String, String>();
	
	public FollowUpModel(){
	}
	
	public ITO getIto() {
		return ito;
	}
	public void setIto(ITO ito) {
		this.ito = ito;
	}

	
	public HashMap<String, String> getAnswerMapping() {
		return answerMapping;
	}

	public void setAnswerMapping(HashMap<String, String> answerMapping) {
		this.answerMapping = answerMapping;
	}
}
