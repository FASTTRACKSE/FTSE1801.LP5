package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_POSITION")
	private int idPosition;

	@Column(name = "NAME_POSITION")
	private String namePosition;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idPosition
	 * @param namePosition
	 * @param delFlg
	 */
	public Position(int idPosition, String namePosition, int delFlg) {
		super();
		this.idPosition = idPosition;
		this.namePosition = namePosition;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public Position() {
	}

	/**
	 * @return the idPosition
	 */
	public int getIdPosition() {
		return idPosition;
	}

	/**
	 * @param idPosition
	 *            the idPosition to set
	 */
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	/**
	 * @return the namePosition
	 */
	public String getNamePosition() {
		return namePosition;
	}

	/**
	 * @param namePosition
	 *            the namePosition to set
	 */
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	/**
	 * @return the delFlg
	 */
	public int getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg
	 *            the delFlg to set
	 */
	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}

}
