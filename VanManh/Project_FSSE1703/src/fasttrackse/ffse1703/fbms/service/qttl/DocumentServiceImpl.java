package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.dao.qttl.*;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	private DocumentDAO documentDao;
	@Override
	@Transactional
	public List<Document> getAll() {
		 return this.documentDao.getAll();
	}
	@Override
	@Transactional
	public void addNew(Document document) {
		this.documentDao.addNew(document);
	}
	@Override
	@Transactional
	public void update(Document document) {
		this.documentDao.update(document);
	}
	@Override
	@Transactional
	public void delete(int id) {
		this.documentDao.delete(id);
	}
	@Override
	@Transactional
	public Document getById(int id) {
		return this.documentDao.getById(id);
	}
	
	@Override
	@Transactional
	public List<Document> findAllForPaging(int startPosition, int maxResult) {
		return this.documentDao.findAllForPaging(startPosition, maxResult);
	}
	
	@Override
	public List<Category> listCategory() {
		return documentDao.listCategory();
	}
	
	@Override
	public List<Status> listStatus() {
		return documentDao.listStatus();
	}
	
	@Override
	public List<Room> listRoom() {
		return documentDao.listRoom();
	}
	
}
