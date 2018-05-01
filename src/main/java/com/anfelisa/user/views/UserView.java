package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.data.ResetPasswordData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.UserUpdateData;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.UserDao;

public class UserView {

	private static CustomUserDao customUserDao = new CustomUserDao();
	private static UserDao userDao = new UserDao();

	public static BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		userDao.insert(handle, dataContainer);
	};

	public static BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		customUserDao.update(handle, dataContainer);
	};

	public static BiConsumer<EmailConfirmationData, Handle> confirmEmail = (dataContainer, handle) -> {
		customUserDao.confirmEmail(handle, dataContainer.getUserId());
	};

	public static BiConsumer<ChangeUserRoleData, Handle> changeUserRole = (dataContainer, handle) -> {
		customUserDao.changeUserRole(handle, dataContainer.getUserId(), dataContainer.getRole());
	};

	public static BiConsumer<DeleteUserData, Handle> deleteUser = (dataContainer, handle) -> {
		userDao.deleteByUsername(handle, dataContainer.getDeletedUsername());
	};

	public static BiConsumer<ResetPasswordData, Handle> resetPassword = (dataContainer, handle) -> {
		customUserDao.updatePassword(handle, dataContainer);
	};
	
}

/* S.D.G. */
