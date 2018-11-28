package model.entity;

import java.util.Map;

public class Question2 {
	private int id;
	private String name;
	private Map<String, String> answers;

	public Question2() {
		super();
	}

	public Question2(int id, String name, Map<String, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println("Câu hỏi 1:" + id);
		System.out.println("Tên người hỏi:" + name);
		System.out.println("Trả lời:.....");
//		answers = new LinkedHashMap<String, String>();
		for(Map.Entry<String, String> entry: answers.entrySet()) {
			System.out.println("Câu trả lời: "+ entry.getKey()+ " Đăng bởi: " +entry.getValue());
		}
		
		
		
//		Set<Entry<String, String>> set = answers.entrySet();
//		Iterator<Entry<String,String>> iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Entry<String,String> entry = iterator.next();
//			System.out.println("Câu trả lời:"+ entry.getKey()+ "Đăng bởi:" +entry.getValue());
//		}
	}
}
