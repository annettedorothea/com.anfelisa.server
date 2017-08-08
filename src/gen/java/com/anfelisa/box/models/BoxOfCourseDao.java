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
		handle.execute("CREATE TABLE IF NOT EXISTS public.boxofcourse (boxid integer NOT NULL  , courseid integer NOT NULL  , autoadd boolean NOT NULL  , CONSTRAINT boxofcourse_boxid_fkey FOREIGN KEY (boxid) REFERENCES public.box ( boxid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT boxofcourse_courseid_fkey FOREIGN KEY (courseid) REFERENCES public.course ( courseid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public void insert(Handle handle, IBoxOfCourseModel boxOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO public.boxofcourse (boxid, courseid, autoadd) VALUES (:boxid, :courseid, :autoadd)");
		statement.bind("boxid",  boxOfCourseModel.getBoxId() );
		statement.bind("courseid",  boxOfCourseModel.getCourseId() );
		statement.bind("autoadd",  boxOfCourseModel.getAutoAdd() );
		statement.execute();
	}
	
	
	
	public List<IBoxOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.boxofcourse")
			.map(new BoxOfCourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.boxofcourse");
		statement.execute();
	}

}

/*       S.D.G.       */
