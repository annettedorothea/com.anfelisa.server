package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public class ResetPasswordView {

	private IDaoProvider daoProvider;

	public ResetPasswordView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<ForgotPasswordData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getResetPasswordDao().insert(handle, dataContainer);
	};

	public BiConsumer<ResetPasswordWithNewPasswordData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getResetPasswordDao().deleteByToken(handle, dataContainer.getToken());
	};

}

/* S.D.G. */
