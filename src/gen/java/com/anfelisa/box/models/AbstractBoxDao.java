/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import de.acegen.AbstractDao;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractBoxDao extends AbstractDao {
	
	public void insert(PersistenceHandle handle, com.anfelisa.box.models.BoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"box\" (boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived) VALUES (:boxid, :userid, :categoryid, :maxinterval, :maxcardsperday, :reverse, :archived)");
		statement.bind("boxid", boxModel.getBoxId());
		statement.bind("userid", boxModel.getUserId());
		statement.bind("categoryid", boxModel.getCategoryId());
		statement.bind("maxinterval", boxModel.getMaxInterval());
		statement.bind("maxcardsperday", boxModel.getMaxCardsPerDay());
		statement.bind("reverse", boxModel.getReverse());
		statement.bind("archived", boxModel.getArchived());
		statement.execute();
	}
	
	
	public void updateByBoxId(PersistenceHandle handle, com.anfelisa.box.models.BoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"box\" SET boxid = :boxid, userid = :userid, categoryid = :categoryid, maxinterval = :maxinterval, maxcardsperday = :maxcardsperday, reverse = :reverse, archived = :archived WHERE boxid = :boxid");
		statement.bind("boxid", boxModel.getBoxId());
		statement.bind("userid", boxModel.getUserId());
		statement.bind("categoryid", boxModel.getCategoryId());
		statement.bind("maxinterval", boxModel.getMaxInterval());
		statement.bind("maxcardsperday", boxModel.getMaxCardsPerDay());
		statement.bind("reverse", boxModel.getReverse());
		statement.bind("archived", boxModel.getArchived());
		statement.execute();
	}

	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"box\" WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public com.anfelisa.box.models.BoxModel selectByBoxId(PersistenceHandle handle, String boxId) {
		Optional<com.anfelisa.box.models.BoxModel> optional = handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived FROM \"box\" WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public com.anfelisa.box.models.BoxModel selectByPrimaryKey(PersistenceHandle handle, String boxId) {
		Optional<com.anfelisa.box.models.BoxModel> optional = handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived FROM \"box\" WHERE boxid = :boxid")
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

	public List<com.anfelisa.box.models.BoxModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday, reverse, archived FROM \"box\"")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"box\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



