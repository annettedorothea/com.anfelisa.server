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

	public static TimelineItem createSendForgotPasswordEmailOkEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.SendForgotPasswordEmailOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createSendForgotPasswordEmailDoesNotExistEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.SendForgotPasswordEmailDoesNotExistEvent", null, json, data.getUuid());
	}

	public static TimelineItem createResetPasswordOkEventTimelineItem(com.anfelisa.user.data.IResetPasswordWithNewPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ResetPasswordOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createRegisterUserOkEventTimelineItem(com.anfelisa.user.data.IUserRegistrationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.RegisterUserOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createSendRegistrationEmailOkEventTimelineItem(com.anfelisa.user.data.IUserRegistrationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.SendRegistrationEmailOkEvent", null, json, data.getUuid());
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




/******* S.D.G. *******/



