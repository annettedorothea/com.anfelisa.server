package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class BoxDao {
	
	public void insert(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("INSERT INTO public.box (boxid, name, username) VALUES (:boxid, :name, :username)");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("name",  boxModel.getName() );
		statement.bind("username",  boxModel.getUsername() );
		statement.execute();
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE public.box SET boxid = :boxid, name = :name, username = :username WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("name",  boxModel.getName() );
		statement.bind("username",  boxModel.getUsername() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, String boxId) {
		Update statement = handle.createStatement("DELETE FROM public.box WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, String boxId) {
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
		Update statement = handle.createStatement("TRUNCATE public.box CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
