package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;

public interface ContactDao {
	public List<Contact> findAll();
	public Contact findById(String maContact);
	public void addNew(Contact contact);
	public void update(Contact contact);
	public void delete(Contact contact);
	public int checkContact(String tenContact);
	public List<Contact> listVendor(int start, int maxRows);
	public int countContact();
}
