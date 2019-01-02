package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.ConfirmEmailData;

@SuppressWarnings("all")
public interface IEmailConfirmationView {

	void insert(UserRegistrationData data, Handle handle);
	void delete(ConfirmEmailData data, Handle handle);

}

/*                    S.D.G.                    */
