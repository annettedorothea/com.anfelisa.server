package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class BoxDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.box (boxId serial NOT NULL  , name character varying NOT NULL  , username character varying NOT NULL  , CONSTRAINT box_pkey PRIMARY KEY (boxId), CONSTRAINT box_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT box_boxId_unique UNIQUE (boxId))");
	}
	
	public Integer insert(Handle handle, IBoxModel boxModel) {
		if (boxModel.getBoxId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.box (boxId, name, username) VALUES (:boxId, :name, :username)");
			statement.bind("boxId", boxModel.getBoxId());
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.box_boxId_seq', (SELECT MAX(boxId) FROM anfelisa.box));").execute();
			return boxModel.getBoxId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.box (name, username) VALUES (:name, :username) RETURNING boxId");
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("boxId");
		}
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.box SET boxId = :boxId, name = :name, username = :username WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.bind("username", boxModel.getUsername());
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, Integer boxId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.box WHERE boxId = :boxId");
		statement.bind("boxId", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, Integer boxId) {
		return handle.createQuery("SELECT * FROM anfelisa.box WHERE boxId = :boxId")
			.bind("boxId", boxId)
			.map(new BoxMapper())
			.first();
	}
	
	public List<IBoxModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.box")
			.map(new BoxMapper())
			.list();
	}
}

/*       S.D.G.       */
