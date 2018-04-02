package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScoredCardDao;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.StudentOfCourseDao;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;

public class AppUtils {

	private static BoxDao boxDao = new BoxDao();
	private static BoxOfCourseDao boxOfCourseDao = new BoxOfCourseDao();
	private static CardDao cardDao = new CardDao();
	private static CourseDao courseDao = new CourseDao();
	private static LessonDao lessonDao = new LessonDao();
	private static LoginLogDao loginLogDao = new LoginLogDao();
	private static ResultDao resultDao = new ResultDao();
	private static ScheduledCardDao scheduledCardDao = new ScheduledCardDao();
	private static ScoredCardDao scoredCardDao = new ScoredCardDao();
	private static StudentOfCourseDao studentOfCourseDao = new StudentOfCourseDao();
	private static TestDao testDao = new TestDao();
	private static UserDao userDao = new UserDao();

	public static void truncateAllViews(Handle handle) {
		resultDao.truncate(handle);
		scoredCardDao.truncate(handle);
		scheduledCardDao.truncate(handle);
		cardDao.truncate(handle);
		loginLogDao.truncate(handle);
		studentOfCourseDao.truncate(handle);
		testDao.truncate(handle);
		boxOfCourseDao.truncate(handle);
		lessonDao.truncate(handle);
		boxDao.truncate(handle);
		courseDao.truncate(handle);
		userDao.truncate(handle);
	}

}

