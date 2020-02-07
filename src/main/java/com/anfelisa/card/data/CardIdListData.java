package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardIdListData extends AbstractCardIdListData implements ICardIdListData {

	public CardIdListData(
			@JsonProperty("cardIdList") java.util.List<String> cardIdList,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("userId") String userId,
			@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards,
			@JsonProperty("uuid") String uuid) {
		super(
				cardIdList,
				categoryId,
				userId,
				movedCards,
				uuid);
	}

	public CardIdListData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
