package com.anfelisa.user.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.user.data.UserInfoData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class GetUserInfoAction extends AbstractGetUserInfoAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserInfoAction.class);

	public GetUserInfoAction(UserInfoData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		
		IUserModel user = UserDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.actionData.getUsername(), this.actionData.getSchema());
		this.actionData.setEmail(user.getEmail());
		this.actionData.setName(user.getName());
		this.actionData.setPrename(user.getPrename());
		
		List<ICourseModel> courseList = CustomCourseDao.selectCourses(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), this.actionData.getUsername());
		this.actionData.setCourseList(courseList);
		
		List<IBoxModel> boxList = CustomBoxDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.actionParam.getSchema(), this.actionParam.getUsername());
		this.actionData.setBoxList(boxList);
	}

}

/*       S.D.G.       */
