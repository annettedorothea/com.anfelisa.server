package de.acegen;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.ReinforceCardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.category.models.UserAccessToCategoryDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

import de.acegen.AbstractDaoProvider;
import de.acegen.PersistenceHandle;

public class DaoProvider extends AbstractDaoProvider implements IDaoProvider {

	private final CardDao cardDao = new CardDao();

	private final BoxDao boxDao = new BoxDao();

	private final ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	private final CategoryDao categoryDao = new CategoryDao();

	private final UserDao userDao = new UserDao();

	private final ResetPasswordDao resetPasswordDao = new ResetPasswordDao();

	private final EmailConfirmationDao emailConfirmationDao = new EmailConfirmationDao();
	
	private final ReinforceCardDao reinforceCardDao = new ReinforceCardDao();

	private final UserAccessToCategoryDao userAccessToCategoryDao = new UserAccessToCategoryDao();
	
	public static IDaoProvider create() {
		return new DaoProvider();
	}

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
	public BoxDao getBoxDao() {
		return boxDao;
	}

	@Override
	public ScheduledCardDao getScheduledCardDao() {
		return scheduledCardDao;
	}

	@Override
	public ReinforceCardDao getReinforceCardDao() {
		return reinforceCardDao;
	}

	@Override
	public UserAccessToCategoryDao getUserAccessToCategoryDao() {
		return userAccessToCategoryDao;
	}

	@Override
	public void truncateAllViews(PersistenceHandle handle) {
		resetPasswordDao.truncate(handle);
		emailConfirmationDao.truncate(handle);
		reinforceCardDao.truncate(handle);
		scheduledCardDao.truncate(handle);
		cardDao.truncate(handle);
		boxDao.truncate(handle);
		categoryDao.truncate(handle);
		userAccessToCategoryDao.truncate(handle);
		userDao.truncate(handle);
		
		aceDao.truncateTimelineTable(handle);
	}

}
