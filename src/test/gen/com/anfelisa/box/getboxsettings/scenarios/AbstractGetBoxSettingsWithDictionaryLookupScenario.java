/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.getboxsettings.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.SquishyDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractGetBoxSettingsWithDictionaryLookupScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxSettingsWithDictionaryLookupScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			if (response_0.getStatusCode() >= 400) {
				String statusMessage = response_0.getStatusMessage() != null ? response_0.getStatusMessage() : "";
				String message = "GIVEN RegisterUser fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

		if (prerequisite("CreateBoxDictionaryLookup")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"maxCardsPerDay\" : 10," + 
			"\"dictionaryLookup\" : true," + 
			"\"givenLanguage\" : \"de\"," + 
			"\"wantedLanguage\" : \"en\"} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN CreateBoxDictionaryLookup fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxDictionaryLookup fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxDictionaryLookup success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxDictionaryLookup not met");
		}

	}
	
	private HttpResponse<com.anfelisa.box.data.GetBoxSettingsResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.box.data.BoxSettingsWrapperData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.BoxSettingsWrapperData.class);
		HttpResponse<com.anfelisa.box.data.GetBoxSettingsResponse> response = 
		this.httpGet(
			"/box/settings/" + data_0.getBoxId() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			com.anfelisa.box.data.GetBoxSettingsResponse.class
		);
		
		LOG.info("WHEN: GetBoxSettings finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetBoxSettings", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.box.data.GetBoxSettingsResponse then(HttpResponse<com.anfelisa.box.data.GetBoxSettingsResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 200) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 200: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
				com.anfelisa.box.data.GetBoxSettingsResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

					com.anfelisa.box.data.BoxSettingsWrapperData expectedData = objectMapper.readValue("{" +
						"\"uuid\" : \"\"," + 
						"\"boxSettings\" : { \"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
						"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
						"\"categoryName\" : \"cat\"," + 
						"\"dictionaryLookup\" : true," + 
						"\"givenLanguage\" : \"de\"," + 
						"\"wantedLanguage\" : \"en\"," + 
						"\"maxCardsPerDay\" : 10," + 
						"\"allActiveCards\" : 0," + 
						"\"allCards\" : 0," + 
						"\"shared\" : false}} ",
					com.anfelisa.box.data.BoxSettingsWrapperData.class);
					
					com.anfelisa.box.data.GetBoxSettingsResponse expected = new com.anfelisa.box.data.GetBoxSettingsResponse(expectedData);
					
					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetBoxSettingsWithDictionaryLookup")) {
			HttpResponse<com.anfelisa.box.data.GetBoxSettingsResponse> response = when();

			com.anfelisa.box.data.GetBoxSettingsResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetBoxSettingsWithDictionaryLookup not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetBoxSettingsWithDictionaryLookup";
	}
	
}



/******* S.D.G. *******/



