package demo;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public static List<User> listUser() {
		List<User> list = new ArrayList<>();
		User user = new User("1", "Tran Duy Luan", "22", "23 Nguyen Suy");
		User user1 = new User("2", "Tran Duy Luan", "24", "23 Nguyen Suy");
		User user2 = new User("3", "Tran Duy Luan", "23", "23 Nguyen Suy");
		list.add(user);
		list.add(user1);
		list.add(user2);
		return list;
	}
}
