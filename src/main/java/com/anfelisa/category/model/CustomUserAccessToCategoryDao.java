package com.anfelisa.category.model;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.category.models.UserAccessToCategoryMapper;

public class CustomUserAccessToCategoryDao {

	public IUserAccessToCategoryModel selectByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		return handle.createQuery(
				"SELECT categoryid, userid FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper()).first();
	}

}
