package com.anfelisa.box.actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;
import org.joda.time.DateTime;
import org.junit.Test;

import com.anfelisa.box.BaseTest;
import com.anfelisa.box.TestUtils;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.ScoreCardData;

public class ScoreCardTest extends BaseTest {

	@Test
	public void returnsOK() {
		// prepare();
		DateTime systemTime = new DateTime(2019, 1, 23, 15, 0, 0);
		setSystemTime(systemTime);

		String uuid = UUID.randomUUID().toString();

		IScoreCardData data = new ScoreCardData(uuid);
		Response response = TestUtils.callScoreCard(data);

		assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

	}

	/*
	 * Response response = Response.status(200). entity(yourEntity).
	 * header("yourHeaderName", "yourHeaderValue").build();
	 */
	protected Builder addAuthentication(Builder builder) {
		String username = "Annette";
		String password = "00161e7f79e404bad9cc8f53c0f663f2";
		final String pair = username + ":" + password;
		final byte[] encodedBytes = Base64.encode(pair.getBytes());
		String encoded = "anfelisaBasic " + new String(encodedBytes);
		return builder.header("Authorization", encoded);
	}

}
