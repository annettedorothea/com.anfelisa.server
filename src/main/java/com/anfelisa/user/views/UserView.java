package com.anfelisa.user.views;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
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

	public void registerUser(IUserRegistrationData data, PersistenceHandle handle) {
		daoProvider.getUserDao().insert(handle, data);
	}

	public void confirmEmail(IConfirmEmailData data, PersistenceHandle handle) {
		daoProvider.getUserDao().confirmEmail(handle, data.getUserId());
	}

	public void changeUserRole(IChangeUserRoleData data, PersistenceHandle handle) {
		daoProvider.getUserDao().changeUserRole(handle, data.getEditedUserId(), data.getNewRole());
	}

	public void deleteUser(IDeleteUserData data, PersistenceHandle handle) {
		daoProvider.getUserDao().deleteByUsername(handle, data.getUsernameToBeDeleted());
	}

	public void resetPassword(IResetPasswordWithNewPasswordData data, PersistenceHandle handle) {
		daoProvider.getUserDao().updatePassword(handle, data);
	}
}

/* S.D.G. */
