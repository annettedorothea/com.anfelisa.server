package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IResetPasswordView {

	void insert(IForgotPasswordData data, Handle handle);
	void delete(IResetPasswordWithNewPasswordData data, Handle handle);

}

/*                    S.D.G.                    */
