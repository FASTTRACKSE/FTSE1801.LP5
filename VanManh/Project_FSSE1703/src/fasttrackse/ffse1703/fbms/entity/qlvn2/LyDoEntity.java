package fasttrackse.ffse1703.fbms.entity.qlvn2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ly_do_nghi")
public class LyDoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
   private int id;
	
   @Column(name = "ly_do")
   private String lyDo;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLyDo() {
	return lyDo;
}

public void setLyDo(String lyDo) {
	this.lyDo = lyDo;
}
   
   

}