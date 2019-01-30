package com.anfelisa.card.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.data.ICardIdListData;

@SuppressWarnings("all")
public interface ICardView {

	void insert(ICardCreationData data, Handle handle);
	void delete(ICardDeleteData data, Handle handle);
	void update(ICardUpdateData data, Handle handle);
	void moveCards(ICardIdListData data, Handle handle);

}

/*                    S.D.G.                    */
