package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseListData;


public abstract class AbstractLoadPublicCoursesAction extends Action<CourseListData> {

	public AbstractLoadPublicCoursesAction(DBI jdbi) {
		super("LoadPublicCoursesAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
