package ci.gouv.dgmg.stam.dao;

public abstract class NumberIndexDAO<T> extends DAO<T> {

	public abstract T get(long index);
}
