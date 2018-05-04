package com.anfelisa.ace;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ScoredCardView;
import com.anfelisa.card.views.CardView;
import com.anfelisa.category.views.CategoryView;
import com.anfelisa.user.views.EmailConfirmationView;
import com.anfelisa.user.views.EmailView;
import com.anfelisa.user.views.ResetPasswordView;
import com.anfelisa.user.views.UserView;

public class ViewProvider {
	
	public final BoxView boxView;
	public final CardView cardView;
	public final ScheduledCardView scheduledCardView;
	public CategoryView categoryView;
	public EmailConfirmationView emailConfirmationView;
	public UserView userView;
	public EmailView emailView;
	public ResetPasswordView resetPasswordView;
	public ScoredCardView scoredCardView;
	
	public ViewProvider(DaoProvider daoProvider, EmailService emailService) {
		boxView = new BoxView(daoProvider);
		cardView = new CardView(daoProvider);
		scheduledCardView = new ScheduledCardView(daoProvider);
		categoryView = new CategoryView(daoProvider);
		emailConfirmationView = new EmailConfirmationView(daoProvider);
		userView = new UserView(daoProvider);
		emailView = new EmailView(daoProvider, emailService);
		resetPasswordView = new ResetPasswordView(daoProvider);
		scoredCardView = new ScoredCardView(daoProvider);
	}
}
