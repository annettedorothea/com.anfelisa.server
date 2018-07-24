package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.data.ResetPasswordData;
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

	public BiConsumer<EmailConfirmationData, Handle> confirmEmail = (dataContainer, handle) -> {
		daoProvider.getCustomUserDao().confirmEmail(handle, dataContainer.getUserId());
	};

	public BiConsumer<ChangeUserRoleData, Handle> changeUserRole = (dataContainer, handle) -> {
		daoProvider.getCustomUserDao().changeUserRole(handle, dataContainer.getUserId(), dataContainer.getRole());
	};

	public BiConsumer<DeleteUserData, Handle> deleteUser = (dataContainer, handle) -> {
		daoProvider.getUserDao().deleteByUsername(handle, dataContainer.getDeletedUsername());
	};

	public BiConsumer<ResetPasswordData, Handle> resetPassword = (dataContainer, handle) -> {
		daoProvider.getCustomUserDao().updatePassword(handle, dataContainer);
	};

}

/* S.D.G. */
