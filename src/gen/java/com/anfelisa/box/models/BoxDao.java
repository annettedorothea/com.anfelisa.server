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
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.box (boxid serial NOT NULL  , name character varying NOT NULL  , username character varying NOT NULL  , CONSTRAINT box_pkey PRIMARY KEY (boxid), CONSTRAINT box_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT box_boxId_unique UNIQUE (boxId))");
	}
	
	public Integer insert(Handle handle, IBoxModel boxModel) {
		if (boxModel.getBoxId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.box (boxid, name, username) VALUES (:boxid, :name, :username)");
			statement.bind("boxid",  boxModel.getBoxId() );
			statement.bind("name",  boxModel.getName() );
			statement.bind("username",  boxModel.getUsername() );
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.box_boxid_seq', (SELECT MAX(boxid) FROM anfelisa.box));").execute();
			return boxModel.getBoxId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.box (name, username) VALUES (:name, :username) RETURNING boxid");
			statement.bind("name",  boxModel.getName() );
			statement.bind("username",  boxModel.getUsername() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("boxid");
		}
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.box SET boxid = :boxid, name = :name, username = :username WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("name",  boxModel.getName() );
		statement.bind("username",  boxModel.getUsername() );
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, Integer boxId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.box WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, Integer boxId) {
		return handle.createQuery("SELECT * FROM anfelisa.box WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.first();
	}
	
	public List<IBoxModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.box")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE anfelisa.box");
		statement.execute();
	}

}

/*       S.D.G.       */
