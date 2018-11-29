package fasttrackse.ftse1801.fbms.dao.security;

import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public interface UserAccountDao {
	public UserAccount loadUserByUsername(final String username);
}