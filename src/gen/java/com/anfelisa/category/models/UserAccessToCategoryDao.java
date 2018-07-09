package com.anfelisa.category.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class UserAccessToCategoryDao {
	
	public void insert(Handle handle, IUserAccessToCategoryModel userAccessToCategoryModel) {
		Update statement = handle.createStatement("INSERT INTO public.useraccesstocategory (categoryid, userid) VALUES (:categoryid, :userid)");
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
		Update statement = handle.createStatement("TRUNCATE public.useraccesstocategory CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
