package com.anfelisa.box.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;
import org.joda.time.DateTime;

import com.anfelisa.box.data.IBoxUpdateData;

public class BoxDao extends AbstractBoxDao {
	public List<IBoxViewModel> selectByUserId(Handle handle, String userId, DateTime today) {
		DateTime endOfDay = today.plusDays(1);
		return handle.createQuery("SELECT "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = b.boxid AND scheduledDate >= :today and scheduledDate < :endofday) as allTodaysCards, "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = b.boxid AND quality is null AND scheduledDate < :endofday) + "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = b.boxid ) as openTodaysCards, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 0) as quality0Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 1) as quality1Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 2) as quality2Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 3) as quality3Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 4) as quality4Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 5) as quality5Count "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where userid = :userid order by c.categoryindex")
				.bind("userid", userId)
				.bind("today", today)
				.bind("endofday", endOfDay)
				.map(new BoxViewMapper()).list();
	}

	public ITodaysCardsStatusModel todaysCardsStatus(Handle handle, String boxId, DateTime today) {
		DateTime endOfDay = today.plusDays(1);
		Optional<ITodaysCardsStatusModel> optional = handle.createQuery("SELECT "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = :boxid AND scheduledDate >= :today and scheduledDate < :endofday) as allTodaysCards, "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate < :endofday) + "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = :boxid ) as openTodaysCards")
				.bind("boxid", boxId)
				.bind("today", today)
				.bind("endofday", endOfDay)
				.map(new TodaysCardsStatusMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IInitBoxesModel> selectInitBoxesModelByUserId(Handle handle, String userId, DateTime today) {
		return handle.createQuery("SELECT "
				+ "(select min(scheduleddate) from scheduledcard where boxid = b.boxid and quality is null) as minscheduleddate, "
				+ "b.boxid "
				+ "FROM public.box b where userid = :userid")
				.bind("userid", userId)
				.bind("today", today)
				.map(new InitBoxesMapper()).list();
	}

	public IBoxModel selectByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		Optional<IBoxModel> optional = handle.createQuery(
				"SELECT boxid, userid, categoryid, maxinterval, maxcardsperday FROM public.box WHERE categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId)
				.bind("userid", userId)
				.map(new BoxMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateBox(Handle handle, IBoxUpdateData boxModel) {
		Update statement = handle.createUpdate(
				"UPDATE public.box SET maxinterval = :maxinterval, maxcardsperday = :maxcardsperday WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("maxinterval", boxModel.getMaxInterval());
		statement.bind("maxcardsperday", boxModel.getMaxCardsPerDay());
		statement.execute();
	}

}

/* S.D.G. */