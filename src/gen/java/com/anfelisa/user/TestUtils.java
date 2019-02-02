package com.anfelisa.user;

import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();

	
	
	
	
	public static TimelineItem createForgotPasswordOkEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ForgotPasswordOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createForgotPasswordDoesNotExistEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ForgotPasswordDoesNotExistEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createResetPasswordOkEventTimelineItem(com.anfelisa.user.data.IResetPasswordWithNewPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ResetPasswordOkEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createRegisterUserOkEventTimelineItem(com.anfelisa.user.data.IUserRegistrationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.RegisterUserOkEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createConfirmEmailOkEventTimelineItem(com.anfelisa.user.data.IConfirmEmailData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ConfirmEmailOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createConfirmEmailAlreadyConfirmedEventTimelineItem(com.anfelisa.user.data.IConfirmEmailData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ConfirmEmailAlreadyConfirmedEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createChangeUserRoleOkEventTimelineItem(com.anfelisa.user.data.IChangeUserRoleData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ChangeUserRoleOkEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createDeleteUserOkEventTimelineItem(com.anfelisa.user.data.IDeleteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.DeleteUserOkEvent", null, json, data.getUuid());
	}
	
	
}

