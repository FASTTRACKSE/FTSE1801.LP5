package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CART")
	private int idCart;

	@Column(name = "ID_CUSTOMER")
	private int idCustomer;

	/**
	 * @param idCart
	 * @param idCustomer
	 */
	public Cart(int idCart, int idCustomer) {
		super();
		this.idCart = idCart;
		this.idCustomer = idCustomer;
	}

	/**
	 * 
	 */
	public Cart() {
	}

	/**
	 * @return the idCart
	 */
	public int getIdCart() {
		return idCart;
	}

	/**
	 * @param idCart
	 *            the idCart to set
	 */
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	/**
	 * @return the idCustomer
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/**
	 * @param idCustomer
	 *            the idCustomer to set
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

}
