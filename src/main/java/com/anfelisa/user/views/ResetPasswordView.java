package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;

public class ResetPasswordView implements IResetPasswordView {

	private IDaoProvider daoProvider;
	
	public ResetPasswordView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public void insert(ForgotPasswordData data, Handle handle) {
		daoProvider.getResetPasswordDao().insert(handle, data);
	}
	public void delete(ResetPasswordWithNewPasswordData data, Handle handle) {
		daoProvider.getResetPasswordDao().deleteByToken(handle, data.getToken());
	}

}

/*                    S.D.G.                    */
