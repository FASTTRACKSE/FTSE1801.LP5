package model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import myJSF.SinhVien;

public class SinhVienDataModel extends LazyDataModel<SinhVien>{
	private static final long serialVersionUID = 1L;
	
	private QLSinhVienDAO qlSinhVienDAO;
	
	public SinhVienDataModel(QLSinhVienDAO qlSinhVienDAO) {
		this.qlSinhVienDAO = qlSinhVienDAO;
		setRowCount(qlSinhVienDAO.displayAllSinhVien().size());
	}
	
	@Override
	public List<SinhVien> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
		return qlSinhVienDAO.displayAllSinhVien(first, pageSize);
	}
}
