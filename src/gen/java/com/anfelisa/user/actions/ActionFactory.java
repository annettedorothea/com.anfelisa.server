package com.anfelisa.user.actions;

import java.io.IOException;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IAction;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class ActionFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(ActionFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IAction createAction(String actionClass, String json, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (actionClass.equals("com.anfelisa.user.actions.ForgotPasswordAction")) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				ForgotPasswordAction action = new ForgotPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
			if (actionClass.equals("com.anfelisa.user.actions.ResetPasswordAction")) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				ResetPasswordAction action = new ResetPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
			if (actionClass.equals("com.anfelisa.user.actions.RegisterUserAction")) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				RegisterUserAction action = new RegisterUserAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
			if (actionClass.equals("com.anfelisa.user.actions.ConfirmEmailAction")) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				ConfirmEmailAction action = new ConfirmEmailAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
			if (actionClass.equals("com.anfelisa.user.actions.ChangeUserRoleAction")) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				ChangeUserRoleAction action = new ChangeUserRoleAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
			if (actionClass.equals("com.anfelisa.user.actions.DeleteUserAction")) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				DeleteUserAction action = new DeleteUserAction(jdbi, appConfiguration, daoProvider, viewProvider);
				action.setActionData(data);
				return action;
			}
		} catch (IOException e) {
			LOG.error("failed to create action {} with data {}", actionClass, json, e);
		}

		return null;
	}
}

