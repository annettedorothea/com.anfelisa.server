package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;
import com.anfelisa.user.data.UserRegistrationData;

public class UserView implements IUserView {

	private IDaoProvider daoProvider;

	public UserView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void registerUser(UserRegistrationData data, Handle handle) {
		daoProvider.getUserDao().insert(handle, data);
	}

	public void confirmEmail(ConfirmEmailData data, Handle handle) {
		daoProvider.getUserDao().confirmEmail(handle, data.getUserId());
	}

	public void changeUserRole(ChangeUserRoleData data, Handle handle) {
		daoProvider.getUserDao().changeUserRole(handle, data.getUserId(), data.getRole());
	}

	public void deleteUser(DeleteUserData data, Handle handle) {
		daoProvider.getUserDao().deleteByUsername(handle, data.getUsernameToBeDeleted());
	}

	public void resetPassword(ResetPasswordWithNewPasswordData data, Handle handle) {
		daoProvider.getUserDao().updatePassword(handle, data);
	}
}

/* S.D.G. */
