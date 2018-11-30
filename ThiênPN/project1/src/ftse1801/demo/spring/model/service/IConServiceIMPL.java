package ftse1801.demo.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftse1801.demo.spring.model.dao.IConTaiLieuDao;
import ftse1801.demo.spring.model.entity.IconTaiLieu;

public class IConServiceIMPL implements IConService {
	@Autowired
	IConTaiLieuDao iconDao;

	@Override
	public List<IconTaiLieu> getAllIcon() {
		return iconDao.getAllIcon();
	}

	@Override
	public List<IconTaiLieu> getAllIcon(int page, int record) {
		return iconDao.getAllIcon(page, record);
	}

	@Override
	public void insertIcon(IConTaiLieuDao ic) {
		iconDao.insertIcon(ic);
	}

	@Override
	public void updateIcon(IConTaiLieuDao ic) {
		iconDao.updateIcon(ic);
	}

	@Override
	public void deleteIcon(String maIcon) {
		iconDao.deleteIcon(maIcon);
	}

	@Override
	public IconTaiLieu getIconbyMa(String maIcon) {
		return iconDao.getIconbyMa(maIcon);
	}

}
