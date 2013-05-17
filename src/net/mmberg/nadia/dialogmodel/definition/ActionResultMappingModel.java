package net.mmberg.nadia.dialogmodel.definition;

public class ActionResultMappingModel {

	 protected String resultVarName;
	 protected String resultValue;
	 protected String message;
	 protected String redirectToTask;
	 
	 public ActionResultMappingModel(){
		 
	 }
	 
	 public ActionResultMappingModel(String resultVarName, String resultValue, String message, String redirectToTask){
		 this.resultVarName=resultVarName;
		 this.resultValue=resultValue;
		 this.message=message;
		 this.redirectToTask=redirectToTask;
	 }

	public String getResultVarName() {
		return resultVarName;
	}

	public void setResultVarName(String resultVarName) {
		this.resultVarName = resultVarName;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRedirectToTask() {
		return redirectToTask;
	}

	public void setRedirectToTask(String redirectToTask) {
		this.redirectToTask = redirectToTask;
	}
}
