package model;

public class Address {
   private String city;
   private String country;
  
public Address(String city, String country) {
	super();
	this.city = city;
	this.country = country;
}
   public String toString() {
	   return city+" "+country;
   }
}
