package fasttrackse.ffse1703.fbms.entity.qlvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ly_do_xin_nghi")
public class LyDoXinNghi {
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
