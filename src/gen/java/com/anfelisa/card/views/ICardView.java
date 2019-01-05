package com.anfelisa.card.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.data.CardIdListData;

@SuppressWarnings("all")
public interface ICardView {

	void insert(CardCreationData data, Handle handle);
	void delete(CardDeleteData data, Handle handle);
	void update(CardUpdateData data, Handle handle);
	void moveCards(CardIdListData data, Handle handle);

}

/*                    S.D.G.                    */
