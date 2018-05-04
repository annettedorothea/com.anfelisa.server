package com.anfelisa.ace;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScoredCardDao;
import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.CardDao;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.ResetPasswordDao;
import com.anfelisa.user.models.UserDao;

public class DaoProvider extends AbstractDaoProvider {

	public final CardDao cardDao = new CardDao();

	public final CustomCardDao customCardDao = new CustomCardDao();

	public final BoxDao boxDao = new BoxDao();

	public final CustomBoxDao customBoxDao = new CustomBoxDao();

	public final ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	public final CategoryDao categoryDao = new CategoryDao();

	public final CustomCategoryDao customCategoryDao = new CustomCategoryDao();

	public final CustomUserDao customUserDao = new CustomUserDao();

	public final UserDao userDao = new UserDao();

	public final ResetPasswordDao resetPasswordDao = new ResetPasswordDao();

	public final CustomScheduledCardDao customScheduledCardDao = new CustomScheduledCardDao();

	public final ScoredCardDao scoredCardDao = new ScoredCardDao();

	public final EmailConfirmationDao emailConfirmationDao = new EmailConfirmationDao();
}
