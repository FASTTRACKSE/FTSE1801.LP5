package fasttrackse.ffse1703.fbms.dao.security;

import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

public interface UserAccountDao {
	public UserAccount loadUserByUsername(final String username);
}