package com.anfelisa.mandator.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class MandatorDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".mandator (id serial , mandatorId character varying , username character varying , password character varying , name character varying , prename character varying , email character varying , role character varying , emailConfirmed boolean , emailConfirmationHash character varying , CONSTRAINT mandator_pkey PRIMARY KEY (id), CONSTRAINT mandator_id_unique UNIQUE (id), CONSTRAINT mandator_mandatorId_unique UNIQUE (mandatorId))");
	}
	
	public static void insert(Handle handle, IMandatorModel mandatorModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".mandator (id, mandatorId, username, password, name, prename, email, role, emailConfirmed, emailConfirmationHash) VALUES (:id, :mandatorId, :username, :password, :name, :prename, :email, :role, :emailConfirmed, :emailConfirmationHash)");
		statement.bind("id", mandatorModel.getId());
		statement.bind("mandatorId", mandatorModel.getMandatorId());
		statement.bind("username", mandatorModel.getUsername());
		statement.bind("password", mandatorModel.getPassword());
		statement.bind("name", mandatorModel.getName());
		statement.bind("prename", mandatorModel.getPrename());
		statement.bind("email", mandatorModel.getEmail());
		statement.bind("role", mandatorModel.getRole());
		statement.bind("emailConfirmed", mandatorModel.getEmailConfirmed());
		statement.bind("emailConfirmationHash", mandatorModel.getEmailConfirmationHash());
		statement.execute();
	}
	
	public static void update(Handle handle, IMandatorModel mandatorModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".mandator SET id = :id, mandatorId = :mandatorId, username = :username, password = :password, name = :name, prename = :prename, email = :email, role = :role, emailConfirmed = :emailConfirmed, emailConfirmationHash = :emailConfirmationHash");
		statement.bind("id", mandatorModel.getId());
		statement.bind("mandatorId", mandatorModel.getMandatorId());
		statement.bind("username", mandatorModel.getUsername());
		statement.bind("password", mandatorModel.getPassword());
		statement.bind("name", mandatorModel.getName());
		statement.bind("prename", mandatorModel.getPrename());
		statement.bind("email", mandatorModel.getEmail());
		statement.bind("role", mandatorModel.getRole());
		statement.bind("emailConfirmed", mandatorModel.getEmailConfirmed());
		statement.bind("emailConfirmationHash", mandatorModel.getEmailConfirmationHash());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, IMandatorModel mandatorModel, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".mandator WHERE id = :id");
		statement.bind("id", mandatorModel.getId());
		statement.execute();
	}

	public static IMandatorModel selectById(Handle handle, IMandatorModel mandatorModel, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".mandator WHERE id = :id")
			.bind("id", mandatorModel.getId())
			.map(new MandatorMapper())
			.first();
	}
	
	public static List<IMandatorModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".mandator")
			.map(new MandatorMapper())
			.list();
	}
}

/*       S.D.G.       */
