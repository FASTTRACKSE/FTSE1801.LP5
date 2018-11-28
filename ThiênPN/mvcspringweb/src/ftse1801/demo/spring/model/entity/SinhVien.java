package ftse1801.demo.spring.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
@Entity
@Table(name = "sinh_vien", uniqueConstraints = { @UniqueConstraint(columnNames = "ten"),
		@UniqueConstraint(columnNames = "pass"), @UniqueConstraint(columnNames = "tuoi"),
		@UniqueConstraint(columnNames = "img"), })
public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	private String maSinhVien;

	private String tensinhVien;

	private String password;

	private String tuoi;

	private String img;

	private List<Diem> listDiem;

	public SinhVien(String maSinhVien, String tensinhVien, String password, String tuoi, String img,
			List<Diem> listDiem) {
		super();
		this.maSinhVien = maSinhVien;
		this.tensinhVien = tensinhVien;
		this.password = password;
		this.tuoi = tuoi;
		this.img = img;
		this.listDiem = listDiem;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "maSV", unique = true, nullable = false)
	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	@Column(name = "ten")
	public String getTensinhVien() {
		return tensinhVien;
	}

	public void setTensinhVien(String tensinhVien) {
		this.tensinhVien = tensinhVien;
	}

	@Column(name = "pass")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tuoi")
	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	@Column(name = "img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sinhVien", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Diem> getListDiem() {
		return listDiem;
	}

	public void setListDiem(List<Diem> listDiem) {
		this.listDiem = listDiem;
	}

}
