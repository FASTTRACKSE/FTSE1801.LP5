package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu.IconDao;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;
@Service
public class IconServiceImpl implements IconService {
	@Autowired
	private IconDao daoIC;

	@Override
	public List<IconTaiLieu> listAllIconTaiLieu() {
		return daoIC.listAllIconTaiLieu();
	}

	@Override
	public void addIC(IconTaiLieu ic) {
		daoIC.addIC(ic);
	}

	@Override
	public void updateIC(IconTaiLieu ic) {
		daoIC.updateIC(ic);
	}

	@Override
	public void deleteIC(String maIcon) {
		daoIC.deleteIC(maIcon);
	}

	@Override
	public IconTaiLieu getICbyID(String maIcon) {
		return daoIC.getICbyID(maIcon);
	}

}
