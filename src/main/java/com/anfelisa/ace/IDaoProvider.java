package com.anfelisa.ace;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.ReinforceCardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.category.models.UserAccessToCategoryDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

public interface IDaoProvider {

	CardDao getCardDao();

	CategoryDao getCategoryDao();

	UserDao getUserDao();

	EmailConfirmationDao getEmailConfirmationDao();

	void truncateAllViews(PersistenceHandle handle);

	ResetPasswordDao getResetPasswordDao();

	AceDao getAceDao();
	
	BoxDao getBoxDao();

	ScheduledCardDao getScheduledCardDao();
	
	ReinforceCardDao getReinforceCardDao();
	
	UserAccessToCategoryDao getUserAccessToCategoryDao();

}
