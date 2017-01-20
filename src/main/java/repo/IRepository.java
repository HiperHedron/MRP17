package repo;

public interface IRepository<TEntity> {
	
	public void count();
	public void modify(TEntity entity);
	public void delete(TEntity entity);
	public void add(TEntity entity);
	public void allOnPage(PagingInfo page);
	public TEntity withId(int id);
}
