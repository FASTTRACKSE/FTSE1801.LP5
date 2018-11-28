package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;
import fasttrackse.ffse1703.fbms.entity.qttl.*;
	
	public interface CategoryDAO {
		public List<Category> getAll();

		public Category getById(int id);

		public void delete(int id);

		public void update(Category category);

		public void addNew(Category category);
		
		public List<Category> findAllForPaging(int startPosition,int maxResult);

}
