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
	
	public Task getFirstTask(){
		return tasks.get(0);
	}
	
	//Serialization / Deserialization
	
//	public static void save(Dialog d){
//		String filename = d.getName()!=null?d.getName()+".xml":"dialogue.xml";
//		saveAs(d, filename);
//	}
	
	protected void save(OutputStream stream){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Dialog.class);
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
			context = JAXBContext.newInstance(Dialog.class);
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
			context = JAXBContext.newInstance(Dialog.class);
			Unmarshaller um = context.createUnmarshaller();
			d = (Dialog) um.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
	
}