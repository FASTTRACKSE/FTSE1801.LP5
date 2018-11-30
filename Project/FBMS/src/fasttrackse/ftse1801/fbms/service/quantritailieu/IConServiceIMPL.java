package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.dao.quantritailieu.IConTaiLieuDao;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;

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
