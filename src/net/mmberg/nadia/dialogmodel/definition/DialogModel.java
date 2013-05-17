package net.mmberg.nadia.dialogmodel.definition;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import net.mmberg.nadia.processor.dialogmodel.Dialog;
import net.mmberg.nadia.processor.dialogmodel.Task;

@XmlType(propOrder={"name", "start_task_name", "global_language", "global_politeness","global_formality", "useSODA", "allowSwitchTasks","allowOverAnswering","allowDifferentQuestion","allowCorrection", "tasks"})
public abstract class DialogModel {

	//serializable members
	protected String name; //ID
	protected int global_politeness=3; //default value
	protected int global_formality=3;  //default value
	protected String global_language="en"; //default value
	protected String start_task_name; //refers to the name of a task that is used as entry point
	
	//indirectly specify dialogue strategy (directed, mixed,...):
	protected boolean allowSwitchTasks=true; //allow subdialogues
	protected boolean allowOverAnswering=true; //give more than the information that has been asked for (but at least the current question)
	protected boolean allowDifferentQuestion=true; //ignore current question and answer a different unanswered question
	protected boolean allowCorrection=true; //change a value of an already asked question
	
	protected boolean useSODA=true;	//make use of dialogue acts
	protected ArrayList<Task> tasks; //every dialogue consists of one or several tasks
	
	private final static Logger logger = Logger.getLogger("nina-model"); 
	
	//Constructors
	public DialogModel(){
		tasks=new ArrayList<Task>();
	}	
	
	public DialogModel(String name){
		this();
		this.name=name;
	}
	
	//Serialization getter/setter		
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGlobal_politeness() {
		return global_politeness;
	}

	public void setGlobal_politeness(int global_politeness) {
		this.global_politeness = global_politeness;
	}

	public int getGlobal_formality() {
		return global_formality;
	}

	public void setGlobal_formality(int global_formality) {
		this.global_formality = global_formality;
	}

	public String getGlobal_language() {
		return global_language;
	}

	public void setGlobal_language(String global_language) {
		this.global_language = global_language;
	}

	public String getStart_task_name() {
		return start_task_name;
	}

	public void setStart_task_name(String start_task_name) {
		this.start_task_name = start_task_name;
	}

	public boolean isAllowSwitchTasks() {
		return allowSwitchTasks;
	}

	public void setAllowSwitchTasks(boolean switchTasks) {
		this.allowSwitchTasks = switchTasks;
	}

	public boolean isAllowOverAnswering() {
		return allowOverAnswering;
	}

	public void setAllowOverAnswering(boolean overAnswering) {
		this.allowOverAnswering = overAnswering;
	}

	public boolean isAllowDifferentQuestion() {
		return allowDifferentQuestion;
	}

	public void setAllowDifferentQuestion(boolean differentQuestion) {
		this.allowDifferentQuestion = differentQuestion;
	}

	public boolean isAllowCorrection() {
		return allowCorrection;
	}

	public void setAllowCorrection(boolean correction) {
		this.allowCorrection = correction;
	}

	public boolean isUseSODA() {
		return useSODA;
	}

	public void setUseSODA(boolean useSODA) {
		this.useSODA = useSODA;
	}

	@XmlElementWrapper(name="tasks")
	@XmlElement(name="task")
	public ArrayList<Task> getTasks(){
		return tasks;
	}
	
	public void setTasks(ArrayList<Task> tasks){
		this.tasks=tasks;
	}
	
	
	//Helpers
	
	public void addTask(Task task){
		this.tasks.add(task);
	}
	
	public Task getTask(String name){
		for(Task t : tasks){
			if(t.getName().equals(name)) return t;
		}
		return null;
	}
	
	public Task getStartTask(){
		for(Task t : tasks){
			if(t.getName().equals(this.start_task_name)) return t;
		}
		return null;
	}
	
	public Task getFirstTask(){
		return tasks.get(0);
	}
	
	//Serialization / Deserialization
	
	protected void save(OutputStream stream){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Dialog.class, DialogModel.class);
		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    m.setProperty("jaxb.schemaLocation", "http://mmberg.net/nadia schema1.xsd");
		    m.marshal((Dialog)this, stream);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAs(String path, String filename){
		try {
			URL p=new URL(path);
			save(new FileOutputStream(p.getPath()+"/"+filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toXML(){
		OutputStream stream = new ByteArrayOutputStream();
		save(stream);
		return stream.toString();
	}
	
	public static Dialog loadFromPath(String path){
		JAXBContext context;
		Dialog d=null;
		try {
			context = JAXBContext.newInstance(Dialog.class, DialogModel.class);
			Unmarshaller um = context.createUnmarshaller();
			String p=new URL(path).getPath();
			d = (Dialog) um.unmarshal(new java.io.FileInputStream(p));
			logger.info("loaded dialogue from path "+path);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
	
	public static Dialog loadFromXml(String xml){
		JAXBContext context;
		Dialog d=null;
		try {
			context = JAXBContext.newInstance(Dialog.class, DialogModel.class);
			Unmarshaller um = context.createUnmarshaller();
			d = (Dialog) um.unmarshal(new StringReader(xml));
			logger.info("loaded dialogue from user upload");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
	
	//Schema generation
	public void generateSchema(){
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Dialog.class, DialogModel.class);

			jc.generateSchema(new SchemaOutputResolver() {
					@Override
					public Result createOutput(String namespaceUri, String suggestedFileName)
							throws IOException {
			            StreamResult result = new StreamResult(new FileWriter(suggestedFileName));
			            result.setSystemId(suggestedFileName);
						return result;
					}
				});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}