package com.anfelisa.card.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.data.CardTranslationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import io.dropwizard.auth.Auth;

@Path("/card")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetTranslationAction extends AbstractGetTranslationAction {

	static final Logger LOG = LoggerFactory.getLogger(GetTranslationAction.class);

	private String translationApiKey;

	public GetTranslationAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
		this.translationApiKey = appConfiguration.getTranslationApiKey();
	}

	@GET
	@Timed
	@Path("/translation")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("sourceValue") String sourceValue,
			@NotNull @QueryParam("sourceLanguage") String sourceLanguage,
			@NotNull @QueryParam("targetLanguage") String targetLanguage, @NotNull @QueryParam("uuid") String uuid)
			throws JsonProcessingException {
		this.actionData = new CardTranslationData(uuid).withSourceLanguage(sourceLanguage).withSourceValue(sourceValue)
				.withTargetLanguage(targetLanguage);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		try {
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
			HashMap<String, Object> translation = (HashMap<String, Object>)translations.get(0);
			Object translatedText = translation.get("translatedText");
			this.actionData.setTargetValue(translatedText.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.actionData.setTargetValue("");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			this.actionData.setTargetValue("");
		} catch (IOException e) {
			e.printStackTrace();
			this.actionData.setTargetValue("");
		}
	}

}

/* S.D.G. */
