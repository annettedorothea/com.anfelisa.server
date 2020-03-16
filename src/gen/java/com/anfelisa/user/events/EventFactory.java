/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user.events;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.CustomAppConfiguration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				RegisterUserOkEvent event = new RegisterUserOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				ConfirmEmailOkEvent event = new ConfirmEmailOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				ForgotPasswordOkEvent event = new ForgotPasswordOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				ResetPasswordOkEvent event = new ResetPasswordOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				ChangeUserRoleOkEvent event = new ChangeUserRoleOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				DeleteUserOkEvent event = new DeleteUserOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		if (eventClass.equals("com.anfelisa.user.events.RegisterUserOkEvent")) {
			return new RegisterUserOkEvent((UserRegistrationData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")) {
			return new ConfirmEmailOkEvent((ConfirmEmailData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")) {
			return new ForgotPasswordOkEvent((ForgotPasswordData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.ResetPasswordOkEvent")) {
			return new ResetPasswordOkEvent((ResetPasswordWithNewPasswordData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")) {
			return new ChangeUserRoleOkEvent((ChangeUserRoleData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.user.events.DeleteUserOkEvent")) {
			return new DeleteUserOkEvent((DeleteUserData)data, daoProvider, viewProvider, appConfiguration);
		}


		return null;
	}
}




/******* S.D.G. *******/



