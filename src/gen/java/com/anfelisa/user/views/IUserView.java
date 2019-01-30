package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IChangeUserRoleData;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IUserView {

	void registerUser(IUserRegistrationData data, Handle handle);
	void confirmEmail(IConfirmEmailData data, Handle handle);
	void changeUserRole(IChangeUserRoleData data, Handle handle);
	void deleteUser(IDeleteUserData data, Handle handle);
	void resetPassword(IResetPasswordWithNewPasswordData data, Handle handle);

}

/*                    S.D.G.                    */
