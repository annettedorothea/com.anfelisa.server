package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

public class ResetPasswordView implements IResetPasswordView {

	private IDaoProvider daoProvider;
	
	public ResetPasswordView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public void insert(IForgotPasswordData data, Handle handle) {
		daoProvider.getResetPasswordDao().insert(handle, data);
	}
	public void delete(IResetPasswordWithNewPasswordData data, Handle handle) {
		daoProvider.getResetPasswordDao().deleteByToken(handle, data.getToken());
	}

}

/*                    S.D.G.                    */
