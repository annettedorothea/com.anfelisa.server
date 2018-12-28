package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

public class UserAccessToCategoryDao extends AbstractUserAccessToCategoryDao {
	public IUserAccessToCategoryModel selectByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.createQuery(
				"SELECT categoryid, userid FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IUserWithAccessModel> selectByCategoryId(Handle handle, String categoryId) {
		return handle
				.createQuery(
						"SELECT a.userid, u.username FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid order by u.username")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}

	public void deleteByCategoryIdAndUserId(Handle handle, String categoryId, String userId) {
		Update statement = handle.createUpdate("DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid and userid = :userid");
		statement.bind("categoryid", categoryId);
		statement.bind("userid", userId);;
		statement.execute();
	}

}


/*       S.D.G.       */
