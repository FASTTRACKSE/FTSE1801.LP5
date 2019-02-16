package ftse1801.managerSale.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT")
	private int id;

	@Column(name = "ID_EMPl")
	private int idEmpl;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "NAME_PRODUCT")
	private String nameProduct;

	@Column(name = "INPUT_PRICE")
	private int inputPrice;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "QUANTITY_INPUTS")
	private int quantityInputs;

	@Column(name = "REMAINING_AMOUNT")
	private int remainingAmount;

	@Column(name = "DATE_ADD")
	private Date dateAdd;

	@Column(name = "DESCRIBE")
	private String describe;

	@Column(name = "ID_STATUS")
	private int idStatus;

	@Column(name = "VIEW")
	private int view;

	@Column(name = "ID_GROUPPRO")
	private int idGrouppro;

	@Column(name = "DEL_FLG")
	private int isDell;

	/**
	 * @param id
	 * @param idEmpl
	 * @param image
	 * @param nameProduct
	 * @param inputPrice
	 * @param price
	 * @param quantityInputs
	 * @param remainingAmount
	 * @param dateAdd
	 * @param describe
	 * @param idStatus
	 * @param view
	 * @param idGrouppro
	 * @param isDell
	 */
	public Product(int id, int idEmpl, String image, String nameProduct, int inputPrice, int price, int quantityInputs,
			int remainingAmount, Date dateAdd, String describe, int idStatus, int view, int idGrouppro, int isDell) {
		super();
		this.id = id;
		this.idEmpl = idEmpl;
		this.image = image;
		this.nameProduct = nameProduct;
		this.inputPrice = inputPrice;
		this.price = price;
		this.quantityInputs = quantityInputs;
		this.remainingAmount = remainingAmount;
		this.dateAdd = dateAdd;
		this.describe = describe;
		this.idStatus = idStatus;
		this.view = view;
		this.idGrouppro = idGrouppro;
		this.isDell = isDell;
	}

	/**
	 * 
	 */
	public Product() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idEmpl
	 */
	public int getIdEmpl() {
		return idEmpl;
	}

	/**
	 * @param idEmpl
	 *            the idEmpl to set
	 */
	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the nameProduct
	 */
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * @param nameProduct
	 *            the nameProduct to set
	 */
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	/**
	 * @return the inputPrice
	 */
	public int getInputPrice() {
		return inputPrice;
	}

	/**
	 * @param inputPrice
	 *            the inputPrice to set
	 */
	public void setInputPrice(int inputPrice) {
		this.inputPrice = inputPrice;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the quantityInputs
	 */
	public int getQuantityInputs() {
		return quantityInputs;
	}

	/**
	 * @param quantityInputs
	 *            the quantityInputs to set
	 */
	public void setQuantityInputs(int quantityInputs) {
		this.quantityInputs = quantityInputs;
	}

	/**
	 * @return the remainingAmount
	 */
	public int getRemainingAmount() {
		return remainingAmount;
	}

	/**
	 * @param remainingAmount
	 *            the remainingAmount to set
	 */
	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	/**
	 * @return the dateAdd
	 */
	public Date getDateAdd() {
		return dateAdd;
	}

	/**
	 * @param dateAdd
	 *            the dateAdd to set
	 */
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe
	 *            the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/**
	 * @return the idStatus
	 */
	public int getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus
	 *            the idStatus to set
	 */
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the view
	 */
	public int getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(int view) {
		this.view = view;
	}

	/**
	 * @return the idGrouppro
	 */
	public int getIdGrouppro() {
		return idGrouppro;
	}

	/**
	 * @param idGrouppro
	 *            the idGrouppro to set
	 */
	public void setIdGrouppro(int idGrouppro) {
		this.idGrouppro = idGrouppro;
	}

	/**
	 * @return the isDell
	 */
	public int getIsDell() {
		return isDell;
	}

	/**
	 * @param isDell
	 *            the isDell to set
	 */
	public void setIsDell(int isDell) {
		this.isDell = isDell;
	}

}
