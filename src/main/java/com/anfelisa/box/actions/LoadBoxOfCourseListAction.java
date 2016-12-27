package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxOfCourseListData;
import com.anfelisa.box.models.CourseToBoxAdditionModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICourseToBoxAdditionModel;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.IMyCourseModel;

public class LoadBoxOfCourseListAction extends AbstractLoadBoxOfCourseListAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxOfCourseListAction.class);

	public LoadBoxOfCourseListAction(BoxOfCourseListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system
		// time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		List<ICourseToBoxAdditionModel> list = new ArrayList<ICourseToBoxAdditionModel>();
		List<IMyCourseModel> myCourses = CustomCourseDao.selectMyCourses(this.databaseHandle.getHandle(), this.actionData.getSchema(), this.actionData.getUsername());
		for (IMyCourseModel myCourse : myCourses) {
			IBoxOfCourseModel boxOfCourse = CustomBoxDao.selectByCourseId(this.databaseHandle.getHandle(), this.actionData.getSchema(), myCourse.getCourseId(), this.actionData.getUsername());
			if (boxOfCourse == null) {
				ICourseToBoxAdditionModel model = new CourseToBoxAdditionModel(null, myCourse.getCourseId(), null, myCourse.getName());
				list.add(model);
			} else {
				ICourseToBoxAdditionModel model = new CourseToBoxAdditionModel(boxOfCourse.getBoxId(), myCourse.getCourseId(), boxOfCourse.getAutoAdd(), myCourse.getName());
				list.add(model);
			}
		}
		this.actionData.setCourseToBoxAdditionList(list);
	}

}

/* S.D.G. */
