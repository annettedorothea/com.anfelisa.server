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

import java.util.UUID;

public abstract class AbstractBaseScenario {

	protected final JodaObjectMapper mapper = new JodaObjectMapper();

	protected DaoProvider daoProvider;

	protected PersistenceHandle handle;

	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	protected String templateStringValue(String value, Integer index) {
		String returnString = value;
		if (index != null && value.contains("${index}")) {
			returnString = returnString.replace("${index}", index.toString());
		}
		if (value.contains("${random}")) {
			returnString = returnString.replace("${random}", UUID.randomUUID().toString().substring(0, 8));
		}
		return returnString;
	}

	protected abstract String authorization(String username, String password);

	protected abstract void assertThat(int actual, int expected);

	protected abstract void assertThat(Object actual, Object expected);

	protected abstract void assertIsNull(Object actual);

}




/******* S.D.G. *******/


