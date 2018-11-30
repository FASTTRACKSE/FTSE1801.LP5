package model.entity;

public class Address2 {
	private String address,city,stage,country;

	public Address2(String address, String city, String stage, String country) {
		super();
		this.address = address;
		this.city = city;
		this.stage = stage;
		this.country = country;
	}

	public String toString() {
		return address+" " +city+ " "+stage+" "+country;
	}
}
