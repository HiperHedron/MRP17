package crudTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import domain.User;
import mappers.IMapResultSetToEntity;
import mappers.UserMapper;
import repos.UserRepository;
import repo.IRepositoryCatalog;
import repo.RepositoryCatalog;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;



	public class UserRepositoryCRUDTest {
		Connection	connection;
		
		@BeforeTest
		public void before() throws SQLException{
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		}

		@Test
		public void testAdd() {
			IMapResultSetToEntity<User> mapper = new UserMapper();
			IUnitOfWork uow = new UnitOfWork(connection);
			UserRepository repo = new UserRepository(connection, mapper, uow);
			
			User u = new User();
			User u2 = new User();
			u.setId(222);
			u.setLogin("Luxor222");
			u.setPassword("Test1234@222");
			u2.setId(2333);
			u2.setLogin("Luxor2223");
			u2.setPassword("Test1234@2223");
			
			//repo.persistInsert(u);
			repo.add(u);
			repo.add(u2);

			//uow.saveChanges();
			//repo.persistInsert(u2);
			uow.saveChanges();
		}
		
		@Test
		public void catalogTEst() {
			try {
				User u3 = new User();
				u3.setLogin("Xerxes");
				u3.setPassword("Password1");
				//u3.setRolesPermissions();
			Connection	connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			
			//IMapResultSetToEntity<User> mapper = new UserMapper();
			IUnitOfWork uow = new UnitOfWork(connection);
			
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			
			catalog.getUsers().add(u3);
			uow.saveChanges();
			//List<User> usersFromDB = catalog.getUsers();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

