package com.anfelisa.lesson.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class LessonDao {
	
	public void insert(Handle handle, ILessonModel lessonModel) {
		Update statement = handle.createStatement("INSERT INTO public.lesson (lessonid, name, description, sequence, courseid, author) VALUES (:lessonid, :name, :description, :sequence, :courseid, :author)");
		statement.bind("lessonid",  lessonModel.getLessonId() );
		statement.bind("name",  lessonModel.getName() );
		statement.bind("description",  lessonModel.getDescription() );
		statement.bind("sequence",  lessonModel.getSequence() );
		statement.bind("courseid",  lessonModel.getCourseId() );
		statement.bind("author",  lessonModel.getAuthor() );
		statement.execute();
	}
	
	
	public void updateByLessonId(Handle handle, ILessonModel lessonModel) {
		Update statement = handle.createStatement("UPDATE public.lesson SET lessonid = :lessonid, name = :name, description = :description, sequence = :sequence, courseid = :courseid, author = :author WHERE lessonid = :lessonid");
		statement.bind("lessonid",  lessonModel.getLessonId() );
		statement.bind("name",  lessonModel.getName() );
		statement.bind("description",  lessonModel.getDescription() );
		statement.bind("sequence",  lessonModel.getSequence() );
		statement.bind("courseid",  lessonModel.getCourseId() );
		statement.bind("author",  lessonModel.getAuthor() );
		statement.bind("lessonid",  lessonModel.getLessonId()  );
		statement.execute();
	}

	public void deleteByLessonId(Handle handle, String lessonId) {
		Update statement = handle.createStatement("DELETE FROM public.lesson WHERE lessonid = :lessonid");
		statement.bind("lessonid", lessonId);
		statement.execute();
	}

	public ILessonModel selectByLessonId(Handle handle, String lessonId) {
		return handle.createQuery("SELECT lessonid, name, description, sequence, courseid, author FROM public.lesson WHERE lessonid = :lessonid")
			.bind("lessonid", lessonId)
			.map(new LessonMapper())
			.first();
	}
	
	public List<ILessonModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT lessonid, name, description, sequence, courseid, author FROM public.lesson")
			.map(new LessonMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.lesson CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
