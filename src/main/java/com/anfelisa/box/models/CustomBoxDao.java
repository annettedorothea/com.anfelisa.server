package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxDao {

	public List<IBoxModel> selectByUsername(Handle handle, String username) {
		return handle.createQuery("SELECT * FROM anfelisa.box where username = :username order by name")
				.bind("username", username).map(new BoxMapper()).list();
	}

	public IBoxModel selectByScheduledCardId(Handle handle, Integer scheduledCardId) {
		return handle
				.createQuery("SELECT b.* FROM anfelisa.scheduledCard sc inner join anfelisa.box b ON b.boxId = sc.boxId WHERE sc.scheduledCardId = :scheduledCardId")
				.bind("scheduledCardId", scheduledCardId).map(new BoxMapper()).first();
	}

	public void updateBox(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.box SET name = :name WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.execute();
	}

	public IBoxOfCourseModel selectBoxOfCourse(Handle handle, Integer courseId, String username,
			Integer boxId) {
		return handle
				.createQuery("SELECT bc.* FROM anfelisa.boxofcourse bc INNER JOIN anfelisa.box b on bc.boxId = b.boxId WHERE bc.courseId = :courseId AND b.username = :username AND bc.boxId = :boxId")
				.bind("courseId", courseId).bind("username", username).bind("boxId", boxId).map(new BoxOfCourseMapper())
				.first();
	}

	public List<IBoxModel> selectBoxesWhereCardMightBeAddedAfterEdit(Handle handle,
			Integer testId, String username) {
		return handle
				.createQuery("SELECT b.* FROM anfelisa.box b INNER JOIN anfelisa.boxOfCourse bc on b.boxId = bc.boxId "
						+ "INNER JOIN anfelisa.course c on bc.courseId = c.courseId INNER JOIN anfelisa.lesson l on l.courseId = c.courseId INNER JOIN anfelisa.test t on t.lessonId = l.lessonId "
						+ "WHERE t.testId = :testId AND bc.autoAdd = false AND b.username = :username")
				.bind("username", username).bind("testId", testId).map(new BoxMapper()).list();

	}

}

/* S.D.G. */