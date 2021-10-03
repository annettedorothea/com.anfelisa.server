/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.IDataContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anfelisa.user.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.user.actions.RegisterUserAction") ||
					className.equals("com.anfelisa.user.commands.RegisterUserCommand") ||
					className.equals("com.anfelisa.user.events.RegisterUserOkEvent")
			) {
				UserRegistrationData data = mapper.readValue(json, UserRegistrationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.GetTokenAction") ||
					className.equals("com.anfelisa.user.commands.GetTokenCommand") 
			) {
				TokenData data = mapper.readValue(json, TokenData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.GetUserInfoAction")) {
				UserInfoData data = mapper.readValue(json, UserInfoData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.UsernameAvailableAction")) {
				UsernameAvailableData data = mapper.readValue(json, UsernameAvailableData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.ConfirmEmailAction") ||
					className.equals("com.anfelisa.user.commands.ConfirmEmailCommand") ||
					className.equals("com.anfelisa.user.events.ConfirmEmailOkEvent")||
					className.equals("com.anfelisa.user.events.ConfirmEmailAlreadyConfirmedEvent")
			) {
				ConfirmEmailData data = mapper.readValue(json, ConfirmEmailData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.GetUserProfileAction")) {
				UserData data = mapper.readValue(json, UserData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.ForgotPasswordAction") ||
					className.equals("com.anfelisa.user.commands.ForgotPasswordCommand") ||
					className.equals("com.anfelisa.user.events.ForgotPasswordOkEvent")||
					className.equals("com.anfelisa.user.events.ForgotPasswordDoesNotExistEvent")
			) {
				ForgotPasswordData data = mapper.readValue(json, ForgotPasswordData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.ResetPasswordAction") ||
					className.equals("com.anfelisa.user.commands.ResetPasswordCommand") ||
					className.equals("com.anfelisa.user.events.ResetPasswordOkEvent")
			) {
				ResetPasswordWithNewPasswordData data = mapper.readValue(json, ResetPasswordWithNewPasswordData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.ChangeUserRoleAction") ||
					className.equals("com.anfelisa.user.commands.ChangeUserRoleCommand") ||
					className.equals("com.anfelisa.user.events.ChangeUserRoleOkEvent")
			) {
				ChangeUserRoleData data = mapper.readValue(json, ChangeUserRoleData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.user.actions.DeleteUserAction") ||
					className.equals("com.anfelisa.user.commands.DeleteUserCommand") ||
					className.equals("com.anfelisa.user.events.DeleteUserOkEvent")
			) {
				DeleteUserData data = mapper.readValue(json, DeleteUserData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}



/******* S.D.G. *******/



