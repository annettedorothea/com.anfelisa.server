package com.anfelisa.lesson.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.lesson.data.LessonCreationData;
import com.anfelisa.lesson.data.LessonData;
import com.anfelisa.lesson.models.LessonDao;

public class LessonView {

	private LessonDao lessonDao = new LessonDao();

	public BiConsumer<LessonCreationData, Handle> createLesson = (dataContainer, handle) -> {
		Integer lessonId = lessonDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + lessonId);
	};

	public BiConsumer<LessonData, Handle> updateLesson = (dataContainer, handle) -> {
		lessonDao.updateByLessonId(handle, dataContainer, dataContainer.getSchema());
	};

}

/* S.D.G. */
