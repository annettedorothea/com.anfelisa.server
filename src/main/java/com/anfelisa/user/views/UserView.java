package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.UserUpdateData;
import com.anfelisa.user.data.UsernameData;
import com.anfelisa.user.models.CustomUserDao;

public class UserView {

	private static CustomUserDao customUserDao = new CustomUserDao();

	public static BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		customUserDao.insert(handle, dataContainer);
	};

	public static BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		customUserDao.update(handle, dataContainer);
	};

	public static BiConsumer<AddCoursesData, Handle> addCourses = (dataContainer, handle) -> {
		customUserDao.addCoursesToUser(handle, dataContainer);
	};

	public static BiConsumer<RemoveCourseData, Handle> removeCourse = (dataContainer, handle) -> {
		customUserDao.removeCourseFromUser(handle, dataContainer);
	};

	public static BiConsumer<PasswordUpdateData, Handle> updatePassword = (dataContainer, handle) -> {
		customUserDao.updatePassword(handle, dataContainer);
	};

	public static BiConsumer<UsernameData, Handle> confirmEmail = (dataContainer, handle) -> {
		customUserDao.confirmEmail(handle, dataContainer.getUsername());
	};

	public static BiConsumer<ChangeUserRoleData, Handle> changeUserRole = (dataContainer, handle) -> {
		customUserDao.changeUserRole(handle, dataContainer.getUsername(), dataContainer.getRole());
	};

	public static BiConsumer<DeleteUserData, Handle> deleteUser = (dataContainer, handle) -> {
		customUserDao.deleteUser(handle, dataContainer.getDeletedUsername());
	};

}

/* S.D.G. */
