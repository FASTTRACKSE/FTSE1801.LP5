package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;

public interface IconService {
	public List<IconTaiLieu> listAllIconTaiLieu();

	public void addIC(IconTaiLieu ic);

	public void updateIC(IconTaiLieu ic);

	public void deleteIC(String maIcon);

	public IconTaiLieu getICbyID(String maIcon);
}
