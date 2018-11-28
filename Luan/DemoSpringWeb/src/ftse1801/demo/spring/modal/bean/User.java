package ftse1801.demo.spring.modal.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nguoi_dung")
public class User {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "userName")
	private String name;
	@Column(name = "passWord")
	private String pass;
	@Column(name = "age")
	private String age;
	@Column(name = "address")
	private String add;
	@Column(name = "image")
	private String img;

	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public User() {
	}
	public User(String id, String name, String pass, String age, String add,String img) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.add = add;
		this.img = img;
	}
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
}
