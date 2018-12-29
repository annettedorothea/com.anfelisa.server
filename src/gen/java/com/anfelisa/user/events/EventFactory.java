package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
		IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				ForgotPasswordOkEvent event = new ForgotPasswordOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				ResetPasswordOkEvent event = new ResetPasswordOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				RegisterUserOkEvent event = new RegisterUserOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				ConfirmEmailOkEvent event = new ConfirmEmailOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				ChangeUserRoleOkEvent event = new ChangeUserRoleOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				DeleteUserOkEvent event = new DeleteUserOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}
}

