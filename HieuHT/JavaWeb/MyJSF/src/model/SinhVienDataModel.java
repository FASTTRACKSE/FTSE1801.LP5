package model;

import java.util.List;
import java.util.Map;


import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import myJSF.SinhVien;
import sun.management.LazyCompositeData;

public class SinhVienDataModel extends LazyDataModel<SinhVien>{
	private static final long serialVersionIID =1L;
	private SinhVienDao sinhvienDao;
	public SinhVienDataModel(SinhVienDao sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
		setRowCount(sinhvienDao.getAllSinhVien().size());
	}
	@Override
	public List<SinhVien> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
		
		return sinhvienDao.getAllSinhVien1(first, pageSize);
		
	}
}
