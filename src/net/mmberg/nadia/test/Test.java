package net.mmberg.nadia.test;

import java.util.ArrayList;
import java.util.Arrays;

import net.mmberg.nadia.dialogmodel.definition.DialogModel;
import net.mmberg.nadia.processor.dialogmodel.*;
import net.mmberg.nadia.processor.dialogmodel.actions.*;
import net.mmberg.nadia.processor.dialogmodel.aqd.*;
import net.mmberg.nadia.processor.dialogmodel.taskselectors.*;

public class Test {

	public static void main(String[] args){

		//create a dialogue and test marshalling/unmarshalling/(re)marshalling
		Test store = new Test();
		Dialog d = store.createDummyDialog();
		String diaxml = d.toXML();
		Dialog d2 = DialogModel.loadFromXml(diaxml);
		diaxml = d2.toXML();
		System.out.println(diaxml);
	}
	
	
	private Dialog createDummyDialog(){
		
		Dialog dialog = new Dialog("dummy");
		ITO ito;
		AQD aqd;
		
		//Task 0
		//----------------------------------------------
		Task task0=new Task("start");
		ArrayList<String> bagOfWords = new ArrayList<String>(Arrays.asList("hello"));
		task0.setSelector(new BagOfWordsTaskSelector(bagOfWords));
		dialog.addTask(task0);
	
		//ITO 1
		ito=new ITO("welcome", "Hello! How may I help you?", false);	
		task0.addITO(ito);
		//an ITO is associated with AQDs
		aqd=new AQD();
		aqd.setType(new AQDType("open_ended"));
		ito.setAQD(aqd);
		
		
		//Task 1
		//----------------------------------------------
		Task task1=new Task("getTripInformation");
		bagOfWords = new ArrayList<String>(Arrays.asList("travel","book", "journey","trip"));
		task1.setSelector(new BagOfWordsTaskSelector(bagOfWords));
		
//		JavaAction jaction=new JavaAction("This trip from %getDepartureCity to %getDestinationCity costs #temperature Euros.");
//		try{
//			jaction.setPath("/Users/markus/");
//			jaction.setClassName("net.mmberg.nadia.processor.nlu.actions.TestExtJavaAction");
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		task1.setAction(jaction);
		
		GroovyAction gaction = new GroovyAction("This trip from %getDepartureCity to %getDestinationCity costs #price Euros.");
		gaction.setCode("executionResults.put(\"price\",\"257\")");
		//gaction.setReturnAnswer(false);
		task1.setAction(gaction);
		
		dialog.addTask(task1);
		
		//ITO 1
		ito=new ITO("getDepartureCity", "Where do you want to start?", false);	
		task1.addITO(ito);
		aqd=new AQD();
		aqd.setType(new AQDType("fact.named_entity.non_animated.location.city"));
		ito.setAQD(aqd);		
		
		//ITO 2
		ito=new ITO("getDestinationCity", "Where do you want to go?", false);	
		task1.addITO(ito);
		aqd=new AQD();
		aqd.setType(new AQDType("fact.named_entity.non_animated.location.city"));
		ito.setAQD(aqd);	
		
		
		//Task2
		//----------------------------------------------
		Task task2=new Task("getWeatherInformation");
		bagOfWords = new ArrayList<String>(Arrays.asList("weather","forecast", "temperature","trip"));
		task2.setSelector(new BagOfWordsTaskSelector(bagOfWords));
		gaction = new GroovyAction("The temperature in %getWeatherCity is #temperature degrees.");
		gaction.setCode("" +
				"import groovyx.net.http.*\r\n"+
				"import javax.xml.xpath.*\r\n"+
				"def http = new HTTPBuilder('http://weather.yahooapis.com')\r\n"+
				"http.get( path: '/forecastrss', query:[w:'2502265',u:'c'],  contentType: ContentType.XML) { resp, xml -> \r\n"+
				"   def temp = xml.channel.item.condition[0].@temp\r\n"+
				"	executionResults.put(\"temperature\",temp.toString())\r\n"+
				"}"
		);
		task2.setAction(gaction);
		dialog.addTask(task2);
		
		//ITO 1
		ito=new ITO("getWeatherCity", "For which city do you want to know the weather?", false);	
		task2.addITO(ito);
		aqd=new AQD();
		aqd.setType(new AQDType("fact.named_entity.non_animated.location.city"));
		ito.setAQD(aqd);		
		
		return dialog;			
	}	

	
}