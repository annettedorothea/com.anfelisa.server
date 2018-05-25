package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

public interface IDaoProvider {

	CardDao getCardDao();

	CategoryDao getCategoryDao();

	UserDao getUserDao();

	EmailConfirmationDao getEmailConfirmationDao();

	void truncateAllViews(Handle handle);

	ResetPasswordDao getResetPasswordDao();

	CustomCategoryDao getCustomCategoryDao();

	CustomCardDao getCustomCardDao();

	CustomUserDao getCustomUserDao();

	AceDao getAceDao();
	
	void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle);
	
	void addPreparingEventToTimeline(IEvent event, String uuid);
	
	public void addEventToTimeline(IEvent event);
	
	public void addCommandToTimeline(ICommand command);
	
	void addActionToTimeline(IAction action);

	BoxDao getBoxDao();

	CustomBoxDao getCustomBoxDao();

}
