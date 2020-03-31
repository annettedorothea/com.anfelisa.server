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

import java.util.Base64;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.GetCardsResponse;
import com.anfelisa.card.data.GetDuplicatesResponse;
import com.anfelisa.card.models.ICardWithCategoryNameModel;
import com.anfelisa.card.models.ICardWithInfoModel;
import com.anfelisa.category.data.GetCategoryTreeResponse;
import com.anfelisa.category.models.ICategoryTreeItemModel;
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
	public static void beforeClass() throws InterruptedException {
		Thread.sleep(2000); // to slow it down due to connection pool
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
		handle = new PersistenceHandle(jdbi.open());
		daoProvider.truncateAllViews(handle);
	}

	@After
	public void after() {
		handle.getHandle().close();
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
	
	@Override
	protected void assertIsNull(Object actual) {
		org.junit.Assert.assertNull(actual);
	}
}
