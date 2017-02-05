package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreModel.class)
public interface IScoreModel {

	Integer getCards();
	Integer getCardsForToday();
	Integer getCardsForTomorrow();
	Integer getCardsToBeReinforced();
	Integer getZero();
	Integer getOne();
	Integer getTwo();
	Integer getThree();
	Integer getFour();
	Integer getFive();
	Integer getNoQuality();
	org.joda.time.DateTime getNow();


}

/*       S.D.G.       */
