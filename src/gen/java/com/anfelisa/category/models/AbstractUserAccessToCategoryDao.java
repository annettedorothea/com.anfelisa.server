/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.models;

import de.acegen.PersistenceHandle;
import de.acegen.AbstractDao;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractUserAccessToCategoryDao extends AbstractDao {
	
	public void insert(PersistenceHandle handle, IUserAccessToCategoryModel userAccessToCategoryModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"useraccesstocategory\" (categoryid, userid, editable) VALUES (:categoryid, :userid, :editable)");
		statement.bind("categoryid",  userAccessToCategoryModel.getCategoryId() );
		statement.bind("userid",  userAccessToCategoryModel.getUserId() );
		statement.bind("editable",  userAccessToCategoryModel.getEditable() );
		statement.execute();
	}
	
	
	
	public IUserAccessToCategoryModel selectByPrimaryKey(PersistenceHandle handle, String categoryId, String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.getHandle().createQuery("SELECT categoryid, userid, editable FROM \"useraccesstocategory\" WHERE categoryid = :categoryid AND userid = :userid")
			.bind("categoryid", categoryId)
			.bind("userid", userId)
			.map(new UserAccessToCategoryMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"useraccesstocategory\"";
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

	public List<IUserAccessToCategoryModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT categoryid, userid, editable FROM \"useraccesstocategory\"")
			.map(new UserAccessToCategoryMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"useraccesstocategory\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



