package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IResetPasswordView {

	void insert(ForgotPasswordData data, Handle handle);
	void delete(ResetPasswordWithNewPasswordData data, Handle handle);

}

/*                    S.D.G.                    */
