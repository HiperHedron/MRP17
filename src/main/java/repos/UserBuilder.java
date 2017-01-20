package repos;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import mappers.IMapResultSetToEntity;

public class UserBuilder implements IMapResultSetToEntity<User> {

	public User map(ResultSet rs) throws SQLException {
		User u = new User();
		u.setLogin(rs.getString("login"));
		u.setPassword(rs.getString("password"));
		u.setId(rs.getInt("id"));
		return u;
	}

}
