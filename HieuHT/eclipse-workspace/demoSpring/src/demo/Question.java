package demo;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String name;
	private List<Answer> traloi;
	
	public Question() {
		
	}
	
	public Question(int id, String name, List<Answer> traloi) {
		this.id = id;
		this.name = name;
		this.traloi = traloi;
	}
	
	public void displayInfo() {
		System.out.println(id+""+name);
		System.out.println("Câu trả lời:");
		Iterator<Answer> itr = traloi.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
