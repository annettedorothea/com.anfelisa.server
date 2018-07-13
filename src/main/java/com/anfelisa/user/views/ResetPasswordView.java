package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.ResetPasswordData;

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

	public BiConsumer<ResetPasswordData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getResetPasswordDao().deleteByToken(handle, dataContainer.getToken());
	};

}

/* S.D.G. */
