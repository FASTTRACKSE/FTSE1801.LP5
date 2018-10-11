package model.entity;

public class ThanhPho {
	private String id;
	private String name;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public ThanhPho() {
		
	}
	
	public ThanhPho(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	
}
