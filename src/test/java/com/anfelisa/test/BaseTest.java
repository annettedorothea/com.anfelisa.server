package com.anfelisa.test;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.util.Base64;

import com.anfelisa.ace.AbstractBaseTest;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.user.TestUtils;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public class BaseTest extends AbstractBaseTest {

	protected IUserModel user;
	
	protected String getAuthenticationHeader() {
		String username = user.getUsername();
		String password = user.getPassword();
		final String pair = username + ":" + password;
		final byte[] encodedBytes = Base64.encode(pair.getBytes());
		return "anfelisaBasic " + new String(encodedBytes);
	}

	protected List<ITimelineItem> registerUserTimeline(IUserModel user) throws JsonProcessingException {
		List<ITimelineItem> items = new ArrayList<ITimelineItem>();
		String token = TestUtils.randomUUID();
		IUserRegistrationData userRegistrationData = new UserRegistrationData(user.getUserId())
				.withEmail(user.getEmail()).withEmailConfirmed(user.getEmailConfirmed()).withLanguage("de")
				.withPassword(user.getPassword()).withRole(user.getRole()).withToken(token).withUserId(user.getUserId())
				.withUsername(user.getUsername());
		items.add(TestUtils.createRegisterUserOkEventTimelineItem(userRegistrationData));

		IConfirmEmailData confirmEmailData = new ConfirmEmailData(TestUtils.randomUUID()).withUserId(user.getUserId())
				.withToken(token).withUsername(user.getUsername());
		items.add(TestUtils.createConfirmEmailOkEventTimelineItem(confirmEmailData));
		return items;
	}

}
