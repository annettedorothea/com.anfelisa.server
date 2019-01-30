package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.IConfirmEmailData;

@SuppressWarnings("all")
public interface IEmailConfirmationView {

	void insert(IUserRegistrationData data, Handle handle);
	void delete(IConfirmEmailData data, Handle handle);

}

/*                    S.D.G.                    */
