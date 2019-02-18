package demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diem")
public class diem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	 @Column(name="id", unique = true, nullable = false)
		private String id;
		 @Column(name="mon")
		private String mon;
		 @Column(name="diem")
		private String diem;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMon() {
			return mon;
		}
		public void setMon(String mon) {
			this.mon = mon;
		}
		public String getDiem() {
			return diem;
		}
		public void setDiem(String diem) {
			this.diem = diem;
		}
		
		@Override
	    public String toString() {
			return this.mon +" | "+this.diem;
		}
	
}
