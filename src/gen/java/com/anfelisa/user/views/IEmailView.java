/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IUserRegistrationData;

@SuppressWarnings("all")
public interface IEmailView {

	void sendForgotPasswordEmail(IForgotPasswordData data, PersistenceHandle handle);
	void sendRegistrationEmail(IUserRegistrationData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



