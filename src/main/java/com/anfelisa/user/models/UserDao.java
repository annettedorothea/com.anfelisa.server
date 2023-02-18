package com.anfelisa.user.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.auth.Roles;

import de.acegen.PersistenceHandle;

public class UserDao extends AbstractUserDao {
	public void updatePassword(PersistenceHandle handle, ResetPasswordWithNewPasswordModel data) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.user SET password = :password WHERE userid = :userid");
		statement.bind("userid", data.getUserId());
		statement.bind("password", data.getPassword());
		statement.execute();
	}

	public void confirmEmail(PersistenceHandle handle, String userId) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.user SET emailConfirmed = true WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.execute();
	}

	public void changeUserRole(PersistenceHandle handle, String userId, String role) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.user SET role = :role WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.bind("role", role);
		statement.execute();
	}

	public List<UserModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery(
				"SELECT userid, username, password, email, role, emailconfirmed FROM public.user order by username")
				.map(new UserMapper()).list();
	}

	public Integer selectAdminCount(PersistenceHandle handle) {
		Optional<Integer> optional = handle.getHandle().createQuery("SELECT count(userid) FROM public.user where role = :admin")
				.bind("admin", Roles.ADMIN).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

}

/*       S.D.G.       */
