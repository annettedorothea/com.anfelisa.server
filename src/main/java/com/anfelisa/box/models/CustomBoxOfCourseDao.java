package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxOfCourseDao {

	public IBoxOfCourseModel select(Handle handle, Integer boxId, Integer courseId) {
		return handle
				.createQuery("SELECT * FROM anfelisa.boxofcourse WHERE boxId = :boxId AND courseId = :courseId")
				.bind("boxId", boxId)
				.bind("courseId", courseId)
				.map(new BoxOfCourseMapper())
				.first();
	}
	public List<IBoxOfCourseModel> selectByBoxId(Handle handle, Integer boxId) {
		return handle
				.createQuery("SELECT * FROM anfelisa.boxofcourse WHERE boxId = :boxId")
				.bind("boxId", boxId)
				.map(new BoxOfCourseMapper()).list();
	}
	public void updateAutoAdd(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.boxofcourse SET autoadd=:autoAdd WHERE boxId = :boxId AND courseId = :courseId");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
}

/* S.D.G. */
