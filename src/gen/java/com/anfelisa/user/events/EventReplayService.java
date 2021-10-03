/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.Event;
import de.acegen.ViewProvider;
import com.anfelisa.user.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
import de.acegen.CustomAppConfiguration;
import de.acegen.PersistenceHandle;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EventReplayService {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventReplayService.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				Event event = new Event<UserRegistrationData>("com.anfelisa.user.events.RegisterUserOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				Event event = new Event<ConfirmEmailData>("com.anfelisa.user.events.ConfirmEmailOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				Event event = new Event<ForgotPasswordData>("com.anfelisa.user.events.ForgotPasswordOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				Event event = new Event<ResetPasswordWithNewPasswordData>("com.anfelisa.user.events.ResetPasswordOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				Event event = new Event<ChangeUserRoleData>("com.anfelisa.user.events.ChangeUserRoleOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				Event event = new Event<DeleteUserData>("com.anfelisa.user.events.DeleteUserOkEvent", daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
		} catch (IOException e) {
			LOG.error("failed to replay event {} with data {}", eventClass, json, e);
		}
	}

}



/******* S.D.G. *******/



