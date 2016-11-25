package com.anfelisa.course.models;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;

public class CustomStatisticsDao {
	public static List<IStatisticsItemModel> selectStatistics(Handle handle, String username, DateTime startDate, DateTime endDate,
			String schema) {
		return handle.createQuery("select * from ("
				+ "select 'test' as type, count(*), result.date as timestamp, course.name as name, "
				+ "sum(points) as points, sum(maxpoints) as maxpoints from " + schema + ".result "
				+ "inner join " + schema + ".test on result.testid = test.id "
				+ "inner join " + schema + ".lesson on test.lessonid = lesson.id "
				+ "inner join " + schema + ".course on lesson.courseid = course.id " + "where " + schema + ".result.username = :username "
				+ "and date >= :startDate " + "and date < :endDate " + "group by date, course.name " + "union "
				+ "select 'box' as type, count(*), date_trunc('day', timestamp) \"day\", box.name as name, "
				+ "sum(cardofbox.points) as points, sum(card.maxpoints) as maxpoints from " + schema + ".cardofbox "
				+ "inner join " + schema + ".box on cardofbox.boxid = box.id "
				+ "inner join " + schema + ".card on cardofbox.cardid = card.id "
				+ "where box.username = :username and timestamp >= :startDate "
				+ "and timestamp < :endDate " + "group by day, name) as statistics order by timestamp, name")
				.bind("username", username).bind("startDate", startDate).bind("endDate", endDate)
				.map(new StatisticsItemMapper()).list();

	}
}