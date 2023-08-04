package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.dao.DAO;

public abstract class DemandeDAO<T> extends DAO {
	public abstract void create(T t);
	public abstract void del(T t);
	public abstract void update(T t);
	public abstract T get(String index);
	public abstract List<T> getAll();
}
