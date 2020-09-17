/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractUserDao {
	
	public void insert(PersistenceHandle handle, IUserModel userModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"user\" (userid, username, password, email, role, emailconfirmed) VALUES (:userid, :username, :password, :email, :role, :emailconfirmed)");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.execute();
	}
	
	
	public void updateByUserId(PersistenceHandle handle, IUserModel userModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"user\" SET userid = :userid, username = :username, password = :password, email = :email, role = :role, emailconfirmed = :emailconfirmed WHERE userid = :userid");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("userid",  userModel.getUserId()  );
		statement.execute();
	}

	public void deleteByUserId(PersistenceHandle handle, String userId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"user\" WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.execute();
	}

	public IUserModel selectByUserId(PersistenceHandle handle, String userId) {
		Optional<IUserModel> optional = handle.getHandle().createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\" WHERE userid = :userid")
			.bind("userid", userId)
			.map(new UserMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	public void updateByUsername(PersistenceHandle handle, IUserModel userModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"user\" SET userid = :userid, username = :username, password = :password, email = :email, role = :role, emailconfirmed = :emailconfirmed WHERE username = :username");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("username",  userModel.getUsername()  );
		statement.execute();
	}

	public void deleteByUsername(PersistenceHandle handle, String username) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"user\" WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public IUserModel selectByUsername(PersistenceHandle handle, String username) {
		Optional<IUserModel> optional = handle.getHandle().createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\" WHERE username = :username")
			.bind("username", username)
			.map(new UserMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IUserModel selectByPrimaryKey(PersistenceHandle handle, String userId) {
		Optional<IUserModel> optional = handle.getHandle().createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\" WHERE userid = :userid")
			.bind("userid", userId)
			.map(new UserMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"user\"";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<IUserModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\"")
			.map(new UserMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"user\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



