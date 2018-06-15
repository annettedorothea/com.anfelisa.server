package com.anfelisa.ace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ReinforceCardView;
import com.anfelisa.box.views.ScheduledCardView;
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
	public ReinforceCardView reinforceCardView;

	private final Map<String, List<BiConsumer<? extends IDataContainer, Handle>>> consumerMap;

	public ViewProvider(DaoProvider daoProvider, EmailService emailService) {
		boxView = new BoxView(daoProvider);
		cardView = new CardView(daoProvider);
		scheduledCardView = new ScheduledCardView(daoProvider);
		categoryView = new CategoryView(daoProvider);
		emailConfirmationView = new EmailConfirmationView(daoProvider);
		userView = new UserView(daoProvider);
		emailView = new EmailView(daoProvider, emailService);
		resetPasswordView = new ResetPasswordView(daoProvider);
		reinforceCardView = new ReinforceCardView(daoProvider);
		consumerMap = new HashMap<String, List<BiConsumer<? extends IDataContainer, Handle>>>();
	}
	
	public void addConsumer(String eventName, BiConsumer<? extends IDataContainer, Handle> createUserTable) {
		List<BiConsumer<? extends IDataContainer, Handle>> consumerForEvent = consumerMap.get(eventName);
		if (consumerForEvent == null) {
			consumerForEvent = new ArrayList<BiConsumer<? extends IDataContainer, Handle>>();
			consumerMap.put(eventName, consumerForEvent);
		}
		consumerForEvent.add(createUserTable);
	}

	public List<BiConsumer<? extends IDataContainer, Handle>> getConsumerForEvent(String eventName) {
		return consumerMap.get(eventName);
	}

}
