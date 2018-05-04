package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.data.ResetPasswordData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.UserUpdateData;

public class UserView {

	private DaoProvider daoProvider;

	public UserView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		daoProvider.userDao.insert(handle, dataContainer);
	};

	public BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		daoProvider.customUserDao.update(handle, dataContainer);
	};

	public BiConsumer<EmailConfirmationData, Handle> confirmEmail = (dataContainer, handle) -> {
		daoProvider.customUserDao.confirmEmail(handle, dataContainer.getUserId());
	};

	public BiConsumer<ChangeUserRoleData, Handle> changeUserRole = (dataContainer, handle) -> {
		daoProvider.customUserDao.changeUserRole(handle, dataContainer.getUserId(), dataContainer.getRole());
	};

	public BiConsumer<DeleteUserData, Handle> deleteUser = (dataContainer, handle) -> {
		daoProvider.userDao.deleteByUsername(handle, dataContainer.getDeletedUsername());
	};

	public BiConsumer<ResetPasswordData, Handle> resetPassword = (dataContainer, handle) -> {
		daoProvider.customUserDao.updatePassword(handle, dataContainer);
	};

}

/* S.D.G. */
