package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.ChangeUserRoleData;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IUserView {

	void registerUser(UserRegistrationData data, Handle handle);
	void confirmEmail(ConfirmEmailData data, Handle handle);
	void changeUserRole(ChangeUserRoleData data, Handle handle);
	void deleteUser(DeleteUserData data, Handle handle);
	void resetPassword(ResetPasswordWithNewPasswordData data, Handle handle);

}

/*                    S.D.G.                    */
