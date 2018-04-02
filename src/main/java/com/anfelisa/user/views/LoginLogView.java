package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.LoginData;
import com.anfelisa.user.models.LoginLogDao;

public class LoginLogView {

	private static LoginLogDao loginLogDao = new LoginLogDao();

	public static BiConsumer<LoginData, Handle> userLoggedIn = (dataContainer, handle) -> {
		loginLogDao.insert(handle, dataContainer);
	};

}

/* S.D.G. */
