/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.getboxes.scenarios;

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
public abstract class AbstractGetBoxesReverseScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxesReverseScenario.class);
	
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

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
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
				String message = "GIVEN CreateBoxMinimal fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}

		if (prerequisite("CreateReverseBox")) {
			uuid = "reverseBoxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateReverseBoxPayload payload_2 = objectMapper.readValue("{" +
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.CreateReverseBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/box/create-reverse", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN CreateReverseBox fails\n" + statusMessage;
				LOG.error("GIVEN: CreateReverseBox fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateReverseBox success in {} ms", response_2.getDuration());
			addToMetrics("CreateReverseBox", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateReverseBox not met");
		}

	}
	
	private HttpResponse<com.anfelisa.box.data.GetBoxesResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.box.data.BoxListData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"todayAtMidnightInUTC\" : \"2020-04-20T02:00\"} ",
				com.anfelisa.box.data.BoxListData.class);
		HttpResponse<com.anfelisa.box.data.GetBoxesResponse> response = 
		this.httpGet(
			"/boxes/my/?todayAtMidnightInUTC=" + data_0.getTodayAtMidnightInUTC() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			com.anfelisa.box.data.GetBoxesResponse.class
		);
		
		LOG.info("WHEN: GetBoxes finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetBoxes", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.box.data.GetBoxesResponse then(HttpResponse<com.anfelisa.box.data.GetBoxesResponse> response) throws Exception {
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
		
				com.anfelisa.box.data.GetBoxesResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

					com.anfelisa.box.data.BoxListData expectedData = objectMapper.readValue("{" +
						"\"uuid\" : \"\"," + 
						"\"boxList\" : [ { \"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
						"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
						"\"categoryName\" : \"cat\"," + 
						"\"openTodaysCards\" : 0," + 
						"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
						"\"editable\" : true," + 
						"\"reverse\" : false," + 
						"\"archived\" : false," + 
						"\"shared\" : false}," + 
						"{ \"boxId\" : \"reverseBoxId-" + this.getTestId() + "\"," + 
						"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
						"\"categoryName\" : \"cat\"," + 
						"\"openTodaysCards\" : 0," + 
						"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
						"\"editable\" : true," + 
						"\"reverse\" : true," + 
						"\"archived\" : false," + 
						"\"shared\" : false}]} ",
					com.anfelisa.box.data.BoxListData.class);
					
					com.anfelisa.box.data.GetBoxesResponse expected = new com.anfelisa.box.data.GetBoxesResponse(expectedData);
					
					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetBoxesReverse")) {
			HttpResponse<com.anfelisa.box.data.GetBoxesResponse> response = when();

			com.anfelisa.box.data.GetBoxesResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetBoxesReverse not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetBoxesReverse";
	}
	
}



/******* S.D.G. *******/



