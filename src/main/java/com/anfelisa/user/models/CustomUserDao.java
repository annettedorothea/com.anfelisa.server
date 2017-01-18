package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.data.UserUpdateData;

public class CustomUserDao {

	public int selectTestPoints(Handle handle, String username, String schema) {
		return handle.createQuery("select sum(points) as sum from " + schema + ".result WHERE username = :username")
				.bind("username", username).mapTo(Integer.class).first();
	}

	public int selectBoxPoints(Handle handle, String username, String schema) {
		return handle
				.createQuery("SELECT sum(points) as sum FROM " + schema + ".scoredcard c, " + schema
						+ ". box b where c.boxid = b.boxid AND b.username = :username")
				.bind("username", username).mapTo(Integer.class).first();
	}

	public void update(Handle handle, UserUpdateData userModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema
				+ ".user SET name = :name, prename = :prename, email = :email WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("name", userModel.getName());
		statement.bind("prename", userModel.getPrename());
		statement.bind("email", userModel.getEmail());
		statement.execute();
	}

	public void addCoursesToUser(Handle handle, AddCoursesData dataContainer, String schema) {
		for (Integer courseId : dataContainer.getCourseIdList()) {
			Update statement = handle.createStatement(
					"INSERT INTO " + schema + ".studentofcourse (username, courseId) VALUES (:username, :courseId)");
			statement.bind("username", dataContainer.getUsername());
			statement.bind("courseId", courseId);
			statement.execute();
		}
	}

	public void removeCourseFromUser(Handle handle, RemoveCourseData dataContainer, String schema) {
		Update statement = handle.createStatement(
				"DELETE FROM " + schema + ".studentofcourse WHERE username = :username AND courseId = :courseId");
		statement.bind("username", dataContainer.getUsername());
		statement.bind("courseId", dataContainer.getCourseId());
		statement.execute();
	}

	public void updatePassword(Handle handle, PasswordUpdateData userModel, String schema) {
		Update statement = handle
				.createStatement("UPDATE " + schema + ".user SET password = :password WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getPassword());
		statement.execute();
	}

	public void confirmEmail(Handle handle, String username, String schema) {
		Update statement = handle
				.createStatement("UPDATE " + schema + ".user SET emailConfirmed = true WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

}
