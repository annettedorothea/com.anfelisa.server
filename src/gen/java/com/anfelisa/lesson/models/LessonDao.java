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
	
	public Integer insert(Handle handle, ILessonModel lessonModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.lesson (name, description, sequence, courseid, author) VALUES (:name, :description, :sequence, :courseid, :author) RETURNING lessonid");
		statement.bind("name",  lessonModel.getName() );
		statement.bind("description",  lessonModel.getDescription() );
		statement.bind("sequence",  lessonModel.getSequence() );
		statement.bind("courseid",  lessonModel.getCourseId() );
		statement.bind("author",  lessonModel.getAuthor() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("lessonid");
	}
	
	
	public void updateByLessonId(Handle handle, ILessonModel lessonModel) {
		Update statement = handle.createStatement("UPDATE public.lesson SET name = :name, description = :description, sequence = :sequence, courseid = :courseid, author = :author WHERE lessonid = :lessonid");
		statement.bind("name",  lessonModel.getName() );
		statement.bind("description",  lessonModel.getDescription() );
		statement.bind("sequence",  lessonModel.getSequence() );
		statement.bind("courseid",  lessonModel.getCourseId() );
		statement.bind("author",  lessonModel.getAuthor() );
		statement.bind("lessonid",  lessonModel.getLessonId()  );
		statement.execute();
	}

	public void deleteByLessonId(Handle handle, Integer lessonId) {
		Update statement = handle.createStatement("DELETE FROM public.lesson WHERE lessonid = :lessonid");
		statement.bind("lessonid", lessonId);
		statement.execute();
	}

	public ILessonModel selectByLessonId(Handle handle, Integer lessonId) {
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
		statement = handle.createStatement("ALTER SEQUENCE public.lesson_lessonId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
