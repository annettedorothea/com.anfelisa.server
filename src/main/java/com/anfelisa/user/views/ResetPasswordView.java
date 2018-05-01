package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.ResetPasswordData;
import com.anfelisa.user.models.ResetPasswordDao;

@SuppressWarnings("all")
public class ResetPasswordView {

	private static ResetPasswordDao resetPasswordDao = new ResetPasswordDao();
	
	public static BiConsumer<ForgotPasswordData, Handle> insert = (dataContainer, handle) -> {
		resetPasswordDao.insert(handle, dataContainer);
	};

	public static BiConsumer<ResetPasswordData, Handle> delete = (dataContainer, handle) -> {
		resetPasswordDao.deleteByToken(handle, dataContainer.getToken());
	};
	
}

/*                    S.D.G.                    */
