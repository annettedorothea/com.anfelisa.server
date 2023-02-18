package com.anfelisa.user.views;

import com.anfelisa.user.models.ChangeUserRoleModel;
import com.anfelisa.user.models.ConfirmEmailModel;
import com.anfelisa.user.models.DeleteUserModel;
import com.anfelisa.user.models.ResetPasswordWithNewPasswordModel;
import com.anfelisa.user.models.UserRegistrationModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class UserView implements IUserView {

	private IDaoProvider daoProvider;

	public UserView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insertUser(Data<UserRegistrationModel> data, PersistenceHandle handle) {
		daoProvider.getUserDao().insert(handle, data.getModel().mapToUserModel());
	}

	public void confirmEmail(Data<ConfirmEmailModel> data, PersistenceHandle handle) {
		daoProvider.getUserDao().confirmEmail(handle, data.getModel().getUserId());
	}

	public void changeUserRole(Data<ChangeUserRoleModel> data, PersistenceHandle handle) {
		daoProvider.getUserDao().changeUserRole(handle, data.getModel().getEditedUserId(), data.getModel().getNewRole());
	}

	public void deleteUser(Data<DeleteUserModel> data, PersistenceHandle handle) {
		daoProvider.getUserDao().deleteByUsername(handle, data.getModel().getUsernameToBeDeleted());
	}

	public void resetPassword(Data<ResetPasswordWithNewPasswordModel> data, PersistenceHandle handle) {
		daoProvider.getUserDao().updatePassword(handle, data.getModel());
	}
}

/* S.D.G. */
