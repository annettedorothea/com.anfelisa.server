package com.anfelisa.category.model;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.category.models.IUserWithAccessModel;
import com.anfelisa.category.models.UserAccessToCategoryMapper;
import com.anfelisa.category.models.UserWithAccessMapper;

public class CustomUserAccessToCategoryDao {

	public IUserAccessToCategoryModel selectByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		return handle.createQuery(
				"SELECT categoryid, userid FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper()).first();
	}

	public List<IUserWithAccessModel> selectByCategoryId(Handle handle, String categoryId) {
		return handle
				.createQuery(
						"SELECT a.userid, u.username FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}

	public void deleteByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		Update statement = handle.createStatement("DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid and userid = :userid");
		statement.bind("categoryid", categoryId);
		statement.bind("userid", userId);;
		statement.execute();
	}

}
