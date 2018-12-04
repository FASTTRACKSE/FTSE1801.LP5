package demo.controller;

import java.util.List;

import demo.dao.StudentDao;
import demo.entity.Student;
import demo.entity.diem;

public class MyClass {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		List<Student> listSv= studentDao.getAllStudent();
		for(Student student: listSv) {
			System.out.println(student);
		}
//		// Thêm 1 sinh viên
//		Student student = new Student();
//		student.setId("03");
//		student.setName("Hưng bò bò");
//		student.setOld("20");
//		student.setAdress("Đn");
//		student.setNumberPhone("087654122");
//		student.setImg("");
//		diem diem = new diem();
//		diem.setId("03");
//		diem.setMon("HTML");
//		diem.setDiem("10");
//		student.setDiem(diem);
//		
//		studentDao.addStudent(student);
//		List<Student> listSv1= studentDao.getAllStudent();
//		for(Student student1: listSv1) {
//			System.out.println(student1);
//		}
		
		//Xóa 1 sinh viên
		Student student2= studentDao.getStudentById("03");
		studentDao.deleteStudent(student2);
		List<Student> listSv2= studentDao.getAllStudent();
		for(Student student3: listSv2) {
			System.out.println(student3);
		}
		
//		//Sua 1 sinh viên
//				Student student= studentDao.getStudentById("01");
//				student.setName("Hưng bò bò bò");
//				student.setOld("22");
//				student.setAdress("Đnang");
//				student.setNumberPhone("087654122");
//				student.setImg("");
//				diem diem = new diem();
//				diem.setId("01");
//				diem.setMon("HTML");
//				diem.setDiem("10");
//				student.setDiem(diem);
//				studentDao.editStudent(student);
//				List<Student> listSv3= studentDao.getAllStudent();
//				for(Student student4: listSv3) {
//					System.out.println(student4);
//				}
	}
}
