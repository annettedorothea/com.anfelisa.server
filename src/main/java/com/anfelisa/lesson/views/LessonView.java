package com.anfelisa.lesson.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonCreationData;
import com.anfelisa.lesson.data.LessonData;
import com.anfelisa.lesson.data.LessonIdData;
import com.anfelisa.lesson.models.LessonDao;

public class LessonView {

	static final Logger LOG = LoggerFactory.getLogger(LessonView.class);

	private static LessonDao lessonDao = new LessonDao();

	public static BiConsumer<LessonCreationData, Handle> createLesson = (dataContainer, handle) -> {
		lessonDao.insert(handle, dataContainer);
	};

	public static BiConsumer<LessonData, Handle> updateLesson = (dataContainer, handle) -> {
		lessonDao.updateByLessonId(handle, dataContainer);
	};

	public static BiConsumer<LessonIdData, Handle> deleteLesson = (dataContainer, handle) -> {
		lessonDao.deleteByLessonId(handle, dataContainer.getLessonId());
	};

}

/* S.D.G. */
