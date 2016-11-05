package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class BoxOfCourseDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".boxofcourse (boxId integer NOT NULL , courseId integer NOT NULL , autoAdd boolean NOT NULL , CONSTRAINT boxofcourse_boxId_fkey FOREIGN KEY (boxId) REFERENCES " + schema + ".box ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT boxofcourse_courseId_fkey FOREIGN KEY (courseId) REFERENCES " + schema + ".course ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public static void insert(Handle handle, IBoxOfCourseModel boxOfCourseModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".boxofcourse (boxId, courseId, autoAdd) VALUES (:boxId, :courseId, :autoAdd)");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
	
	public static void update(Handle handle, IBoxOfCourseModel boxOfCourseModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".boxofcourse SET boxId = :boxId, courseId = :courseId, autoAdd = :autoAdd");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
	
	
	public static List<IBoxOfCourseModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".boxofcourse")
			.map(new BoxOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
