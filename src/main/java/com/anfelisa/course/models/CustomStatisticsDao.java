package com.anfelisa.course.models;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;

public class CustomStatisticsDao {
	public List<IStatisticsItemModel> selectStatistics(Handle handle, String username, DateTime startDate, DateTime endDate) {
		return handle.createQuery("select * from ("
				+ "select 'test' as type, count(*), result.date as timestamp, course.name as name, "
				+ "sum(points) as points, sum(maxpoints) as maxpoints from anfelisa.result "
				+ "inner join anfelisa.test on result.testId = test.testId "
				+ "inner join anfelisa.lesson on test.lessonId = lesson.lessonId "
				+ "inner join anfelisa.course on lesson.courseId = course.courseId where anfelisa.result.username = :username "
				+ "and date >= :startDate " + "and date < :endDate " + "group by date, course.name " + "union "
				+ "select 'box' as type, count(*), date_trunc('day', timestamp) \"day\", box.name as name, "
				+ "sum(scoredcard.points) as points, sum(card.maxpoints) as maxpoints from anfelisa.scoredcard "
				+ "inner join anfelisa.box on scoredcard.boxid = box.boxid "
				+ "inner join anfelisa.card on scoredcard.cardid = card.cardid "
				+ "where box.username = :username and timestamp >= :startDate "
				+ "and timestamp < :endDate " + "group by day, name) as statistics order by timestamp, name")
				.bind("username", username).bind("startDate", startDate).bind("endDate", endDate)
				.map(new StatisticsItemMapper()).list();

	}
}