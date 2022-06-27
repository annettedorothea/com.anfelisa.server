package com.anfelisa.box.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.box.data.IBoxUpdateData;

import de.acegen.PersistenceHandle;

public class BoxDao extends AbstractBoxDao {

	public List<IBoxViewModel> selectByUserId(PersistenceHandle handle, String userId, LocalDateTime today) {
		LocalDateTime endOfDay = today.plusDays(1);
		return handle.getHandle().createQuery("SELECT "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard "
				+ "WHERE boxid = b.boxid "
				+ "AND quality is null "
				+ "AND scheduledDate >= :today "
				+ "AND scheduledDate < :endofday) + "
				+ "(select count(reinforcecardid) from public.reinforcecard "
				+ "where boxid = b.boxid ) as openTodaysCards, "
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryauthor, c.categoryindex, b.reverse, b.archived, "
				+ "((select count(uac.userid) from useraccesstocategory uac where b.categoryid = uac.categoryid and uac.userid != :userid and editable = 'false') = 0 OR "
				+ "(select count(uac.userid) from useraccesstocategory uac where b.categoryid = uac.categoryid and uac.userid != :userid and editable = 'true') > 0 OR "
				+ "(select editable from useraccesstocategory where userid = :userid and categoryid = b.categoryid) = 'false') as deletable,"
				+ "(select editable from useraccesstocategory where userid = :userid and categoryid = b.categoryid) as editable "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid "
				+ "where userid = :userid "
				+ "order by b.archived, c.categoryname, b.reverse")
				.bind("userid", userId)
				.bind("today", today)
				.bind("endofday", endOfDay)
				.map(new BoxViewMapper()).list();
	}

	public List<Integer> selectCountOfDay(PersistenceHandle handle, String boxId, LocalDateTime day) {
		LocalDateTime day1 = day.plusDays(1);
		LocalDateTime day2 = day1.plusDays(1);
		LocalDateTime day3 = day1.plusDays(2);
		LocalDateTime day4 = day1.plusDays(3);
		LocalDateTime day5 = day1.plusDays(4);
		LocalDateTime day6 = day1.plusDays(5);
		LocalDateTime day7 = day1.plusDays(6);
		LocalDateTime day8 = day1.plusDays(7);
		return handle.getHandle().createQuery("select count from ("
				+ "SELECT count(scheduledcardid) as count, 1 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day1 AND scheduledDate < :day2 UNION "
				+ "SELECT count(scheduledcardid) as count, 2 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day2 AND scheduledDate < :day3 UNION "
				+ "SELECT count(scheduledcardid) as count, 3 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day3 AND scheduledDate < :day4 UNION "
				+ "SELECT count(scheduledcardid) as count, 4 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day4 AND scheduledDate < :day5 UNION "
				+ "SELECT count(scheduledcardid) as count, 5 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day5 AND scheduledDate < :day6 UNION "
				+ "SELECT count(scheduledcardid) as count, 6 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day6 AND scheduledDate < :day7 UNION "
				+ "SELECT count(scheduledcardid) as count, 7 as day FROM public.scheduledcard WHERE boxid = :boxid AND quality is null AND scheduledDate >= :day7 AND scheduledDate < :day8) as countOfDays order by day"
				)
				.bind("boxid", boxId)
				.bind("day1", day1)
				.bind("day2", day2)
				.bind("day3", day3)
				.bind("day4", day4)
				.bind("day5", day5)
				.bind("day6", day6)
				.bind("day7", day7)
				.bind("day8", day8)
				.mapTo(Integer.class).list();
	}
	
	public List<IBoxStatisticsModel> selectStatisticsByUserId(PersistenceHandle handle, String userId) {
 		return handle.getHandle().createQuery("SELECT "
				+ "b.boxid, b.maxcardsperday, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 0) as quality0Count, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 1) as quality1Count, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 2) as quality2Count, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 3) as quality3Count, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 4) as quality4Count, "
				+ "(select count(*) from (SELECT lastquality FROM scheduledcard where boxid = b.boxid and quality is null and scheduleddate is not null) as qualities where lastquality = 5) as quality5Count "
 				+ "FROM public.box b "
 				+ "where userid = :userid and b.archived = false")
 				.bind("userid", userId)
				.map(new BoxStatisticsMapper()).list();
	}
	
	public ITodaysCardsStatusModel todaysCardsStatus(PersistenceHandle handle, String boxId, LocalDateTime today) {
		LocalDateTime endOfDay = today.plusDays(1);
		Optional<ITodaysCardsStatusModel> optional = handle.getHandle().createQuery("SELECT "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard "
				+ "WHERE boxid = :boxid "
				+ "AND scheduledDate >= :today "
				+ "and scheduledDate < :endofday) as allTodaysCards, "
				+ "(SELECT count(scheduledcardid) FROM public.scheduledcard "
				+ "WHERE boxid = :boxid "
				+ "AND quality is null "
				+ "AND scheduledDate >= :today "
				+ "AND scheduledDate < :endofday) + "
				+ "(select count(reinforcecardid) from public.reinforcecard where boxid = :boxid ) as openTodaysCards")
				.bind("boxid", boxId)
				.bind("today", today)
				.bind("endofday", endOfDay)
				.map(new TodaysCardsStatusMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IInitBoxesModel> selectInitBoxesModelByUserId(PersistenceHandle handle, String userId, LocalDateTime today) {
		return handle.getHandle().createQuery("SELECT "
				+ "(select min(scheduleddate) from scheduledcard where boxid = b.boxid and quality is null) as minscheduleddate, "
				+ "b.boxid "
				+ "FROM public.box b where userid = :userid and archived = false")
				.bind("userid", userId)
				.bind("today", today)
				.map(new InitBoxesMapper()).list();
	}

	public IBoxModel selectByCategoryIdAndUserId(PersistenceHandle handle, String categoryId, String userId, Boolean reverse) {
		Optional<IBoxModel> optional = handle.getHandle().createQuery(
				"SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived FROM public.box "
				+ "WHERE categoryid = :categoryid and userid = :userid and reverse = :reverse")
				.bind("categoryid", categoryId)
				.bind("userid", userId)
				.bind("reverse", reverse)
				.map(new BoxMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateBox(PersistenceHandle handle, IBoxUpdateData boxModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.box SET maxinterval = :maxinterval, maxcardsperday = :maxcardsperday WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("maxinterval", boxModel.getMaxInterval());
		statement.bind("maxcardsperday", boxModel.getMaxCardsPerDay());
		statement.execute();
	}

	public IBoxSettingsModel selectSettingsByBoxId(PersistenceHandle handle, String boxId) {
		Optional<IBoxSettingsModel> optional = handle.getHandle().createQuery("SELECT "
				+ "b.boxId, b.maxinterval, b.maxcardsperday,"
				+ "c.categoryname, c.dictionarylookup, c.givenlanguage, c.wantedLanguage, c.categoryid,"
				+ "(select count(cardid) from card where rootcategoryid = c.categoryid) as allcards,"
				+ "(select count(scheduledcardid) from scheduledcard where boxid = :boxid and quality is null AND scheduleddate is not null) as allactivecards, "
				+ "(select count(uac.userid) from useraccesstocategory uac where b.categoryid = uac.categoryid and uac.userid != b.userid) > 0 as shared "
				+ "FROM \"box\" b, category c "
				+ "WHERE b.boxid = :boxid "
				+ "AND c.categoryid = b.categoryid")
				.bind("boxid", boxId)
				.map(new BoxSettingsMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void deleteByUserId(PersistenceHandle handle, String userId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM box WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.execute();
	}

	public List<IBoxModel> selectAllOfUser(PersistenceHandle handle, String userId) {
		return handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived FROM box "
				+ "WHERE userid = :userid")
				.bind("userid", userId)
				.map(new BoxMapper())
				.list();
	}

	public void archive(PersistenceHandle handle, String boxId, Boolean archived) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.box SET archived = :archived WHERE boxId = :boxId");
		statement.bind("boxId", boxId);
		statement.bind("archived", archived);
		statement.execute();
	}
	
}

/* S.D.G. */