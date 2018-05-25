package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.box.data.BoxUpdateData;

public class CustomBoxDao {

	public List<IBoxModel> selectByUsername(Handle handle, String username) {
		return handle.createQuery("SELECT * FROM public.box where username = :username order by name")
				.bind("username", username).map(new BoxMapper()).list();
	}

	public IBoxModel selectByScheduledCardId(Handle handle, String scheduledCardId) {
		return handle
				.createQuery("SELECT b.* FROM public.scheduledCard sc inner join public.box b ON b.boxId = sc.boxId WHERE sc.scheduledCardId = :scheduledCardId")
				.bind("scheduledCardId", scheduledCardId).map(new BoxMapper()).first();
	}

	public void updateBox(Handle handle, BoxUpdateData boxModel) {
		Update statement = handle.createStatement("UPDATE public.box SET name = :name, maxinterval = :maxinterval WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.execute();
	}

	public List<IBoxModel> selectBoxesWhereCardMightBeAddedAfterEdit(Handle handle,
			String testId, String username) {
		return handle
				.createQuery("SELECT b.* FROM public.box b INNER JOIN public.boxOfCourse bc on b.boxId = bc.boxId "
						+ "INNER JOIN public.course c on bc.courseId = c.courseId INNER JOIN public.lesson l on l.courseId = c.courseId INNER JOIN public.test t on t.lessonId = l.lessonId "
						+ "WHERE t.testId = :testId AND bc.autoAdd = false AND b.username = :username")
				.bind("username", username).bind("testId", testId).map(new BoxMapper()).list();

	}

}

/* S.D.G. */