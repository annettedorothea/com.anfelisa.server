package com.anfelisa.box.actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.junit.Test;

import com.anfelisa.auth.Roles;
import com.anfelisa.box.TestUtils;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.test.BaseTest;
import com.anfelisa.user.models.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ScoreCardTest extends BaseTest {

	@Test
	public void returnsOK() throws JsonProcessingException {
		user = new UserModel(TestUtils.randomUUID(), "test-user", "password", "info@anfelisa.de",
				Roles.STUDENT, false);
		prepare(registerUserTimeline(user));
		DateTime systemTime = new DateTime(2019, 1, 23, 15, 0, 0);
		setSystemTime(systemTime);

		IScoreCardData data = new ScoreCardData(TestUtils.randomUUID());
		Response response = TestUtils.callScoreCard(data, getAuthenticationHeader());

		assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

	}

}
