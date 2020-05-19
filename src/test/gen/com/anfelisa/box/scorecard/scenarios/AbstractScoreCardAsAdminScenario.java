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




package com.anfelisa.box.scorecard.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractScoreCardAsAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScoreCardAsAdminScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: RegisterUserAdmin uuid " + uuid);
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class),
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"admin-password\"," + 
					"\"username\" : \"Admin\"} ",
			com.anfelisa.user.data.UserRegistrationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort());
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUserAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}
		

		if (prerequisite("CreateBoxMinimalAsAdmin")) {
			uuid = "adminBox-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin uuid " + uuid);
			response = 
			com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimalAsAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}
		

		if (prerequisite("CreateCategoryAsAdmin")) {
			uuid = "adminCat-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCategoryAsAdmin uuid " + uuid);
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"c\"," + 
					"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategoryAsAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}
		

		if (prerequisite("CreateCardAsAdmin")) {
			uuid = "c6-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCardAsAdmin uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCardAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCardAsAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCardAsAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCardAsAdmin not met");
		}
		

		if (prerequisite("ScheduleCardsAsAdmin")) {
			uuid = "sc6-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: ScheduleCardsAsAdmin uuid " + uuid);
			this.callNotReplayableDataProviderPutSystemTime(uuid, DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC), 
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.box.ActionCalls.callScheduleCards(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCardsAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCardsAsAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCardsAsAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCardsAsAdmin not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = "admin-score-${testId}".replace("${testId}", this.getTestId());
		this.callNotReplayableDataProviderPutSystemTime(uuid, DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC), 
					this.getProtocol(), this.getHost(), this.getPort());
		
		return 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"boxId\" : \"adminBox-" + this.getTestId() + "\"," + 
				"\"scoredCardQuality\" : 1," + 
				"\"scoredCardScheduledCardId\" : \"c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
		
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
			
				}
				
				@Test
				public void scoreCardAsAdmin() throws Exception {
					given();
						
					if (prerequisite("ScoreCardAsAdmin")) {
						Response response = when();
		
						LOG.info("WHEN: ScoreCard");
				
						then(response);
						
						verifications();
					} else {
						LOG.info("prerequisite for ScoreCardAsAdmin not met");
					}
				}
				
				protected abstract void verifications();
				
				@Override
				protected String scenarioName() {
					return "ScoreCardAsAdmin";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			
