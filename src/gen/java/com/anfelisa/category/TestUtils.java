package com.anfelisa.category;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.MockitoAnnotations;

import com.anfelisa.ace.App;
import com.anfelisa.ace.AbstractBaseTest;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.DropwizardTestSupport;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@SuppressWarnings("unused")
public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();

	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static Response callCreateCategory(com.anfelisa.category.data.ICategoryCreationData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/create", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createCreateCategorySubEventTimelineItem(com.anfelisa.category.data.ICategoryCreationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.CreateCategorySubEvent", null, json, randomUUID());
	}
	public static TimelineItem createCreateCategoryRootEventTimelineItem(com.anfelisa.category.data.ICategoryCreationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.CreateCategoryRootEvent", null, json, randomUUID());
	}
	public static Response callUpdateCategory(
			com.anfelisa.category.data.ICategoryUpdateData data, 
			String uuid
			, String authorization
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/update?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createUpdateCategoryOkEventTimelineItem(com.anfelisa.category.data.ICategoryUpdateData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.UpdateCategoryOkEvent", null, json, randomUUID());
	}
	public static Response callDeleteCategory(
			String uuid, 
			String categoryId
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/delete?uuid=" + uuid + "&categoryId=" + categoryId, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static TimelineItem createDeleteCategoryNoRootEventTimelineItem(com.anfelisa.category.data.ICategoryDeleteData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.DeleteCategoryNoRootEvent", null, json, randomUUID());
	}
	public static TimelineItem createDeleteCategoryRootEventTimelineItem(com.anfelisa.category.data.ICategoryDeleteData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.DeleteCategoryRootEvent", null, json, randomUUID());
	}
	public static Response callInviteUser(com.anfelisa.category.data.IInviteUserData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/invite", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createInviteUserOkEventTimelineItem(com.anfelisa.category.data.IInviteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.InviteUserOkEvent", null, json, randomUUID());
	}
	public static TimelineItem createInviteUserHasAccessEventTimelineItem(com.anfelisa.category.data.IInviteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.InviteUserHasAccessEvent", null, json, randomUUID());
	}
	public static Response callRevokeUserAccess(
			String uuid, 
			String revokedUserId, String categoryId
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/revoke?uuid=" + uuid + "&revokedUserId=" + revokedUserId + "&categoryId=" + categoryId, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static TimelineItem createRevokeUserAccessOkEventTimelineItem(com.anfelisa.category.data.IRevokeUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.RevokeUserAccessOkEvent", null, json, randomUUID());
	}
	public static TimelineItem createRevokeUserAccessHasNoAccessEventTimelineItem(com.anfelisa.category.data.IRevokeUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.RevokeUserAccessHasNoAccessEvent", null, json, randomUUID());
	}
	public static Response callGetUsersWithAccess(
			String uuid, 
			String categoryId
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/users?uuid=" + uuid + "&categoryId=" + categoryId, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetCategoryTree(
			String uuid
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/tree?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCategory(
			com.anfelisa.category.data.ICategoryMoveData data, 
			String uuid
			, String authorization
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/move?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createMoveCategoryOkEventTimelineItem(com.anfelisa.category.data.ICategoryMoveData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.MoveCategoryOkEvent", null, json, randomUUID());
	}
	public static TimelineItem createMoveCategoryNoMoveEventTimelineItem(com.anfelisa.category.data.ICategoryMoveData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.MoveCategoryNoMoveEvent", null, json, randomUUID());
	}
	
	public static void assertEquals(com.anfelisa.category.models.ICategoryModel actual, com.anfelisa.category.models.ICategoryModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
		assertThat(actual.getCategoryAuthor(), is(expected.getCategoryAuthor()));
		assertThat(actual.getCategoryIndex(), is(expected.getCategoryIndex()));
		assertThat(actual.getParentCategoryId(), is(expected.getParentCategoryId()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
		assertThat(actual.getDictionaryLookup(), is(expected.getDictionaryLookup()));
		assertThat(actual.getGivenLanguage(), is(expected.getGivenLanguage()));
		assertThat(actual.getWantedLanguage(), is(expected.getWantedLanguage()));
		assertThat(actual.getPublicRootCategory(), is(expected.getPublicRootCategory()));
	}
	public static void assertEquals(com.anfelisa.category.models.IUserAccessToCategoryModel actual, com.anfelisa.category.models.IUserAccessToCategoryModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryUpdateModel actual, com.anfelisa.category.models.ICategoryUpdateModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
		assertThat(actual.getDictionaryLookup(), is(expected.getDictionaryLookup()));
		assertThat(actual.getGivenLanguage(), is(expected.getGivenLanguage()));
		assertThat(actual.getWantedLanguage(), is(expected.getWantedLanguage()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryDeleteModel actual, com.anfelisa.category.models.ICategoryDeleteModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getCategoryIndex(), is(expected.getCategoryIndex()));
		assertThat(actual.getParentCategoryId(), is(expected.getParentCategoryId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryTreeModel actual, com.anfelisa.category.models.ICategoryTreeModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryTreeItemModel actual, com.anfelisa.category.models.ICategoryTreeItemModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
		assertThat(actual.getCategoryIndex(), is(expected.getCategoryIndex()));
		assertThat(actual.getEmpty(), is(expected.getEmpty()));
		assertThat(actual.getEditable(), is(expected.getEditable()));
		assertThat(actual.getHasBox(), is(expected.getHasBox()));
		assertThat(actual.getParentCategoryId(), is(expected.getParentCategoryId()));
		assertThat(actual.getDictionaryLookup(), is(expected.getDictionaryLookup()));
		assertThat(actual.getGivenLanguage(), is(expected.getGivenLanguage()));
		assertThat(actual.getWantedLanguage(), is(expected.getWantedLanguage()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryTreeRootItemModel actual, com.anfelisa.category.models.ICategoryTreeRootItemModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
		assertThat(actual.getCategoryIndex(), is(expected.getCategoryIndex()));
		assertThat(actual.getEmpty(), is(expected.getEmpty()));
		assertThat(actual.getEditable(), is(expected.getEditable()));
		assertThat(actual.getHasBox(), is(expected.getHasBox()));
		assertThat(actual.getDictionaryLookup(), is(expected.getDictionaryLookup()));
		assertThat(actual.getGivenLanguage(), is(expected.getGivenLanguage()));
		assertThat(actual.getWantedLanguage(), is(expected.getWantedLanguage()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
	}
	public static void assertEquals(com.anfelisa.category.models.IUserWithAccessListModel actual, com.anfelisa.category.models.IUserWithAccessListModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
	}
	public static void assertEquals(com.anfelisa.category.models.IUserWithAccessModel actual, com.anfelisa.category.models.IUserWithAccessModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getUsername(), is(expected.getUsername()));
	}
	public static void assertEquals(com.anfelisa.category.models.IInviteUserModel actual, com.anfelisa.category.models.IInviteUserModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
		assertThat(actual.getInvitedUserId(), is(expected.getInvitedUserId()));
		assertThat(actual.getInvitedUsername(), is(expected.getInvitedUsername()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.IRevokeUserModel actual, com.anfelisa.category.models.IRevokeUserModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
		assertThat(actual.getRevokedUserId(), is(expected.getRevokedUserId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryCreationModel actual, com.anfelisa.category.models.ICategoryCreationModel expected) {
		assertThat(actual.getUsername(), is(expected.getUsername()));
	}
	public static void assertEquals(com.anfelisa.category.models.ICategoryMoveModel actual, com.anfelisa.category.models.ICategoryMoveModel expected) {
		assertThat(actual.getMovedCategoryId(), is(expected.getMovedCategoryId()));
		assertThat(actual.getTargetCategoryId(), is(expected.getTargetCategoryId()));
		assertThat(actual.getCategoryIndexWhereRemoved(), is(expected.getCategoryIndexWhereRemoved()));
		assertThat(actual.getParentCategoryIdWhereRemoved(), is(expected.getParentCategoryIdWhereRemoved()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}

}
