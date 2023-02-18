package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import de.acegen.PersistenceHandle;

public class UserAccessToCategoryDao extends AbstractUserAccessToCategoryDao {

	public UserAccessToCategoryModel selectByCategoryIdAndUserId(PersistenceHandle handle, String categoryId,
			String userId) {
		Optional<UserAccessToCategoryModel> optional = handle.getHandle().createQuery(
				"SELECT categoryid, userid, editable FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<UserAccessToCategoryModel> selectByUserId(PersistenceHandle handle, String userId) {
		return handle.getHandle().createQuery("SELECT categoryid, userid, editable FROM useraccesstocategory where userid = :userid")
				.bind("userid", userId)
				.map(new UserAccessToCategoryMapper())
				.list();
	}

	public List<UserAccessToCategoryModel> selectByCategoryIdAndNotMine(PersistenceHandle handle, String categoryId, String userId) {
		return handle.getHandle().createQuery(
				"SELECT categoryid, userid, editable FROM public.useraccesstocategory where categoryid = :categoryid and userid != :userid")
				.bind("categoryid", categoryId)
				.bind("userid", userId)
				.map(new UserAccessToCategoryMapper()).list();
	}
	
	public List<UserWithAccessModel> selectByCategoryIdWhereEditable(PersistenceHandle handle, String categoryId) {
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

	public UserAccessToCategoryModel hasUserAccessTo(PersistenceHandle handle, String categoryId, String userId) {
		Optional<UserAccessToCategoryModel> optional = handle.getHandle()
				.createQuery("SELECT uc.categoryid, uc.userid, uc.editable "
						+ "from public.useraccesstocategory uc "
						+ "where uc.categoryid = (select c.rootcategoryid from public.category c where c.categoryid = :categoryid ) "
						+ "and uc.userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId)
				.map(new UserAccessToCategoryMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;

	}

	public void invite(PersistenceHandle handle, UserToCategoryInvitationModel userAccessToCategoryModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"useraccesstocategory\" (categoryid, userid, editable) VALUES (:categoryid, :userid, :editable)");
		statement.bind("categoryid",  userAccessToCategoryModel.getCategoryId() );
		statement.bind("userid",  userAccessToCategoryModel.getInvitedUserId() );
		statement.bind("editable",  userAccessToCategoryModel.getEditable() );
		statement.execute();
	}

	public List<UsernameEditableModel> selectAllInvitedUsers(PersistenceHandle handle, String categoryId, String userId) {
		return handle.getHandle().createQuery("SELECT username as invitedusername, editable "
				+ "FROM public.user u, useraccesstocategory uac where categoryid = :categoryid and uac.userid = u.userid and uac.userid != :userid "
				+ "order by username")
				.bind("userid", userId)
				.bind("categoryid", categoryId)
				.map(new UsernameEditableMapper()).list();
		
	}

	public void changeEditable(PersistenceHandle handle, UserToCategoryInvitationModel userAccessToCategoryModel) {
		Update statement = handle.getHandle().createUpdate("Update \"useraccesstocategory\" set editable = :editable where categoryid = :categoryid and userid = :userid");
		statement.bind("categoryid",  userAccessToCategoryModel.getCategoryId() );
		statement.bind("userid",  userAccessToCategoryModel.getInvitedUserId() );
		statement.bind("editable",  userAccessToCategoryModel.getEditable() );
		statement.execute();
	}
	

}

/* S.D.G. */
