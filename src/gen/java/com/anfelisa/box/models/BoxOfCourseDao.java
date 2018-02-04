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
	
	public void insert(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO public.boxofcourse (boxid, courseid, autoadd) VALUES (:boxid, :courseid, :autoadd)");
		statement.bind("boxid",  boxOfCourseModel.getBoxId() );
		statement.bind("courseid",  boxOfCourseModel.getCourseId() );
		statement.bind("autoadd",  boxOfCourseModel.getAutoAdd() );
		statement.execute();
	}
	
	
	
	public List<IBoxOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT boxid, courseid, autoadd FROM public.boxofcourse")
			.map(new BoxOfCourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.boxofcourse CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
