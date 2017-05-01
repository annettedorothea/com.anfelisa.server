package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class BoxOfCourseDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.boxofcourse (boxid integer NOT NULL  , courseid integer NOT NULL  , autoadd boolean NOT NULL  , CONSTRAINT boxofcourse_boxid_fkey FOREIGN KEY (boxid) REFERENCES anfelisa.box ( boxid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT boxofcourse_courseid_fkey FOREIGN KEY (courseid) REFERENCES anfelisa.course ( courseid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public void insert(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO anfelisa.boxofcourse (boxid, courseid, autoadd) VALUES (:boxid, :courseid, :autoadd)");
		statement.bind("boxid",  boxOfCourseModel.getBoxId() );
		statement.bind("courseid",  boxOfCourseModel.getCourseId() );
		statement.bind("autoadd",  boxOfCourseModel.getAutoAdd() );
		statement.execute();
	}
	
	
	
	public List<IBoxOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.boxofcourse")
			.map(new BoxOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
