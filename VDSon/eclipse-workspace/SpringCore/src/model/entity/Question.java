package model.entity;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String name;
	private List<String> answers;

	public Question() {
		super();
	}

	public Question(int id, String name, List<String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	
	public void displayInfo() {
		System.out.println(id+" "+name);
		System.out.println("câu trả lời của bạn là");
		Iterator<String> iterator = answers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
