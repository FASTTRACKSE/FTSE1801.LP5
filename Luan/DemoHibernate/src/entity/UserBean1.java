package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nguoi_dung")
public class UserBean1 {
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

	public UserBean1() {
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
	
	@Override
	public String toString() {
		return "User "+id+"|"+name+"|"+pass+"|"+age+"|"+add+"|"+img;
	}
}
