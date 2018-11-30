package module;

import DI_interface.DAO;

public class MYSQLDatabase implements DAO {

	@Override
	public void insert() {
		System.out.println("MySQL instert");
	}

	@Override
	public void delete() {
		System.out.println("MySQL delete");
	}

	@Override
	public void update() {
		System.out.println("MySQL update");
	}

}
