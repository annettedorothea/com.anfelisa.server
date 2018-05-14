package com.anfelisa.card.actions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

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

	@SuppressWarnings("unchecked")
	protected final void loadDataForGetRequest() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + translationApiKey
					+ "&text=" + this.actionData.getSourceValue() + "&lang=" + this.actionData.getSourceLanguage() + "-"
					+ this.actionData.getTargetLanguage() + "&format=plain");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			String json = response.toString();
			Map<Object, Object> model = mapper.readValue(json, Map.class);
			Object value = model.get("text");
			if (value != null) {
				this.actionData.setTargetValue(((List<String>)value).get(0));
			} else {
				this.actionData.setTargetValue("");
			}
		} catch (Exception e) {
			this.actionData.setTargetValue("");
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}

/* S.D.G. */
