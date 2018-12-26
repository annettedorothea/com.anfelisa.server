package com.anfelisa.card.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.App;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.fasterxml.jackson.core.type.TypeReference;

public class GetTranslationAction extends AbstractGetTranslationAction {

	static final Logger LOG = LoggerFactory.getLogger(GetTranslationAction.class);

	public GetTranslationAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	@SuppressWarnings("unchecked")
	protected final void loadDataForGetRequest() {
		try {
			String translationApiKey = appConfiguration.getTranslationApiKey();
			String urlStr = "https://translation.googleapis.com/language/translate/v2?key=" + translationApiKey + "&q="
					+ URLEncoder.encode(this.actionData.getSourceValue(), "UTF-8") + "&target="
					+ this.actionData.getTargetLanguage() + "&source=" + this.actionData.getSourceLanguage()
					+ "&format=text";
			URL url = new URL(urlStr);
			StringBuilder response = new StringBuilder();
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
			};
			HashMap<String, Object> o = mapper.readValue(response.toString(), typeRef);
			HashMap<String, Object> data = (HashMap<String, Object>)o.get("data");
			ArrayList<Object> translations = (ArrayList<Object>)data.get("translations");
			if (translations.size() > 0) {
				HashMap<String, Object> translation = (HashMap<String, Object>)translations.get(0);
				Object translatedText = translation.get("translatedText");
				this.actionData.setTargetValue(translatedText.toString());
			} else {
				this.actionData.setTargetValue("");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			this.actionData.setTargetValue("");
			App.reportException(e);
		}
	}

}

/*       S.D.G.       */
