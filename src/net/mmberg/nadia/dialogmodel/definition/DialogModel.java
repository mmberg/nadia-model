package net.mmberg.nadia.dialogmodel.definition;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

import net.mmberg.nadia.processor.dialogmodel.Dialog;
import net.mmberg.nadia.processor.dialogmodel.Task;

public abstract class DialogModel {

	//serializable members
	protected String name;
	protected int global_politeness=3; //default value
	protected int global_formality=3;  //default value
	protected String global_language="en"; //default value
	protected String start_task_name;
	protected String strategy;
	protected ArrayList<Task> tasks;
	
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

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
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
		    m.marshal((Dialog)this, stream);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAs(String path, String filename){
		try {
			save(new FileOutputStream(path+"/"+filename));
		} catch (FileNotFoundException e) {
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
			d = (Dialog) um.unmarshal(new java.io.FileInputStream(path));
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
	
}
