package ci.gouv.dgmg.stam.dao.user;

import java.util.List;

import ci.gouv.dgmg.stam.common.DAO;

public abstract class UserDAO<T> extends DAO {
	public abstract void create(T t);
	public abstract void del(T t);
	public abstract void update(T t);
	public abstract T get(String s);
	public abstract List<T> getAll();
	public abstract void setPassword(T agent,String pwd);
}
