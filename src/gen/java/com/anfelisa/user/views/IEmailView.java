package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IUserRegistrationData;

@SuppressWarnings("all")
public interface IEmailView {

	void sendForgotPasswordEmail(IForgotPasswordData data, Handle handle);
	void sendRegistrationEmail(IUserRegistrationData data, Handle handle);

}

/*                    S.D.G.                    */
