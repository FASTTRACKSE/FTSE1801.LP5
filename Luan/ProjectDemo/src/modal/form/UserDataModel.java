package modal.form;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import modal.bean.UserBean;
import modal.dao.UserDao;

public class UserDataModel extends LazyDataModel<UserBean>{

	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;

	public UserDataModel(UserDao userDao) {
		this.userDao = userDao;
		setRowCount(userDao.showAllUser().size());
	}
	@Override
	public List<UserBean> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		return userDao.showAllUserInPage(first, pageSize);
	}
	
}
