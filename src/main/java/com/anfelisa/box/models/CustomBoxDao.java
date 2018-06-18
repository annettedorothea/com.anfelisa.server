package com.anfelisa.box.models;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.box.data.BoxUpdateData;

public class CustomBoxDao {

	public List<IBoxInfoModel> selectByUserId(Handle handle, String userId, DateTime today) {
		return handle.createQuery("SELECT (SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = b.boxid AND quality is null AND scheduledDate <= :today) as todayscards, "
				+ "(select count(cardid) from card where rootcategoryid = b.categoryid) as totalcards, "
				+ "(select count(distinct(cardid)) from public.scheduledcard where boxid = b.boxid ) as mycards, "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = b.boxid ) as reinforcecards, "
				+ "(select date_part('day', age(:today::timestamp, (select min(scheduleddate) from scheduledcard where boxid = b.boxid and quality is null)::timestamp) )) as daysbehindschedule, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, b.maxinterval "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where userid = :userid order by c.categoryindex")
				.bind("userid", userId)
				.bind("today", today)
				.map(new BoxInfoMapper()).list();
	}
	
	public IBoxInfoModel selectByBoxId(Handle handle, String boxId, DateTime today) {
		return handle.createQuery("SELECT (SELECT count(scheduledcardid) FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate <= :today) as todayscards, "
				+ "(select count(cardid) from card where rootcategoryid = b.categoryid) as totalcards, "
				+ "(select count(distinct(cardid)) from public.scheduledcard where boxid = :boxid ) as mycards, "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = :boxid ) as reinforcecards, "
				+ "(select date_part('day', age(:today::timestamp, (select min(scheduleddate) from scheduledcard where boxid = :boxid and quality is null)::timestamp) )) as daysbehindschedule, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, b.maxinterval "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where boxid = :boxid ")
				.bind("boxid", boxId)
				.bind("today", today)
				.map(new BoxInfoMapper()).first();
	}
	
	public void updateBox(Handle handle, BoxUpdateData boxModel) {
		Update statement = handle.createStatement("UPDATE public.box SET maxinterval = :maxinterval WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.execute();
	}

}

/* S.D.G. */