package com.anfelisa.category.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractUserAccessToCategoryDao {
	
	public void insert(Handle handle, IUserAccessToCategoryModel userAccessToCategoryModel) {
		Update statement = handle.createUpdate("INSERT INTO public.useraccesstocategory (categoryid, userid) VALUES (:categoryid, :userid)");
		statement.bind("categoryid",  userAccessToCategoryModel.getCategoryId() );
		statement.bind("userid",  userAccessToCategoryModel.getUserId() );
		statement.execute();
	}
	
	
	
	public List<IUserAccessToCategoryModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT categoryid, userid FROM public.useraccesstocategory")
			.map(new UserAccessToCategoryMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE public.useraccesstocategory CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
