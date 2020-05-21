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

package de.acegen;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertEquals;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.jdbi.v3.core.Jdbi;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.GetBoxStatisticsResponse;
import com.anfelisa.box.data.GetBoxesResponse;
import com.anfelisa.box.models.IBoxStatisticsModel;
import com.anfelisa.box.models.IBoxViewModel;
import com.anfelisa.card.data.GetCardsResponse;
import com.anfelisa.card.data.GetDuplicatesResponse;
import com.anfelisa.card.models.ICardWithCategoryNameModel;
import com.anfelisa.card.models.ICardWithInfoModel;
import com.anfelisa.category.data.GetCategoryTreeResponse;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.user.data.GetAllUsersResponse;
import com.anfelisa.user.models.IUserModel;

public abstract class BaseScenario extends AbstractBaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);

	private static Jdbi jdbi;

	private int port = 8096;

	private String host = "localhost";

	private String protocol = "http";

	private String testId;

	public Client client;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		jdbi = Jdbi.create("jdbc:postgresql://localhost/anfelisa_replay");
	}

	@AfterClass
	public static void afterClass() {
	}

	@Before
	public void before() {
		daoProvider = new DaoProvider();
		handle = new PersistenceHandle(jdbi.open());
		testId = randomString();
		client = new JerseyClientBuilder().build();
		LOG.info("testId {}", testId);
		LOG.info("*********************************************************************************");
		LOG.info("********   {} test id {}", this.scenarioName(), testId);
		LOG.info("*********************************************************************************");
	}

	@After
	public void after() {
		handle.getHandle().close();
	}

	protected Response httpGet(String path, String authorization) {
		Builder builder = client.target(String.format("%s://%s:%d/api%s", protocol, host, port, path)).request(); 
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return builder.get();
	}
	
	protected Response httpPost(String path, Object data, String authorization) {
		Builder builder = client.target(String.format("%s://%s:%d/api%s", protocol, host, port, path)).request(); 
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return builder.post(Entity.json(data));
	}
	
	protected Response httpPut(String path, Object data, String authorization) {
		Builder builder = client.target(String.format("%s://%s:%d/api%s", protocol, host, port, path)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return builder.put(Entity.json(data));
	}
	
	protected Response httpDelete(String path, String authorization)  {
		Builder builder = client.target(String.format("%s://%s:%d/api%s", protocol, host, port, path)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return builder.delete();
	}
	
	protected String randomString() {
		return randomUUID().replace("-", "").substring(0, 8);
	}

	@Override
	protected String randomUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	protected String authorization(String username, String password) {
		String string = username.replace("${testId}", testId) + ":" + password;
		String hash = Base64.getEncoder().encodeToString(string.getBytes());
		return "anfelisaBasic " + hash;
	}

	@Override
	protected void assertThat(int actual, int expected) {
		org.junit.Assert.assertThat(actual, is(expected));
	}

	@Override
	protected void assertFail(String message) {
		org.junit.Assert.fail(message);
	}

	@Override
	protected void assertThat(Object actual, Object expected) {
		if (actual == null) {
			assertIsNull(expected);
		} else if (actual instanceof GetAllUsersResponse) {
			assertThat((GetAllUsersResponse) actual, (GetAllUsersResponse) expected);
		} else if (actual instanceof GetCategoryTreeResponse) {
			assertThat((GetCategoryTreeResponse) actual, (GetCategoryTreeResponse) expected);
		} else if (actual instanceof GetCardsResponse) {
			assertThat((GetCardsResponse) actual, (GetCardsResponse) expected);
		} else if (actual instanceof GetDuplicatesResponse) {
			assertThat((GetDuplicatesResponse) actual, (GetDuplicatesResponse) expected);
		} else if (actual instanceof GetBoxesResponse) {
			assertThat((GetBoxesResponse) actual, (GetBoxesResponse) expected);
		} else if (actual instanceof GetBoxStatisticsResponse) {
			assertThat((GetBoxStatisticsResponse) actual, (GetBoxStatisticsResponse) expected);
		} else {
			org.junit.Assert.assertThat(actual, is(samePropertyValuesAs(expected)));
		}
	}

	private void assertThat(GetAllUsersResponse actual, GetAllUsersResponse expected) {
		List<IUserModel> actualUserList = actual.getUserList();
		List<IUserModel> expectedUserList = expected.getUserList();
		assertThat(actualUserList.size(), expectedUserList.size());
		for (int i = 0; i < actualUserList.size(); i++) {
			IUserModel actualUser = actualUserList.get(i);
			IUserModel expectedUser = expectedUserList.get(i);
			org.junit.Assert.assertThat(actualUser, is(samePropertyValuesAs(expectedUser)));
		}
	}

	private void assertThat(GetCategoryTreeResponse actual, GetCategoryTreeResponse expected) {
		ICategoryTreeItemModel actualRootCategory = actual.getRootCategory();
		ICategoryTreeItemModel expectedRootCategory = expected.getRootCategory();
		assertThat(actualRootCategory, expectedRootCategory);
	}

	private void assertThat(ICategoryTreeItemModel actual, ICategoryTreeItemModel expected) {
		assertThat(actual.getCategoryId(), expected.getCategoryId());
		assertThat(actual.getCategoryIndex(), expected.getCategoryIndex());
		assertThat(actual.getCategoryName(), expected.getCategoryName());
		assertThat(actual.getDictionaryLookup(), expected.getDictionaryLookup());
		assertThat(actual.getEmpty(), expected.getEmpty());
		assertThat(actual.getGivenLanguage(), expected.getGivenLanguage());
		assertThat(actual.getParentCategoryId(), expected.getParentCategoryId());
		assertThat(actual.getRootCategoryId(), expected.getRootCategoryId());
		assertThat(actual.getWantedLanguage(), expected.getWantedLanguage());
		if (actual.getChildCategories() == null) {
			assertIsNull(expected.getChildCategories());
		} else if (expected.getChildCategories() == null) {
			org.junit.Assert.fail("expected.getChildCategories is null");
		} else {
			assertThat(actual.getChildCategories().size(), expected.getChildCategories().size());
			for (int i = 0; i < actual.getChildCategories().size(); i++) {
				ICategoryTreeItemModel actualChild = actual.getChildCategories().get(i);
				ICategoryTreeItemModel expectedChild = expected.getChildCategories().get(i);
				assertThat(actualChild, expectedChild);
			}
		}
	}

	private void assertThat(GetCardsResponse actual, GetCardsResponse expected) {
		if (actual.getCardList() == null) {
			assertIsNull(expected.getCardList());
		} else if (expected.getCardList() == null) {
			org.junit.Assert.fail("expected.getCardList is null");
		} else {
			assertThat(actual.getCardList().size(), expected.getCardList().size());
			for (int i = 0; i < actual.getCardList().size(); i++) {
				ICardWithInfoModel actualCard = actual.getCardList().get(i);
				ICardWithInfoModel expectedCard = expected.getCardList().get(i);
				assertThat(actualCard, expectedCard);
			}
		}
	}

	private void assertThat(GetDuplicatesResponse actual, GetDuplicatesResponse expected) {
		if (actual.getCardList() == null) {
			assertIsNull(expected.getCardList());
		} else if (expected.getCardList() == null) {
			org.junit.Assert.fail("expected.getCardList is null");
		} else {
			assertThat(actual.getCardList().size(), expected.getCardList().size());
			for (int i = 0; i < actual.getCardList().size(); i++) {
				ICardWithCategoryNameModel actualCard = actual.getCardList().get(i);
				ICardWithCategoryNameModel expectedCard = expected.getCardList().get(i);
				assertThat(actualCard, expectedCard);
			}
		}
	}

	private void assertThat(GetBoxesResponse actual, GetBoxesResponse expected) {
		if (actual.getBoxList() == null) {
			assertIsNull(expected.getBoxList());
		} else if (expected.getBoxList() == null) {
			org.junit.Assert.fail("expected.getBoxList is null");
		} else {
			assertThat(actual.getBoxList().size(), expected.getBoxList().size());
			for (int i = 0; i < actual.getBoxList().size(); i++) {
				IBoxViewModel actualBox = actual.getBoxList().get(i);
				IBoxViewModel expectedBox = expected.getBoxList().get(i);
				assertThat(actualBox, expectedBox);
			}
		}
	}

	private void assertThat(IBoxViewModel actual, IBoxViewModel expected) {
		if (actual == null) {
			assertIsNull(expected);
		} else if (expected == null) {
			org.junit.Assert.fail("expected is null");
		} else {
			assertEquals(expected.getBoxId(), actual.getBoxId());
			assertEquals(expected.getCategoryId(), actual.getCategoryId());
			assertEquals(expected.getCategoryName(), actual.getCategoryName());
			assertEquals(expected.getOpenTodaysCards(), actual.getOpenTodaysCards());
		}
	}

	private void assertThat(GetBoxStatisticsResponse actual, GetBoxStatisticsResponse expected) {
		if (actual.getBoxList() == null) {
			assertIsNull(expected.getBoxList());
		} else if (expected.getBoxList() == null) {
			org.junit.Assert.fail("expected.getBoxList is null");
		} else {
			assertThat(actual.getBoxList().size(), expected.getBoxList().size());
			for (int i = 0; i < actual.getBoxList().size(); i++) {
				IBoxStatisticsModel actualBox = actual.getBoxList().get(i);
				IBoxStatisticsModel expectedBox = expected.getBoxList().get(i);
				assertThat(actualBox, expectedBox);
			}
		}
	}

	private void assertThat(IBoxStatisticsModel actual, IBoxStatisticsModel expected) {
		if (actual == null) {
			assertIsNull(expected);
		} else if (expected == null) {
			org.junit.Assert.fail("expected is null");
		} else {
			assertEquals(expected.getBoxId(), actual.getBoxId());
			assertEquals(expected.getMaxCardsPerDay(), actual.getMaxCardsPerDay());
			assertEquals(expected.getQuality0Count(), actual.getQuality0Count());
			assertEquals(expected.getQuality1Count(), actual.getQuality1Count());
			assertEquals(expected.getQuality2Count(), actual.getQuality2Count());
			assertEquals(expected.getQuality3Count(), actual.getQuality3Count());
			assertEquals(expected.getQuality4Count(), actual.getQuality4Count());
			assertEquals(expected.getQuality5Count(), actual.getQuality5Count());
			List<Integer> actualCountsPerDayNextWeek = actual.getCountsPerDayNextWeek();
			List<Integer> expectedCountsPerDayNextWeek = expected.getCountsPerDayNextWeek();
			if (actualCountsPerDayNextWeek == null) {
				assertIsNull(expectedCountsPerDayNextWeek);
			} else if (expectedCountsPerDayNextWeek == null) {
				org.junit.Assert.fail("expected is null");
			} else {
				assertThat(actualCountsPerDayNextWeek.size(), expectedCountsPerDayNextWeek.size());
				for (int i = 0; i < expectedCountsPerDayNextWeek.size(); i++) {
					assertThat(actualCountsPerDayNextWeek.get(i), expectedCountsPerDayNextWeek.get(i));
				}
			}
		}
	}

	@Override
	protected void assertIsNull(Object actual) {
		org.junit.Assert.assertNull(actual);
	}

	@Override
	protected void assertIsNotNull(Object actual) {
		org.junit.Assert.assertNotNull(actual);
	}

	@Override
	protected String getProtocol() {
		return protocol;
	}

	@Override
	protected String getHost() {
		return host;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	protected boolean prerequisite(String scenarioName) {
		switch (scenarioName) {
		case "RegisterUserAdmin":
			return (daoProvider.getUserDao().selectByUsername(handle, "Admin") == null);
		case "GetAllUsersAdmin":
			return (daoProvider.getUserDao().selectAll(handle).size() == 2);
		case "DeleteUserLastAdmin":
			return (daoProvider.getUserDao().selectAdminCount(handle) == 1);
		default:
			return true;
		}
	}

	@Override
	protected String getTestId() {
		return testId;
	}

	protected String replaceTestId(String string) {
		return string.replace("${testId}", testId);
	}

	@Override
	protected Response callNotReplayableDataProviderPutValue(
			String uuid, String key, Object data,
			String protocol, String host, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client
				.target(String.format("%s://%s:%d/api/test/not-replayable/value?uuid=" + uuid + "&key=" + key, protocol,
						host, port))
				.request();
		return builder.put(Entity.json(data));
	}

	@Override
	protected Response callNotReplayableDataProviderPutSystemTime(
			String uuid, DateTime dateTime,
			String protocol, String host, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client
				.target(String.format(
						"%s://%s:%d/api/test/not-replayable/system-time?uuid=" + uuid + "&system-time=" + dateTime,
						protocol, host, port))
				.request();
		return builder.put(Entity.json(dateTime));
	}

}
