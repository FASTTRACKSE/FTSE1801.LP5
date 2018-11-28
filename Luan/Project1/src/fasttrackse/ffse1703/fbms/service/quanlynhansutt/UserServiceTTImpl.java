package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.UserAccountDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.UserAccountTT;

@Service
public class UserServiceTTImpl implements UserServiceTT {
	@Autowired
	private UserAccountDaoTT userDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserAccountTT user = userDao.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("No user found with id:" + username);
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(username, user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, user.getAuthorities());
	}
}