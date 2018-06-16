package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ReinforceCardDao {
	
	public void insert(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createStatement("INSERT INTO public.reinforcecard (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.execute();
	}
	
	
	public void updateByReinforceCardId(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createStatement("UPDATE public.reinforcecard SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId()  );
		statement.execute();
	}

	public void deleteByReinforceCardId(Handle handle, String reinforceCardId) {
		Update statement = handle.createStatement("DELETE FROM public.reinforcecard WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByReinforceCardId(Handle handle, String reinforceCardId) {
		return handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard WHERE reinforcecardid = :reinforcecardid")
			.bind("reinforcecardid", reinforceCardId)
			.map(new ReinforceCardMapper())
			.first();
	}
	public void updateByScheduledCardId(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createStatement("UPDATE public.reinforcecard SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId()  );
		statement.execute();
	}

	public void deleteByScheduledCardId(Handle handle, String scheduledCardId) {
		Update statement = handle.createStatement("DELETE FROM public.reinforcecard WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByScheduledCardId(Handle handle, String scheduledCardId) {
		return handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ReinforceCardMapper())
			.first();
	}
	
	public List<IReinforceCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM public.reinforcecard")
			.map(new ReinforceCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.reinforcecard CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
