package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxOfCourseDao {

	public IBoxOfCourseModel select(Handle handle, String boxId, String courseId) {
		return handle
				.createQuery("SELECT * FROM public.boxofcourse WHERE boxId = :boxId AND courseId = :courseId")
				.bind("boxId", boxId)
				.bind("courseId", courseId)
				.map(new BoxOfCourseMapper())
				.first();
	}
	public List<IBoxOfCourseModel> selectByBoxId(Handle handle, String boxId) {
		return handle
				.createQuery("SELECT * FROM public.boxofcourse WHERE boxId = :boxId")
				.bind("boxId", boxId)
				.map(new BoxOfCourseMapper()).list();
	}
	public void updateAutoAdd(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("UPDATE public.boxofcourse SET autoadd=:autoAdd WHERE boxId = :boxId AND courseId = :courseId");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
}

/* S.D.G. */
