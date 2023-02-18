package com.anfelisa.user.views;

import com.anfelisa.user.models.ForgotPasswordModel;
import com.anfelisa.user.models.ResetPasswordWithNewPasswordModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ResetPasswordView implements IResetPasswordView {

	private IDaoProvider daoProvider;
	
	public ResetPasswordView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public void insert(Data<ForgotPasswordModel> data, PersistenceHandle handle) {
		daoProvider.getResetPasswordDao().insert(handle, data.getModel().getToken(), data.getModel().getUserId());
	}
	public void delete(Data<ResetPasswordWithNewPasswordModel> data, PersistenceHandle handle) {
		daoProvider.getResetPasswordDao().deleteByToken(handle, data.getModel().getToken());
	}

}

/*                    S.D.G.                    */
