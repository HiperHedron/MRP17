package repo;

import domain.UserRoles;

public interface IRepositoryCatalog {

	public IUserRepository getUsers();
	public IRepository<UserRoles> getRoles();
	public void commit();
}
