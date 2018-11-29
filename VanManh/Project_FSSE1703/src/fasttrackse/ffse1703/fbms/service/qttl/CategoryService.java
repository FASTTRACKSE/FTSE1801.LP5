package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qttl.*;

public interface  CategoryService {
	
	public List<Category> getAll();
	
	public Category getById(int id);
	
	public void addNew(Category category);
	
	public void update(Category category);
	
	public void delete(int id);
	
	public List<Category> findAllForPaging(int startPosition,int maxResult);
}