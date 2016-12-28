package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxOfCourseDao {

	public static IBoxOfCourseModel select(Handle handle, String schema, Integer boxId, Integer courseId) {
		return handle
				.createQuery("SELECT * FROM " + schema + ".boxofcourse WHERE boxId = :boxId AND courseId = :courseId")
				.bind("boxId", boxId)
				.bind("courseId", courseId)
				.map(new BoxOfCourseMapper())
				.first();
	}
	public static void updateAutoAdd(Handle handle, String schema, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("UPDATE " + schema
				+ ".boxofcourse SET autoadd=:autoAdd WHERE boxId = :boxId AND courseId = :courseId");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
}

/* S.D.G. */
