package fasttrackse.ftse1801.fbms.service.security;

import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public interface UserAccountService {
	public UserAccount loadUserByUsername(final String username);
}
