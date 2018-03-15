package com.anfelisa.ace;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

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
import com.anfelisa.user.models.UserModel;

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

		userDao.insert(handle, new UserModel("Annette", "ddb4524e162d7d44c09903f7e2943cf1", "Pohl", "Annette",
				"annette_pohl@web.de", "ADMIN", true));
		
		handle.createStatement("SELECT setval('box_boxid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('card_cardid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('course_courseid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('lesson_lessonid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('loginlog_loginlogid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('result_resultid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('scheduledcard_scheduledcardid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('scoredcard_scoredcardid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('test_testid_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('timeline_id_seq', 1, false)").execute();
		handle.createStatement("SELECT setval('errortimeline_id_seq', 1, false)").execute();

	}

}

