package myJSF;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import model.dao.StudentDao;

public class StudentDataModel extends LazyDataModel<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	public StudentDataModel(StudentDao studentDao) {
		this.studentDao= studentDao;
		setRowCount(studentDao.getStudent().size());
	}
	@Override
	public List<Student>load(int first , int pageSize, String sortField, SortOrder sortOder, Map<String, Object>filters){
		return studentDao.getStudentInPage(pageSize);
		
	}

}
