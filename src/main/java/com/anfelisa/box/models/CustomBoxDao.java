package com.anfelisa.box.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;
import org.joda.time.DateTime;

import com.anfelisa.box.data.BoxUpdateData;

public class CustomBoxDao {

	public List<IBoxInfoModel> selectByUserId(Handle handle, String userId, DateTime today) {
		return handle.createQuery("SELECT (SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = b.boxid AND quality is null AND scheduledDate <= :today) as todayscards, "
				+ "(select count(cardid) from card where rootcategoryid = b.categoryid) as totalcards, "
				+ "(select count(distinct(cardid)) from public.scheduledcard where boxid = b.boxid ) as mycards, "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = b.boxid ) as reinforcecards, "
				+ "(select date_part('day', age(:today::timestamp, (select min(scheduleddate) from scheduledcard where boxid = b.boxid and quality is null)::timestamp) )) as daysbehindschedule, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, b.maxinterval, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 0) as quality0Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 1) as quality1Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 2) as quality2Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 3) as quality3Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 4) as quality4Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 5) as quality5Count "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where userid = :userid order by c.categoryindex")
				.bind("userid", userId)
				.bind("today", today)
				.map(new BoxInfoMapper()).list();
	}
	
	public IBoxInfoModel selectByBoxId(Handle handle, String boxId, DateTime today) {
		Optional<IBoxInfoModel> optional =  handle.createQuery("SELECT (SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate <= :today) as todayscards, "
				+ "(select count(cardid) from card where rootcategoryid = b.categoryid) as totalcards, "
				+ "(select count(distinct(cardid)) from public.scheduledcard where boxid = :boxid ) as mycards, "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = :boxid ) as reinforcecards, "
				+ "(select date_part('day', age(:today::timestamp, (select min(scheduleddate) from scheduledcard where boxid = :boxid and quality is null)::timestamp) )) as daysbehindschedule, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, b.maxinterval, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 0) as quality0Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 1) as quality1Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 2) as quality2Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 3) as quality3Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 4) as quality4Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 5) as quality5Count "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where boxid = :boxid ")
				.bind("boxid", boxId)
				.bind("today", today)
				.map(new BoxInfoMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IBoxModel selectByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		Optional<IBoxModel> optional = handle.createQuery("SELECT boxid, userid, categoryid, maxinterval FROM public.box WHERE categoryid = :categoryid and userid = :userid")
			.bind("categoryid", categoryId)
			.bind("userid", userId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateBox(Handle handle, BoxUpdateData boxModel) {
		Update statement = handle.createUpdate("UPDATE public.box SET maxinterval = :maxinterval WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.execute();
	}

}

/* S.D.G. */