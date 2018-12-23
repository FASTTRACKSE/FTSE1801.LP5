package demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo.bean.Student;



public class JPAStudentDao implements IStudentDao{
	
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> getStudent() {
		return (ArrayList<Student>) entityManagerFactory.createQuery("from Student").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student>  getAllStudent(int pageid, int total) {
//		ArrayList<SinhVien> list = new ArrayList<>();
//		list = (ArrayList<SinhVien>) entityManagerFactory.createEntityGraph(SinhVien.class);
//		entityManagerFactory.close();
		Query query = entityManagerFactory.createQuery("from Student");
		if(pageid!=0) {
			query.setFirstResult(pageid);
		}
		if(total!=0) {
			query.setMaxResults(total);
		}
		return (ArrayList<Student>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCount(int soDong) {
		Query query = entityManagerFactory.createQuery("from Student student order by student.id desc");
		ArrayList<Student> list = (ArrayList<Student>) query.getResultList();
		
		return list.get(0).getId();
	}

	

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deletelStudent(int id) {
		boolean check = false;
		Student student = getAllByStudent(id);
		if(entityManagerFactory.contains(student)) {
			entityManagerFactory.remove(student);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean editStudent(Student student) {
		boolean check = false;
		if(!entityManagerFactory.contains(student)) {
			entityManagerFactory.merge(student);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addStudent(Student student) {
		boolean check=false;
		
		if(!entityManagerFactory.contains(student)) {
			entityManagerFactory.persist(student);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Override
	public Student getAllByStudent(int id){
		Student student = entityManagerFactory.find(Student.class, id);
		entityManagerFactory.close();
		return student;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
