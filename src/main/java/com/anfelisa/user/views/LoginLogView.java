package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.LoginData;
import com.anfelisa.user.models.LoginLogDao;

public class LoginLogView {

	public BiConsumer<LoginData, Handle> userLoggedIn = (dataContainer, handle) -> {
		Integer id = LoginLogDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + id);
	};

}

/*                    S.D.G.                    */
