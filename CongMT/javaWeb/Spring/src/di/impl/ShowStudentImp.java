package di.impl;

import java.util.ArrayList;

import di1.ListStudent;
import di1.StudentClient;
import entity.Student;

public class ShowStudentImp implements StudentClient {
	private ListStudent listStudent;

	@Override
	public void setListStudent(ListStudent listStudent) {
		this.listStudent = listStudent;
	}

	@Override
	public void hienThi() {
		ArrayList<Student> list = listStudent.list();
		System.out.println("Danh sách sinh viên\n");
		System.out.println("Họ và tên    Tuổi         Địa chỉ \n");
		for(int i =1; i< list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t" + list.get(i).getOld() + "\t" + list.get(i).getAdress());
		
		}
	}

	

	
}

