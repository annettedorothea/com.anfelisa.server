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
public class BoxDao {
	
	public Integer insert(Handle handle, IBoxModel boxModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.box (name, username) VALUES (:name, :username) RETURNING boxid");
		statement.bind("name",  boxModel.getName() );
		statement.bind("username",  boxModel.getUsername() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("boxid");
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE public.box SET name = :name, username = :username WHERE boxid = :boxid");
		statement.bind("name",  boxModel.getName() );
		statement.bind("username",  boxModel.getUsername() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, Integer boxId) {
		Update statement = handle.createStatement("DELETE FROM public.box WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, Integer boxId) {
		return handle.createQuery("SELECT boxid, name, username FROM public.box WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.first();
	}
	
	public List<IBoxModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT boxid, name, username FROM public.box")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.box");
		statement.execute();
		statement = handle.createStatement("ALTER SEQUENCE public.box_boxId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
