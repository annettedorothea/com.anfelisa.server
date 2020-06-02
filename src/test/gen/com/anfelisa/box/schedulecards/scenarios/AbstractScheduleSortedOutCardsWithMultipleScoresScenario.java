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




package com.anfelisa.box.schedulecards.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractScheduleSortedOutCardsWithMultipleScoresScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduleSortedOutCardsWithMultipleScoresScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			response = 
			this.httpPost(
				"/category/create", 
				data_3,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateCard")) {
			uuid = "c1-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_4,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}
		

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_5 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given2\"," + 
					"\"image\" : \"image2\"," + 
					"\"wanted\" : \"wanted2\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_5,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateSecondCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateSecondCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCard not met");
		}
		

		if (prerequisite("CreateThirdCard")) {
			uuid = "c3-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_6 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"3given\"," + 
					"\"wanted\" : \"3wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_6,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateThirdCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateThirdCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateThirdCard not met");
		}
		

		if (prerequisite("CreateFourthCard")) {
			uuid = "c4-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_7 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"4given4\"," + 
					"\"wanted\" : \"4wanted4\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_7,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFourthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFourthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFourthCard not met");
		}
		

		if (prerequisite("CreateFifthCard")) {
			uuid = "c5-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_8 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"different\"," + 
					"\"wanted\" : \"different\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_8,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFifthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFifthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}
		

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduledCardsData data_9 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c3-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class);
			response = 
			this.httpPost(
				"/cards/schedule", 
				data_9,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCards fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success");
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}
		

		if (prerequisite("ScoreCard3")) {
			uuid = "score3-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_10 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_10,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard3 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard3 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard3 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard3 not met");
		}
		

		if (prerequisite("UpdateBoxMaxInterval")) {
			uuid = this.randomUUID();
			com.anfelisa.box.data.BoxUpdateData data_11 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"categoryName\" : \"changed\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 11," + 
					"\"maxInterval\" : 90} ",
			com.anfelisa.box.data.BoxUpdateData.class);
			response = 
			this.httpPut(
				"/box/update?uuid=" + data_11.getUuid() + "", 
				data_11,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN UpdateBoxMaxInterval fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: UpdateBoxMaxInterval fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: UpdateBoxMaxInterval success");
		} else {
			LOG.info("GIVEN: prerequisite for UpdateBoxMaxInterval not met");
		}
		

		if (prerequisite("ScoreCard31")) {
			uuid = "score31-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200425 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_12 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score3-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_12,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard31 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard31 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard31 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard31 not met");
		}
		

		if (prerequisite("ScoreCard32")) {
			uuid = "score32-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200515 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_13 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score31-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_13,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard32 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard32 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard32 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard32 not met");
		}
		

		if (prerequisite("ScoreCard33")) {
			uuid = "score33-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200615 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_14 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 4," + 
					"\"scoredCardScheduledCardId\" : \"score32-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_14,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard33 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard33 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard33 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard33 not met");
		}
		

		if (prerequisite("ScoreCard34")) {
			uuid = "score34-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200819 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_15 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 5," + 
					"\"scoredCardScheduledCardId\" : \"score33-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_15,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard34 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard34 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard34 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard34 not met");
		}
		

		if (prerequisite("ScoreCard35")) {
			uuid = "score35-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20201120 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_16 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score34-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_16,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard35 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard35 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard35 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard35 not met");
		}
		

		if (prerequisite("ScoreCard36")) {
			uuid = "score36-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20210301 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_17 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score35-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_17,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard36 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard36 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard36 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard36 not met");
		}
		

		if (prerequisite("ScoreCard37")) {
			uuid = "score37-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20210701 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_18 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score36-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_18,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard37 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard37 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard37 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard37 not met");
		}
		

		if (prerequisite("ScoreCard38")) {
			uuid = "score38-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20211001 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_19 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score37-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_19,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard38 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard38 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard38 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard38 not met");
		}
		

		if (prerequisite("ScoreCard39")) {
			uuid = "score39-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20220201 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_20 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
					"\"scoredCardQuality\" : 3," + 
					"\"scoredCardScheduledCardId\" : \"score38-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			response = 
			this.httpPost(
				"/card/score", 
				data_20,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard39 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard39 fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard39 success");
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard39 not met");
		}
		

		if (prerequisite("SortCardsOut")) {
			uuid = this.randomUUID();
			com.anfelisa.box.data.SortCardsOutData data_21 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.SortCardsOutData.class);
			response = 
			this.httpPost(
				"/cards/sort-out", 
				data_21,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN SortCardsOut fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: SortCardsOut fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: SortCardsOut success");
		} else {
			LOG.info("GIVEN: prerequisite for SortCardsOut not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = "reschedule-${testId}".replace("${testId}", this.getTestId());
		this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20220318 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
		com.anfelisa.box.data.ScheduledCardsData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"]} ",
		com.anfelisa.box.data.ScheduledCardsData.class);
		
		return 
		this.httpPost(
			"/cards/schedule", 
			data_0,
			authorization("Annette-${testId}", "password")
		);
		
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ScheduleSortedOutCardsWithMultipleScores")) {
			Response response = when();

			LOG.info("WHEN: ScheduleCards");
	
			then(response);
			
		
			verifications();
		} else {
			LOG.info("WHEN: prerequisite for ScheduleSortedOutCardsWithMultipleScores not met");
		}
	}
	
	protected abstract void verifications();
	
	
	
	@Override
	protected String scenarioName() {
		return "ScheduleSortedOutCardsWithMultipleScores";
	}

}



/******* S.D.G. *******/


			
