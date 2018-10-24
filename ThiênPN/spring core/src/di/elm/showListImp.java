package di.elm;

import java.util.ArrayList;

import di.showList;
import model.SinhVienDAO;

public class showListImp implements showList{

	@Override
	public ArrayList<SinhVien> listSV() {
		SinhVienDAO dao = new SinhVienDAO();
		ArrayList<SinhVien>list = dao.getAllSinhVien();
		return list;
	}

}
