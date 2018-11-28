package di;

import java.util.List;

public interface ITFDao{
	public <E> List<E> select();
	public boolean update();
}
