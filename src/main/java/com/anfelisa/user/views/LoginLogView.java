package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.LoginData;
import com.anfelisa.user.models.LoginLogDao;

public class LoginLogView {

	private LoginLogDao loginLogDao = new LoginLogDao();

	public BiConsumer<LoginData, Handle> userLoggedIn = (dataContainer, handle) -> {
		Integer id = loginLogDao.insert(handle, dataContainer);
		dataContainer.setCreatedId("" + id);
	};

}

/* S.D.G. */
