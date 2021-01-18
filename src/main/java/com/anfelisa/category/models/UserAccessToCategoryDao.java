package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.category.data.IUserToCategoryInvitationData;

import de.acegen.PersistenceHandle;

public class UserAccessToCategoryDao extends AbstractUserAccessToCategoryDao {

	public IUserAccessToCategoryModel selectByCategoryIdAndUserId(PersistenceHandle handle, String categoryId,
			String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.getHandle().createQuery(
				"SELECT categoryid, userid, editable FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IUserAccessToCategoryModel> selectByUserId(PersistenceHandle handle, String userId) {
		return handle.getHandle().createQuery("SELECT categoryid, userid, editable FROM useraccesstocategory where userid = :userid")
				.bind("userid", userId)
				.map(new UserAccessToCategoryMapper())
				.list();
	}

	public List<IUserWithAccessModel> selectByCategoryId(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery(
				"SELECT a.userid, u.username, a.editable FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid order by u.username")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}

	public List<IUserWithAccessModel> selectByCategoryIdWhereEditable(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery(
				"SELECT a.userid, u.username, a.editable FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid and editable = true order by u.username")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}

	public void deleteByCategoryIdAndUserId(PersistenceHandle handle, String categoryId, String userId) {
		Update statement = handle.getHandle().createUpdate(
				"DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid and userid = :userid");
		statement.bind("categoryid", categoryId);
		statement.bind("userid", userId);
		statement.execute();
	}

	public void deleteByCategoryId(PersistenceHandle handle, String categoryId) {
		Update statement = handle.getHandle().createUpdate(
				"DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}

	public IUserAccessToCategoryModel hasUserAccessTo(PersistenceHandle handle, String categoryId, String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.getHandle()
				.createQuery("SELECT uc.categoryid, uc.userid, uc.editable "
						+ "from public.useraccesstocategory uc "
						+ "where uc.categoryid = (select c.rootcategoryid from public.category c where c.categoryid = :categoryid ) "
						+ "and uc.userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId)
				.map(new UserAccessToCategoryMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;

	}

	public void invite(PersistenceHandle handle, IUserToCategoryInvitationData userAccessToCategoryModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"useraccesstocategory\" (categoryid, userid, editable) VALUES (:categoryid, :userid, false)");
		statement.bind("categoryid",  userAccessToCategoryModel.getCategoryId() );
		statement.bind("userid",  userAccessToCategoryModel.getInvitedUserId() );
		statement.execute();
	}

	public List<String> selectAllInvitedUsernames(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery("SELECT username FROM public.user u, useraccesstocategory uac where categoryid = :categoryid and uac.userid = u.userid and uac.editable = false")
				.bind("categoryid", categoryId).mapTo(String.class).list();
		
	}
	

}

/* S.D.G. */
