package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;

public interface ContactDao {
	public Contact getById(String id);
	public List<Contact> getAll();
	public void update(Contact contact);
	public void delete(String id);
	public void add(Contact contact);
	public List<Contact> listContact(int start, int maxRows);
	public int countContact() ;
	public int checkMaContact(String maContact);

}
