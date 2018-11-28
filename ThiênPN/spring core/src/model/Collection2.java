package model;

import java.util.Map;

public class Collection2 {
  private int id;
  private String name;
  private Map<Address, User>map;
  public Collection2() {
	  
  }
public Collection2(int id, String name, Map<Address, User> map) {
	super();
	this.id = id;
	this.name = name;
	this.map = map;
}
  public void Info() {
	 System.out.println("1"+id+" "+ name);
	 for(Map.Entry<Address, User>entry:map.entrySet()) {
		 System.out.println(entry.getKey()+"///"+entry.getValue());
	 }
  }
}
