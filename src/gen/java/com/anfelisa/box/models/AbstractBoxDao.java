/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractBoxDao {
	
	public void insert(PersistenceHandle handle, IBoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"box\" (boxid, userid, categoryid, maxinterval, maxcardsperday, reverse) VALUES (:boxid, :userid, :categoryid, :maxinterval, :maxcardsperday, :reverse)");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.bind("reverse",  boxModel.getReverse() );
		statement.execute();
	}
	
	
	public void updateByBoxId(PersistenceHandle handle, IBoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"box\" SET boxid = :boxid, userid = :userid, categoryid = :categoryid, maxinterval = :maxinterval, maxcardsperday = :maxcardsperday, reverse = :reverse WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.bind("reverse",  boxModel.getReverse() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"box\" WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(PersistenceHandle handle, String boxId) {
		Optional<IBoxModel> optional = handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse FROM \"box\" WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IBoxModel selectByPrimaryKey(PersistenceHandle handle, String boxId) {
		Optional<IBoxModel> optional = handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse FROM \"box\" WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"box\"";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<IBoxModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse FROM \"box\"")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"box\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



