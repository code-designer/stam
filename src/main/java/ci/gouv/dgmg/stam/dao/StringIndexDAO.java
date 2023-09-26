package ci.gouv.dgmg.stam.dao;

public abstract class StringIndexDAO<T> extends DAO<T> {

	public abstract T get(String index);
}
