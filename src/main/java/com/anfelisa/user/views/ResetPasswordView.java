package com.anfelisa.user.views;

import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ResetPasswordView implements IResetPasswordView {

	private IDaoProvider daoProvider;
	
	public ResetPasswordView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public void insert(IForgotPasswordData data, PersistenceHandle handle) {
		daoProvider.getResetPasswordDao().insert(handle, data);
	}
	public void delete(IResetPasswordWithNewPasswordData data, PersistenceHandle handle) {
		daoProvider.getResetPasswordDao().deleteByToken(handle, data.getToken());
	}

}

/*                    S.D.G.                    */
