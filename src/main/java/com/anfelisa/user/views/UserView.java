package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;
import com.anfelisa.user.data.UserRegistrationData;

public class UserView {

	private IDaoProvider daoProvider;

	public UserView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		daoProvider.getUserDao().insert(handle, dataContainer);
	};

	public BiConsumer<ConfirmEmailData, Handle> confirmEmail = (dataContainer, handle) -> {
		daoProvider.getUserDao().confirmEmail(handle, dataContainer.getUserId());
	};

	public BiConsumer<ChangeUserRoleData, Handle> changeUserRole = (dataContainer, handle) -> {
		daoProvider.getUserDao().changeUserRole(handle, dataContainer.getUserId(), dataContainer.getRole());
	};

	public BiConsumer<DeleteUserData, Handle> deleteUser = (dataContainer, handle) -> {
		daoProvider.getUserDao().deleteByUsername(handle, dataContainer.getUsernameToBeDeleted());
	};

	public BiConsumer<ResetPasswordWithNewPasswordData, Handle> resetPassword = (dataContainer, handle) -> {
		daoProvider.getUserDao().updatePassword(handle, dataContainer);
	};

}

/* S.D.G. */
