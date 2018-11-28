package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.dao.qttl.*;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDAO categoryDao;
	@Override
	@Transactional
	public List<Category> getAll() {
		 return this.categoryDao.getAll();
	}
	@Override
	@Transactional
	public void addNew(Category category) {
		this.categoryDao.addNew(category);
	}
	@Override
	@Transactional
	public void update(Category category) {
		this.categoryDao.update(category);
	}
	@Override
	@Transactional
	public void delete(int id) {
		this.categoryDao.delete(id);
	}
	@Override
	@Transactional
	public Category getById(int id) {
		return this.categoryDao.getById(id);
	}
	
	@Override
	@Transactional
	public List<Category> findAllForPaging(int startPosition, int maxResult) {
		return this.categoryDao.findAllForPaging(startPosition, maxResult);
	}
	
}
