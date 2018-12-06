package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;

public interface ContactService {
	public void add(Contact contact);
	public Contact getById(String id);
	public List<Contact> getAll();
	public void update(Contact contact);
	public void delete(String id);
	public List<Contact> listContact(int start, int maxRows);
	public int countContact() ;
	public int checkMaContact(String maContact);

}
