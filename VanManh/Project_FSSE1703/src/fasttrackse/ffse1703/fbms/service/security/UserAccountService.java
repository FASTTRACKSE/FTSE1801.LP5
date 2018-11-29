package fasttrackse.ffse1703.fbms.service.security;

import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

public interface UserAccountService {
	public UserAccount loadUserByUsername(final String username);
}
