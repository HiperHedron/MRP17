package repo;

import java.sql.Connection;

import domain.UserRoles;
import repo.IRepositoryCatalog;
import repos.UserBuilder;
import repos.UserRepository;
import unitofwork.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{
	
	private Connection connection;
	private IUnitOfWork uow;
	
	public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
		super();
		this.connection = connection;
		this.uow = uow;
	}

	public IUserRepository getUsers() {
		return new UserRepository(connection, new UserBuilder(), uow);
	}

	public IRepository<UserRoles> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public void commit() {
		// TODO Auto-generated method stub
		
	}

}
