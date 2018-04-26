package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScoredCardDao;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;

public class AppUtils {

	private static BoxDao boxDao = new BoxDao();
	private static CardDao cardDao = new CardDao();
	private static LoginLogDao loginLogDao = new LoginLogDao();
	private static ScheduledCardDao scheduledCardDao = new ScheduledCardDao();
	private static ScoredCardDao scoredCardDao = new ScoredCardDao();
	private static UserDao userDao = new UserDao();

	public static void truncateAllViews(Handle handle) {
		//scoredCardDao.truncate(handle);
		//scheduledCardDao.truncate(handle);
		//cardDao.truncate(handle);
		loginLogDao.truncate(handle);
		//boxDao.truncate(handle);
		userDao.truncate(handle);
	}

}

