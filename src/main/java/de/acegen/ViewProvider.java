package de.acegen;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ReinforceCardView;
import com.anfelisa.box.views.RootCategoryView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.UserAccessToCategoryView;
import com.anfelisa.card.views.CardView;
import com.anfelisa.category.views.BoxInvitationView;
import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.views.UserAccessToCategoryInvitationView;
import com.anfelisa.user.views.EmailConfirmationView;
import com.anfelisa.user.views.EmailView;
import com.anfelisa.user.views.ResetPasswordView;
import com.anfelisa.user.views.UserRootCategoryView;
import com.anfelisa.user.views.UserView;

public class ViewProvider extends AbstractViewProvider {

	public BoxView boxView;
	public CardView cardView;
	public ScheduledCardView scheduledCardView;
	public CategoryView categoryView;
	public EmailConfirmationView emailConfirmationView;
	public UserView userView;
	public EmailView emailView;
	public ResetPasswordView resetPasswordView;
	public ReinforceCardView reinforceCardView;
	public RootCategoryView rootCategoryView;
	public UserAccessToCategoryView userAccessToCategoryView;
	public UserRootCategoryView userRootCategoryView;
	public UserAccessToCategoryInvitationView userAccessToCategoryInvitationView;
	public BoxInvitationView boxInvitationView;

	public static ViewProvider create(IDaoProvider daoProvider, CustomAppConfiguration customAppConfiguration) {
		return new ViewProvider(daoProvider, new EmailService(customAppConfiguration));
	}

	public ViewProvider(IDaoProvider daoProvider, EmailService emailService) {
		boxView = new BoxView(daoProvider);
		cardView = new CardView(daoProvider);
		scheduledCardView = new ScheduledCardView(daoProvider);
		categoryView = new CategoryView(daoProvider);
		emailConfirmationView = new EmailConfirmationView(daoProvider);
		userView = new UserView(daoProvider);
		emailView = new EmailView(emailService);
		resetPasswordView = new ResetPasswordView(daoProvider);
		reinforceCardView = new ReinforceCardView(daoProvider);
		rootCategoryView = new RootCategoryView(daoProvider);
		userAccessToCategoryView = new UserAccessToCategoryView(daoProvider);
		userRootCategoryView = new UserRootCategoryView(daoProvider);
		userAccessToCategoryInvitationView = new UserAccessToCategoryInvitationView(daoProvider);
		boxInvitationView = new BoxInvitationView(daoProvider);
	}

}
