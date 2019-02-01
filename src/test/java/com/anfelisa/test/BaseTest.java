package com.anfelisa.test;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.util.Base64;

import com.anfelisa.ace.AbstractBaseTest;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.TimelineItem;
import com.anfelisa.user.TestUtils;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public class BaseTest extends AbstractBaseTest {

	protected String getAuthenticationHeader() {
		String username = "Annette";
		String password = "00161e7f79e404bad9cc8f53c0f663f2";
		final String pair = username + ":" + password;
		final byte[] encodedBytes = Base64.encode(pair.getBytes());
		return "anfelisaBasic " + new String(encodedBytes);
	}

	protected List<ITimelineItem> registerUserTimeline(IUserModel user) throws JsonProcessingException {
		List<ITimelineItem> items = new ArrayList<ITimelineItem>();
		/*String token = TestUtils.randomUUID();
		IUserRegistrationData userRegistrationData = new UserRegistrationData(user.getUserId())
				.withEmail(user.getEmail()).withEmailConfirmed(user.getEmailConfirmed()).withLanguage("de")
				.withPassword(user.getPassword()).withRole(user.getRole()).withToken(token).withUserId(user.getUserId())
				.withUsername(user.getUsername());*/
		//items.add(TestUtils.createRegisterUserOkEventTimelineItem(userRegistrationData));
		//items.add(new TimelineItem("prepare", null, "com.anfelisa.user.events.RegisterUserOkEvent", null, "{\"language\":\"de\",\"userId\":\"1f0e0a89-bec8-4640-be52-a2a666a59823\",\"username\":\"test-user\",\"password\":\"password\",\"email\":\"info@anfelisa.de\",\"role\":\"STUDENT\",\"emailConfirmed\":false,\"token\":\"e0b7131a-8140-45d6-99f9-05e5acc1e441\",\"uuid\":\"1f0e0a89-bec8-4640-be52-a2a666a59823\",\"outcome\":null,\"systemTime\":null}", "123"));

/*		IConfirmEmailData confirmEmailData = new ConfirmEmailData(TestUtils.randomUUID()).withUserId(user.getUserId())
				.withToken(token).withUsername(user.getUsername());
		items.add(TestUtils.createConfirmEmailOkEventTimelineItem(confirmEmailData));*/
		return items;
	}

}
