package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quantritailieu.IConTaiLieuDao;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;
@Service
public class IConServiceIMPL implements IConService {
	@Autowired
	private IConTaiLieuDao iConTaiLieuDao;

	@Override
	public List<IconTaiLieu> getAllIcon() {
		return iConTaiLieuDao.getAllIcon();
	}

	@Override
	public List<IconTaiLieu> getAllIcon(int page, int record) {
		return iConTaiLieuDao.getAllIcon(page, record);
	}

	@Override
	public void insertIcon(IconTaiLieu ic) {
		iConTaiLieuDao.insertIcon(ic);
	}

	@Override
	public void updateIcon(IconTaiLieu ic) {
		iConTaiLieuDao.updateIcon(ic);
	}

	@Override
	public void deleteIcon(String maIcon) {
		iConTaiLieuDao.deleteIcon(maIcon);
	}

	@Override
	public IconTaiLieu getIconbyMa(String maIcon) {
		return iConTaiLieuDao.getIconbyMa(maIcon);
	}

}
