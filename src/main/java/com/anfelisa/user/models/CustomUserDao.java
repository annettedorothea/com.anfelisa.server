package com.anfelisa.user.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.ResetPasswordData;

public class CustomUserDao {

	public int selectTestPoints(Handle handle, String username) {
		Optional<Integer> optional = handle
				.createQuery("select sum(points) as sum from public.result WHERE username = :username")
				.bind("username", username).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public int selectBoxPoints(Handle handle, String username) {
		Optional<Integer> optional = handle.createQuery(
				"SELECT sum(points) as sum FROM public.scoredcard c, public.box b where c.boxid = b.boxid AND b.username = :username")
				.bind("username", username).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updatePassword(Handle handle, ResetPasswordData data) {
		Update statement = handle.createUpdate("UPDATE public.user SET password = :password WHERE userid = :userid");
		statement.bind("userid", data.getUserId());
		statement.bind("password", data.getPassword());
		statement.execute();
	}

	public void confirmEmail(Handle handle, String userId) {
		Update statement = handle.createUpdate("UPDATE public.user SET emailConfirmed = true WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.execute();
	}

	public void changeUserRole(Handle handle, String userId, String role) {
		Update statement = handle.createUpdate("UPDATE public.user SET role = :role WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.bind("role", role);
		statement.execute();
	}

	public List<IUserModel> selectAll(Handle handle) {
		return handle.createQuery(
				"SELECT userid, username, password, email, role, emailconfirmed FROM public.user order by username")
				.map(new UserMapper()).list();
	}

	public Integer selectAdminCount(Handle handle) {
		Optional<Integer> optional = handle.createQuery("SELECT count(userid) FROM public.user where role = :admin")
				.bind("admin", Roles.ADMIN).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void insert(Handle handle, IUserRegistrationData userModel) {
		Update statement = handle.createUpdate(
				"INSERT INTO public.user (username, password, email, role, emailconfirmed, deleted) VALUES (:username, :password, :email, :role, false, false)");
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getPassword());
		statement.bind("email", userModel.getEmail());
		statement.bind("role", userModel.getRole());
		statement.execute();
	}

}
