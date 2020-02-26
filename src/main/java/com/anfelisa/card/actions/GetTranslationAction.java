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

package com.anfelisa.card.actions;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetTranslationAction extends AbstractGetTranslationAction {

	static final Logger LOG = LoggerFactory.getLogger(GetTranslationAction.class);

	public GetTranslationAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(jdbi, appConfiguration, daoProvider, viewProvider, e2e);
	}

	@SuppressWarnings("unchecked")
	protected void loadDataForGetRequest(Handle readonlyHandle) {
		try {
			String translationApiKey = appConfiguration.getTranslationApiKey();
			String urlStr = "https://api.deepl.com/v2/translate?"
					+ "auth_key=" + translationApiKey +
					"&text=" + URLEncoder.encode(this.actionData.getSourceValue(), "UTF-8") +
					"&source_lang=" + this.actionData.getSourceLanguage().toUpperCase() +
					"&target_lang=" + this.actionData.getTargetLanguage().toUpperCase();
			URL url = new URL(urlStr);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(url, Map.class);
			List<Map<String, Object>> translations = (List<Map<String, Object>>) map.get("translations");
			for (Map<String, Object> translation : translations) {
				this.actionData.setTargetValue(translation.get("text").toString());
			}
		} catch (Exception e) {
			//LOG.error(e.getMessage(), e);
			this.actionData.setTargetValue("");
			//App.reportException(e);
		}
	}

	public void initActionData() {
	}

}

/******* S.D.G. *******/
