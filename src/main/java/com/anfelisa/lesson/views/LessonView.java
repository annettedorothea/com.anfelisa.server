package com.anfelisa.lesson.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.lesson.data.LessonCreationData;
import com.anfelisa.lesson.data.LessonData;
import com.anfelisa.lesson.models.LessonDao;

public class LessonView {

	private static LessonDao lessonDao = new LessonDao();

	public static BiConsumer<LessonCreationData, Handle> createLesson = (dataContainer, handle) -> {
		Integer lessonId = lessonDao.insert(handle, dataContainer);
		dataContainer.setCreatedId("" + lessonId);
	};

	public static BiConsumer<LessonData, Handle> updateLesson = (dataContainer, handle) -> {
		lessonDao.updateByLessonId(handle, dataContainer);
	};

}

/* S.D.G. */
