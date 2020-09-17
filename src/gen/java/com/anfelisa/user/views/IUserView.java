/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IChangeUserRoleData;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IUserView {

	void registerUser(IUserRegistrationData data, PersistenceHandle handle);
	void confirmEmail(IConfirmEmailData data, PersistenceHandle handle);
	void changeUserRole(IChangeUserRoleData data, PersistenceHandle handle);
	void deleteUser(IDeleteUserData data, PersistenceHandle handle);
	void resetPassword(IResetPasswordWithNewPasswordData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



