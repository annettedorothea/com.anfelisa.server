package com.anfelisa.test;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.util.Base64;
import org.jdbi.v3.core.Jdbi;
import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import com.anfelisa.ace.AbstractBaseTest;
import com.anfelisa.ace.App;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.user.TestUtils;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.testing.DropwizardTestSupport;

public class BaseTest extends AbstractBaseTest {

	public static final DropwizardTestSupport<CustomAppConfiguration> SUPPORT = new DropwizardTestSupport<CustomAppConfiguration>(
			App.class, "test.yml");

	@Before
	public void before() {
		SUPPORT.before();
		final JdbiFactory factory = new JdbiFactory();
		Jdbi jdbi = factory.build(SUPPORT.getEnvironment(), SUPPORT.getConfiguration().getDataSourceFactory(), "testdb");
		daoProvider = new DaoProvider();
		handle = jdbi.open();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void after() {
		SUPPORT.after();
		handle.close();
	}

	protected String getAuthenticationHeader(IUserModel user) {
		String username = user.getUsername();
		String password = user.getPassword();
		final String pair = username + ":" + password;
		final byte[] encodedBytes = Base64.encode(pair.getBytes());
		return "anfelisaBasic " + new String(encodedBytes);
	}

	protected List<ITimelineItem> registerUserTimeline(IUserModel user) throws JsonProcessingException {
		List<ITimelineItem> items = new ArrayList<ITimelineItem>();
		String token = randomUUID();
		IUserRegistrationData userRegistrationData = new UserRegistrationData(user.getUserId())
				.withEmail(user.getEmail()).withEmailConfirmed(user.getEmailConfirmed()).withLanguage("de")
				.withPassword(user.getPassword()).withRole(user.getRole()).withToken(token).withUserId(user.getUserId())
				.withUsername(user.getUsername());
		items.add(TestUtils.createRegisterUserOkEventTimelineItem(userRegistrationData));

		IConfirmEmailData confirmEmailData = new ConfirmEmailData(randomUUID()).withUserId(user.getUserId())
				.withToken(token).withUsername(user.getUsername());
		items.add(TestUtils.createConfirmEmailOkEventTimelineItem(confirmEmailData));
		return items;
	}
	
}
