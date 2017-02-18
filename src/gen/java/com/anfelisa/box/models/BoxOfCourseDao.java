package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class BoxOfCourseDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.boxofcourse (boxId integer NOT NULL  , courseId integer NOT NULL  , autoAdd boolean NOT NULL  , CONSTRAINT boxofcourse_boxId_fkey FOREIGN KEY (boxId) REFERENCES anfelisa.box ( boxId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT boxofcourse_courseId_fkey FOREIGN KEY (courseId) REFERENCES anfelisa.course ( courseId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public void insert(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO anfelisa.boxofcourse (boxId, courseId, autoAdd) VALUES (:boxId, :courseId, :autoAdd)");
		statement.bind("boxId", boxOfCourseModel.getBoxId());
		statement.bind("courseId", boxOfCourseModel.getCourseId());
		statement.bind("autoAdd", boxOfCourseModel.getAutoAdd());
		statement.execute();
	}
	
	
	
	public List<IBoxOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.boxofcourse")
			.map(new BoxOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
