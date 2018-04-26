package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.models.UserDao;

public class AppUtils {

	private static UserDao userDao = new UserDao();

	public static void truncateAllViews(Handle handle) {
		userDao.truncate(handle);
	}

}

