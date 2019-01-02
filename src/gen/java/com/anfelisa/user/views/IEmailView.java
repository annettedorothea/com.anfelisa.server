package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.UserRegistrationData;

@SuppressWarnings("all")
public interface IEmailView {

	void sendForgotPasswordEmail(ForgotPasswordData data, Handle handle);
	void sendRegistrationEmail(UserRegistrationData data, Handle handle);

}

/*                    S.D.G.                    */
