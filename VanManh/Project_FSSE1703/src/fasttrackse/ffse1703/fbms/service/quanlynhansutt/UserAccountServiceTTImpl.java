package fasttrackse.ffse1703.fbms.service.quanlynhansutt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.UserAccountDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.UserAccountTT;



@Service
public class UserAccountServiceTTImpl implements UserAccountServiceTT {
	@Autowired
	private UserAccountDaoTT userAccountDao;

	@Override
	@Transactional
	public UserAccountTT loadUserByUsername(String username) {

		return this.userAccountDao.loadUserByUsername(username);
	}

}
