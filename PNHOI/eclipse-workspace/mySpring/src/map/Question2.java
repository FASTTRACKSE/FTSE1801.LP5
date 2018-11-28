package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Question2 {
	private int id;
	private String name;
	private Map<String,String> answers;
	
	public Question2() {
		
	}
	
	public Question2(int id, String name, Map<String, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	
	public void displayInfo() {
		System.out.println("question id:"+id);  
		System.out.println("question name:"+name);  
	    System.out.println("Answers....");  
	     
	    for (Map.Entry<String, String> entry : answers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

	     
	}
	
}
