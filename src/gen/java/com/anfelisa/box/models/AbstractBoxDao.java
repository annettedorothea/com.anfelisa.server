package com.anfelisa.box.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractBoxDao {
	
	public void insert(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createUpdate("INSERT INTO public.box (boxid, userid, categoryid, maxinterval) VALUES (:boxid, :userid, :categoryid, :maxinterval)");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.execute();
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createUpdate("UPDATE public.box SET boxid = :boxid, userid = :userid, categoryid = :categoryid, maxinterval = :maxinterval WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, String boxId) {
		Update statement = handle.createUpdate("DELETE FROM public.box WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, String boxId) {
		Optional<IBoxModel> optional = handle.createQuery("SELECT boxid, userid, categoryid, maxinterval FROM public.box WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IBoxModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT boxid, userid, categoryid, maxinterval FROM public.box")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE public.box CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */