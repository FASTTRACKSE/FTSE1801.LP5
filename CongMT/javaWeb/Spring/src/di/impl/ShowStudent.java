package di.impl;

import java.util.ArrayList;

import dao.StudentDao;
import di1.ListStudent;
import entity.Student;

public class ShowStudent implements ListStudent {

	@Override
	public ArrayList<Student> list() {
		StudentDao studentDao = new StudentDao();
		return studentDao.getStudent();
	}
	

	

}
