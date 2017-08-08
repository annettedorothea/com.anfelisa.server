package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxDao {

	public List<IBoxModel> selectByUsername(Handle handle, String username) {
		return handle.createQuery("SELECT * FROM public.box where username = :username order by name")
				.bind("username", username).map(new BoxMapper()).list();
	}

	public IBoxModel selectByScheduledCardId(Handle handle, Integer scheduledCardId) {
		return handle
				.createQuery("SELECT b.* FROM public.scheduledCard sc inner join public.box b ON b.boxId = sc.boxId WHERE sc.scheduledCardId = :scheduledCardId")
				.bind("scheduledCardId", scheduledCardId).map(new BoxMapper()).first();
	}

	public void updateBox(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE public.box SET name = :name WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.execute();
	}

	public IBoxOfCourseModel selectBoxOfCourse(Handle handle, Integer courseId, String username,
			Integer boxId) {
		return handle
				.createQuery("SELECT bc.* FROM public.boxofcourse bc INNER JOIN public.box b on bc.boxId = b.boxId WHERE bc.courseId = :courseId AND b.username = :username AND bc.boxId = :boxId")
				.bind("courseId", courseId).bind("username", username).bind("boxId", boxId).map(new BoxOfCourseMapper())
				.first();
	}

	public List<IBoxModel> selectBoxesWhereCardMightBeAddedAfterEdit(Handle handle,
			Integer testId, String username) {
		return handle
				.createQuery("SELECT b.* FROM public.box b INNER JOIN public.boxOfCourse bc on b.boxId = bc.boxId "
						+ "INNER JOIN public.course c on bc.courseId = c.courseId INNER JOIN public.lesson l on l.courseId = c.courseId INNER JOIN public.test t on t.lessonId = l.lessonId "
						+ "WHERE t.testId = :testId AND bc.autoAdd = false AND b.username = :username")
				.bind("username", username).bind("testId", testId).map(new BoxMapper()).list();

	}

}

/* S.D.G. */