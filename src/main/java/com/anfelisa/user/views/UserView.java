package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.IChangeUserRoleData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;
import com.anfelisa.user.data.IUserRegistrationData;

public class UserView implements IUserView {

	private IDaoProvider daoProvider;

	public UserView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void registerUser(IUserRegistrationData data, Handle handle) {
		daoProvider.getUserDao().insert(handle, data);
	}

	public void confirmEmail(IConfirmEmailData data, Handle handle) {
		daoProvider.getUserDao().confirmEmail(handle, data.getUserId());
	}

	public void changeUserRole(IChangeUserRoleData data, Handle handle) {
		daoProvider.getUserDao().changeUserRole(handle, data.getEditedUserId(), data.getNewRole());
	}

	public void deleteUser(IDeleteUserData data, Handle handle) {
		daoProvider.getUserDao().deleteByUsername(handle, data.getUsernameToBeDeleted());
	}

	public void resetPassword(IResetPasswordWithNewPasswordData data, Handle handle) {
		daoProvider.getUserDao().updatePassword(handle, data);
	}
}

/* S.D.G. */
