package unitofwork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import domain.Entity;
import domain.EntityState;

public class UnitOfWork implements IUnitOfWork {
	
	private Connection connection;

	public UnitOfWork(Connection connection) {
		super();
		this.setConnection(connection);
		
		try {
			connection.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Map<Entity, IUnitOfWorkRepository> entities = 
			new LinkedHashMap<Entity, IUnitOfWorkRepository>();
	
	public void saveChanges() {
		for(Entity entity: entities.keySet()){
			
			switch(entity.getState()){
			
			case Deleted:
				entities.get(entity).persistDelete(entity);
				break;
			case Modified:
				entities.get(entity).persistUpdate(entity);
				break;
			case New:
				entities.get(entity).persistAdd(entity);
				break;
			default:
				break;
			}
		}try {
			connection.commit();
			entities.clear();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void undo() {
		try {
			connection.rollback();
			entities.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void markAsNew(Entity entity, IUnitOfWorkRepository repo) {
		entity.setState(EntityState.New);
		entities.put(entity, repo);
		
	}

	public void markAsDeleted(Entity entity, IUnitOfWorkRepository repo) {
		entity.setState(EntityState.Deleted);
		entities.put(entity, repo);
		
	}

	public void markAsChanged(Entity entity, IUnitOfWorkRepository repo) {
		entity.setState(EntityState.Modified);
		entities.put(entity, repo);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
