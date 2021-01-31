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
				+ "b.boxid, b.categoryid, c.categoryname, c.categoryindex, b.reverse, "
				+ "(select count(uac.userid) from useraccesstocategory uac where b.categoryid = uac.categoryid and uac.userid != :userid) > 0 as shared "
				+ "FROM public.box b inner join public.category c on c.categoryid = b.categoryid where userid = :userid order by c.categoryname, b.reverse")
				.bind("userid", userId)
				.bind("today", today)
				.bind("endofday", endOfDay)
				.map(new BoxViewMapper()).list();
	}

	public Integer selectCountOfDay(PersistenceHandle handle, String boxId, LocalDateTime day) {
		LocalDateTime endOfDay = day.plusDays(1);
		Optional<Integer> optional =  handle.getHandle().createQuery("SELECT count(scheduledcardid) "
				+ "FROM public.scheduledcard "
				+ "WHERE boxid = :boxid "
				+ "AND quality is null "
				+ "AND scheduledDate >= :day "
				+ "AND scheduledDate < :endofday")
				.bind("boxid", boxId)
				.bind("day", day)
				.bind("endofday", endOfDay)
				.mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IBoxStatisticsModel> selectStatisticsByUserId(PersistenceHandle handle, String userId) {
 		return handle.getHandle().createQuery("SELECT "
				+ "b.boxid, b.maxcardsperday, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 0) as quality0Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 1) as quality1Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 2) as quality2Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 3) as quality3Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 4) as quality4Count, "
				+ "(select count(*) from (SELECT DISTINCT ON (cardid) quality FROM scheduledcard where quality is not null and boxid = b.boxid ORDER BY cardid, scoreddate DESC) as qualities where quality = 5) as quality5Count "
 				+ "FROM public.box b where userid = :userid")
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
				+ "FROM public.box b where userid = :userid")
				.bind("userid", userId)
				.bind("today", today)
				.map(new InitBoxesMapper()).list();
	}

	public IBoxModel selectByCategoryIdAndUserId(PersistenceHandle handle, String categoryId, String userId, Boolean reverse) {
		Optional<IBoxModel> optional = handle.getHandle().createQuery(
				"SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse FROM public.box "
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
				+ "(select count(scheduledcardid) from scheduledcard where boxid = :boxid and quality is null AND scheduleddate is not null) as allactivecards "
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
		return handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse FROM box "
				+ "WHERE userid = :userid")
				.bind("userid", userId)
				.map(new BoxMapper())
				.list();
	}
	
}

/* S.D.G. */