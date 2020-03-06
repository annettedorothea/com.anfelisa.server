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

package com.anfelisa.ace;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import java.util.Base64;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.GetAllUsersResponse;
import com.anfelisa.user.models.IUserModel;

import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.testing.DropwizardTestSupport;

public class BaseScenario extends AbstractBaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);

	public static final DropwizardTestSupport<CustomAppConfiguration> DROPWIZARD = new DropwizardTestSupport<CustomAppConfiguration>(
			App.class, "test.yml");

	private static Jdbi jdbi;

	@BeforeClass
	public static void beforeClass() {
		DROPWIZARD.before();
		final JdbiFactory factory = new JdbiFactory();
		jdbi = factory.build(DROPWIZARD.getEnvironment(), DROPWIZARD.getConfiguration().getDataSourceFactory(),
				"testdb");
	}

	@AfterClass
	public static void afterClass() {
		try {
			DROPWIZARD.after();
		} catch (Exception x) {
			LOG.error("exception when cleaning up dropwizard", x);
		}
	}

	@Before
	public void before() {
		daoProvider = new DaoProvider();
		handle = jdbi.open();
		daoProvider.truncateAllViews(handle);
	}

	@After
	public void after() {
		handle.close();
	}

	@Override
	protected String authorization(String username, String password) {
		String string = username + ":" + password;
		String hash = Base64.getEncoder().encodeToString(string.getBytes());
		return "anfelisaBasic " + hash;
	}

	@Override
	protected void assertThat(int actual, int expected) {
		org.junit.Assert.assertThat(actual, is(expected));
	}

	@Override
	protected void assertThat(Object actual, Object expected) {
		if (actual instanceof GetAllUsersResponse) {
			assertThat((GetAllUsersResponse) actual, (GetAllUsersResponse) expected);
		} else {
			org.junit.Assert.assertThat(actual, is(samePropertyValuesAs(expected)));
		}
	}

	protected void assertThat(GetAllUsersResponse actual, GetAllUsersResponse expected) {
		List<IUserModel> actualUserList = actual.getUserList();
		List<IUserModel> expectedUserList = expected.getUserList();
		assertThat(actualUserList.size(), expectedUserList.size());
		for (int i = 0; i < actualUserList.size(); i++) {
			IUserModel actualUser = actualUserList.get(i);
			IUserModel expectedUser = expectedUserList.get(i);
			org.junit.Assert.assertThat(actualUser, is(samePropertyValuesAs(expectedUser)));
		}
	}

	@Override
	protected void assertIsNull(Object actual) {
		org.junit.Assert.assertNull(actual);
	}
}
