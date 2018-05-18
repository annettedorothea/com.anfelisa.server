package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {

	private final CardDao cardDao = new CardDao();

	private final CustomCardDao customCardDao = new CustomCardDao();

	// private final BoxDao boxDao = new BoxDao();

	// private final CustomBoxDao customBoxDao = new CustomBoxDao();

	// private final ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	private final CategoryDao categoryDao = new CategoryDao();

	private final CustomCategoryDao customCategoryDao = new CustomCategoryDao();

	private final CustomUserDao customUserDao = new CustomUserDao();

	private final UserDao userDao = new UserDao();

	private final ResetPasswordDao resetPasswordDao = new ResetPasswordDao();

	// private final CustomScheduledCardDao customScheduledCardDao = new
	// CustomScheduledCardDao();

	// private final ScoredCardDao scoredCardDao = new ScoredCardDao();

	private final EmailConfirmationDao emailConfirmationDao = new EmailConfirmationDao();

	@Override
	public CardDao getCardDao() {
		return cardDao;
	}

	@Override
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public EmailConfirmationDao getEmailConfirmationDao() {
		return emailConfirmationDao;
	}

	@Override
	public ResetPasswordDao getResetPasswordDao() {
		return resetPasswordDao;
	}

	@Override
	public CustomCategoryDao getCustomCategoryDao() {
		return customCategoryDao;
	}

	@Override
	public CustomCardDao getCustomCardDao() {
		return customCardDao;
	}

	@Override
	public CustomUserDao getCustomUserDao() {
		return customUserDao;
	}

	@Override
	public void truncateAllViews(Handle handle) {
		// scheduledCardDao.truncate(handle);
		// scoredCardDao.truncate(handle);
		cardDao.truncate(handle);
		// boxDao.truncate(handle);
		categoryDao.truncate(handle);
		resetPasswordDao.truncate(handle);
		emailConfirmationDao.truncate(handle);
		userDao.truncate(handle);
	}

}