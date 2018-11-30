package module;

public class testDemo {
	public static void main(String[] args) {
		MYSQLDatabase mysql = new MYSQLDatabase();
		mysql.delete();
		mysql.insert();
		mysql.update();
		PostgreDatabase postgre = new PostgreDatabase();
		postgre.delete();
		postgre.update();
		postgre.insert();
	}
}
