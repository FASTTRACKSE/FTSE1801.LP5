package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.ContactDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public void add(Contact contact) {
		this.contactDao.add(contact);
	}

	@Override
	public Contact getById(String id) {
		return this.contactDao.getById(id);
	}

	@Override
	public List<Contact> getAll() {
		return this.contactDao.getAll();
	}

	@Override
	public void update(Contact contact) {
		this.contactDao.update(contact);
	}

	@Override
	public void delete(String id) {
		this.contactDao.delete(id);
	}

	@Override
	public List<Contact> listContact(int start, int maxRows) {
		return contactDao.listContact(start, maxRows);
	}

	@Override
	public int countContact() {
		return contactDao.countContact();
	}

	@Override
	public int checkMaContact(String maContact) {
		return contactDao.checkMaContact(maContact);
	}
	
}
