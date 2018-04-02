package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.data.UserUpdateData;

public class CustomUserDao {

	public int selectTestPoints(Handle handle, String username) {
		return handle.createQuery("select sum(points) as sum from public.result WHERE username = :username")
				.bind("username", username).mapTo(Integer.class).first();
	}

	public int selectBoxPoints(Handle handle, String username) {
		return handle
				.createQuery(
						"SELECT sum(points) as sum FROM public.scoredcard c, public.box b where c.boxid = b.boxid AND b.username = :username")
				.bind("username", username).mapTo(Integer.class).first();
	}

	public void update(Handle handle, UserUpdateData userModel) {
		Update statement = handle.createStatement(
				"UPDATE public.user SET email = :email WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("email", userModel.getEmail());
		statement.execute();
	}

	public void addCoursesToUser(Handle handle, AddCoursesData dataContainer) {
		for (String courseId : dataContainer.getCourseIdList()) {
			Update statement = handle.createStatement(
					"INSERT INTO public.studentofcourse (username, courseId) VALUES (:username, :courseId)");
			statement.bind("username", dataContainer.getCredentialsUsername());
			statement.bind("courseId", courseId);
			statement.execute();
		}
	}

	public void removeCourseFromUser(Handle handle, RemoveCourseData dataContainer) {
		Update statement = handle.createStatement(
				"DELETE FROM public.studentofcourse WHERE username = :username AND courseId = :courseId");
		statement.bind("username", dataContainer.getUsername());
		statement.bind("courseId", dataContainer.getCourseId());
		statement.execute();
	}

	public void updatePassword(Handle handle, PasswordUpdateData userModel) {
		Update statement = handle
				.createStatement("UPDATE public.user SET password = :password WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getPassword());
		statement.execute();
	}

	public void confirmEmail(Handle handle, String username) {
		Update statement = handle
				.createStatement("UPDATE public.user SET emailConfirmed = true WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public void changeUserRole(Handle handle, String username, String role) {
		Update statement = handle
				.createStatement("UPDATE public.user SET role = ':role' WHERE username = :username");
		statement.bind("username", username);
		statement.bind("role", role);
		statement.execute();
	}
	
}
