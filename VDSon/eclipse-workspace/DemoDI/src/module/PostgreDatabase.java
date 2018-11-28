package module;

import DI_interface.DAO;

public class PostgreDatabase implements DAO {

	@Override
	public void insert() {
		System.out.println("Postgre instert");
	}

	@Override
	public void delete() {
		System.out.println("Postgre delete");
	}

	@Override
	public void update() {
		System.out.println("Postgre update");
	}

}
