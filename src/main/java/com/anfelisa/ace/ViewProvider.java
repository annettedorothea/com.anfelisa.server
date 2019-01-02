package com.anfelisa.ace;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ReinforceCardView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.card.views.CardView;
import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.views.UserAccessToCategoryView;
import com.anfelisa.user.views.EmailConfirmationView;
import com.anfelisa.user.views.EmailView;
import com.anfelisa.user.views.ResetPasswordView;
import com.anfelisa.user.views.UserView;

public class ViewProvider extends AbstractViewProvider {

	public final BoxView boxView;
	public final CardView cardView;
	public final ScheduledCardView scheduledCardView;
	public CategoryView categoryView;
	public UserAccessToCategoryView userAccessToCategoryView;
	public EmailConfirmationView emailConfirmationView;
	public UserView userView;
	public EmailView emailView;
	public ResetPasswordView resetPasswordView;
	public ReinforceCardView reinforceCardView;

	public ViewProvider(IDaoProvider daoProvider, EmailService emailService) {
		boxView = new BoxView(daoProvider);
		cardView = new CardView(daoProvider);
		scheduledCardView = new ScheduledCardView(daoProvider);
		categoryView = new CategoryView(daoProvider);
		userAccessToCategoryView = new UserAccessToCategoryView(daoProvider);
		emailConfirmationView = new EmailConfirmationView(daoProvider);
		userView = new UserView(daoProvider);
		emailView = new EmailView(emailService);
		resetPasswordView = new ResetPasswordView(daoProvider);
		reinforceCardView = new ReinforceCardView(daoProvider);
	}
	
}

