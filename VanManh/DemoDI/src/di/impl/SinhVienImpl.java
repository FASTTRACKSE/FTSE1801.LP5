package di.impl;

import java.util.List;

import di.DaoInjector;
import di.ITFDao;
import di.SinhVienITF;

public class SinhVienImpl implements DaoInjector,SinhVienITF{
	private ITFDao itfDao;
	@Override
	public void setITFDao(ITFDao itfDao) {
		this.itfDao = itfDao;
	}
	
	@SuppressWarnings("hiding")
	@Override
	public <SinhVien> List<SinhVien> getAllSV() {
		return itfDao.select();
	}
}
