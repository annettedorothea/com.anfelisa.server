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

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@RunWith(JUnitPlatform.class)
public abstract class BaseScenario extends AbstractBaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);

	private static Jdbi jdbi;

	private static int port;

	private static String host = "localhost";

	private static String protocol;

	private static String rootPath;

	private String testId;

	public Client client;

	protected static Map<String, DescriptiveStatistics> metrics;

	@BeforeAll
	public static void beforeClass() throws Exception {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		YamlConfiguration config = mapper.readValue(new File("dev.yml"), YamlConfiguration.class);
		port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());
		protocol = config.getServer().getApplicationConnectors()[0].getType();
		rootPath = config.getServer().getRootPath();
		jdbi = Jdbi.create(config.getDatabase().getUrl());
		if (metrics == null) {
			metrics = new HashMap<>();
		}
	}

	@AfterAll
	public static void afterClass() {
		Object[] actions = metrics.keySet().toArray();
		Arrays.sort(actions);
		LOG.info(padRight("action", 25) + padLeft("times", 9) + padLeft("mean", 9) + padLeft("std dev", 9)
				+ padLeft("median", 9) + padLeft("pctl(10)", 9) + padLeft("pctl(90)", 9) + padLeft("min", 9)
				+ padLeft("max", 9));
		for (Object action : actions) {
			DescriptiveStatistics values = metrics.get(action);
			LOG.info(padRight(action.toString(), 25) + padLeft(values.getN() + "", 9)
					+ padLeft(format(values.getMean()), 9) + padLeft(format(values.getStandardDeviation()), 9)
					+ padLeft(format(values.getPercentile(50)), 9)
					+ padLeft(format(values.getPercentile(10)), 9)
					+ padLeft(format(values.getPercentile(90)), 9) + padLeft(values.getMin(), 9)
					+ padLeft(values.getMax(), 9));
		}
	}

	private static String padLeft(double d, int n) {
		return String.format("%" + n + "s", new DecimalFormat("#").format(d));
	}

	public static String padLeft(String s, int n) {
		return String.format("%" + n + "s", s);
	}

	public static String padRight(String s, int n) {
		return String.format("%-" + n + "s", s);
	}

	private static String format(double d) {
		return new DecimalFormat("0.00").format(d);
	}

	@BeforeEach
	public void before() {
		daoProvider = new DaoProvider();
		handle = new PersistenceHandle(jdbi.open());
		testId = randomString();
		client = new JerseyClientBuilder().build();
		LOG.info("*********************************************************************************");
		LOG.info("********   {} test id {}", this.scenarioName(), testId);
		LOG.info("*********************************************************************************");
	}

	@AfterEach
	public void after() {
		handle.getHandle().close();
	}

	@Test
	public void test() throws Exception {
		this.runTest();
	}

	private String buildUrl(String path, String uuid) {
		if (path.contains("?")) {
			path += "&uuid=" + uuid;
		} else {
			path += "?uuid=" + uuid;
		}
		return String.format("%s://%s:%d%s%s", protocol, host, port, rootPath, path);
	}
	
	private<T> HttpResponse<T> generateResponse(Response response, Class<T> entityType) {
		int statusCode = response.getStatus();
		String statusMessage = null;
		T entity = null;
		if (statusCode >= 400) {
			statusMessage = response.readEntity(String.class);
		} else if (statusCode >= 200 && statusCode < 300 && entityType != null) {
			entity = response.readEntity(entityType);
		}
		response.close();
		return new HttpResponse<T>(entity, statusMessage, statusCode);
	}

	protected<T> HttpResponse<T> httpGet(String path, String authorization, String uuid, Class<T> entityType) {
		Builder builder = client.target(buildUrl(path, uuid)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return generateResponse(builder.get(), entityType);
	}

	protected<T> HttpResponse<T> httpPost(String path, Object payload, String authorization, String uuid, Class<T> entityType) {
		Builder builder = client.target(buildUrl(path, uuid)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return generateResponse(builder.post(Entity.json(payload)), entityType);
	}

	protected<T> HttpResponse<T> httpPut(String path, Object payload, String authorization, String uuid, Class<T> entityType) {
		Builder builder = client.target(buildUrl(path, uuid)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return generateResponse(builder.put(payload != null ? Entity.json(payload) : Entity.json("")), entityType);
	}

	protected<T> HttpResponse<T> httpDelete(String path, String authorization, String uuid, Class<T> entityType) {
		Builder builder = client.target(buildUrl(path, uuid)).request();
		if (authorization != null) {
			builder.header("Authorization", authorization);
		}
		return generateResponse(builder.delete(), entityType);
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
		org.hamcrest.MatcherAssert.assertThat("testId: " + this.getTestId(), actual, is(expected));
	}

	@Override
	protected void assertFail(String message) {
		org.junit.jupiter.api.Assertions.fail(message);
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
			org.hamcrest.MatcherAssert.assertThat("testId: " + this.getTestId(), actual,
					is(samePropertyValuesAs(expected)));
		}
	}

	private void assertThat(GetAllUsersResponse actual, GetAllUsersResponse expected) {
		List<IUserModel> actualUserList = actual.getUserList();
		List<IUserModel> expectedUserList = expected.getUserList();
		assertThat(actualUserList.size(), expectedUserList.size());
		for (int i = 0; i < actualUserList.size(); i++) {
			IUserModel actualUser = actualUserList.get(i);
			IUserModel expectedUser = expectedUserList.get(i);
			org.hamcrest.MatcherAssert.assertThat(actualUser, is(samePropertyValuesAs(expectedUser)));
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
			org.junit.jupiter.api.Assertions.fail("expected.getChildCategories is null");
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
			org.junit.jupiter.api.Assertions.fail("expected.getCardList is null");
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
			org.junit.jupiter.api.Assertions.fail("expected.getCardList is null");
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
			org.junit.jupiter.api.Assertions.fail("expected.getBoxList is null");
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
			org.junit.jupiter.api.Assertions.fail("expected is null");
		} else {
			org.junit.jupiter.api.Assertions.assertEquals(expected.getBoxId(), actual.getBoxId());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getCategoryId(), actual.getCategoryId());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getCategoryName(), actual.getCategoryName());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getOpenTodaysCards(), actual.getOpenTodaysCards());
		}
	}

	private void assertThat(GetBoxStatisticsResponse actual, GetBoxStatisticsResponse expected) {
		if (actual.getBoxStatisticsList() == null) {
			assertIsNull(expected.getBoxStatisticsList());
		} else if (expected.getBoxStatisticsList() == null) {
			org.junit.jupiter.api.Assertions.fail("expected.getBoxList is null");
		} else {
			assertThat(actual.getBoxStatisticsList().size(), expected.getBoxStatisticsList().size());
			for (int i = 0; i < actual.getBoxStatisticsList().size(); i++) {
				IBoxStatisticsModel actualBox = actual.getBoxStatisticsList().get(i);
				IBoxStatisticsModel expectedBox = expected.getBoxStatisticsList().get(i);
				assertThat(actualBox, expectedBox);
			}
		}
	}

	private void assertThat(IBoxStatisticsModel actual, IBoxStatisticsModel expected) {
		if (actual == null) {
			assertIsNull(expected);
		} else if (expected == null) {
			org.junit.jupiter.api.Assertions.fail("expected is null");
		} else {
			org.junit.jupiter.api.Assertions.assertEquals(expected.getBoxId(), actual.getBoxId());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getMaxCardsPerDay(), actual.getMaxCardsPerDay());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality0Count(), actual.getQuality0Count());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality1Count(), actual.getQuality1Count());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality2Count(), actual.getQuality2Count());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality3Count(), actual.getQuality3Count());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality4Count(), actual.getQuality4Count());
			org.junit.jupiter.api.Assertions.assertEquals(expected.getQuality5Count(), actual.getQuality5Count());
			List<Integer> actualCountsPerDayNextWeek = actual.getCountsPerDayNextWeek();
			List<Integer> expectedCountsPerDayNextWeek = expected.getCountsPerDayNextWeek();
			if (actualCountsPerDayNextWeek == null) {
				assertIsNull(expectedCountsPerDayNextWeek);
			} else if (expectedCountsPerDayNextWeek == null) {
				org.junit.jupiter.api.Assertions.fail("expected is null");
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
		org.junit.jupiter.api.Assertions.assertNull(actual, "testId: " + this.getTestId());
	}

	@Override
	protected void assertIsNotNull(Object actual) {
		org.junit.jupiter.api.Assertions.assertNotNull(actual, "testId: " + this.getTestId());
	}

	@Override
	protected void assertTrue(boolean b) {
		org.junit.jupiter.api.Assertions.assertTrue(b);
	}

	@Override
	protected void assertFalse(boolean b) {
		org.junit.jupiter.api.Assertions.assertFalse(b);
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
	protected Response callNonDeterministicDataProviderPutValue(String uuid, String key, Object data) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client
				.target(String.format("%s://%s:%d%s/test/non-deterministic/value?uuid=" + uuid + "&key=" + key, protocol,
						host, port, rootPath))
				.request();
		return builder.put(Entity.json(data));
	}

	@Override
	protected Response callNonDeterministicDataProviderPutSystemTime(String uuid, LocalDateTime dateTime) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client
				.target(String.format(
						"%s://%s:%d%s/test/non-deterministic/system-time?uuid=" + uuid + "&system-time=" + dateTime,
						protocol, host, port, rootPath))
				.request();
		return builder.put(Entity.json(dateTime));
	}

	@Override
	protected void addToMetrics(String action, Long duration) {
		DescriptiveStatistics values = metrics.get(action);
		if (values == null) {
			values = new DescriptiveStatistics();
			metrics.put(action, values);
		}
		values.addValue(duration);
		values = metrics.get("all");
		if (values == null) {
			values = new DescriptiveStatistics();
			metrics.put("all", values);
		}
		values.addValue(duration);
	}

}
