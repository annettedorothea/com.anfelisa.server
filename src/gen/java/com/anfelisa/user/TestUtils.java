package com.anfelisa.user;

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
	
	public static Response callGetUserProfile(
			String uuid
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/get?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callUsernameAvailable(
			String uuid, 
			String username
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/username?uuid=" + uuid + "&username=" + username, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		return builder.get();
	}
	
	public static Response callGetRole(
			String uuid
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetAllUsers(
			String uuid
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/all?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callForgotPassword(com.anfelisa.user.data.IForgotPasswordData data) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/forgot-password", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createForgotPasswordOkEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ForgotPasswordOkEvent", null, json, randomUUID());
	}
	public static TimelineItem createForgotPasswordDoesNotExistEventTimelineItem(com.anfelisa.user.data.IForgotPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ForgotPasswordDoesNotExistEvent", null, json, randomUUID());
	}
	public static Response callResetPassword(
			com.anfelisa.user.data.IResetPasswordWithNewPasswordData data, 
			String uuid
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/resetpassword?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createResetPasswordOkEventTimelineItem(com.anfelisa.user.data.IResetPasswordWithNewPasswordData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ResetPasswordOkEvent", null, json, randomUUID());
	}
	public static Response callRegisterUser(com.anfelisa.user.data.IUserRegistrationData data) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/register", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createRegisterUserOkEventTimelineItem(com.anfelisa.user.data.IUserRegistrationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.RegisterUserOkEvent", null, json, randomUUID());
	}
	public static Response callConfirmEmail(
			com.anfelisa.user.data.IConfirmEmailData data, 
			String uuid
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/confirm?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createConfirmEmailOkEventTimelineItem(com.anfelisa.user.data.IConfirmEmailData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ConfirmEmailOkEvent", null, json, randomUUID());
	}
	public static TimelineItem createConfirmEmailAlreadyConfirmedEventTimelineItem(com.anfelisa.user.data.IConfirmEmailData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ConfirmEmailAlreadyConfirmedEvent", null, json, randomUUID());
	}
	public static Response callChangeUserRole(
			com.anfelisa.user.data.IChangeUserRoleData data, 
			String uuid
			, String authorization
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createChangeUserRoleOkEventTimelineItem(com.anfelisa.user.data.IChangeUserRoleData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.ChangeUserRoleOkEvent", null, json, randomUUID());
	}
	public static Response callDeleteUser(
			String uuid, 
			String usernameToBeDeleted
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/delete?uuid=" + uuid + "&usernameToBeDeleted=" + usernameToBeDeleted, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static TimelineItem createDeleteUserOkEventTimelineItem(com.anfelisa.user.data.IDeleteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.user.events.DeleteUserOkEvent", null, json, randomUUID());
	}
	
	public static void assertEquals(com.anfelisa.user.models.IUserModel actual, com.anfelisa.user.models.IUserModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getUsername(), is(expected.getUsername()));
		assertThat(actual.getPassword(), is(expected.getPassword()));
		assertThat(actual.getEmail(), is(expected.getEmail()));
		assertThat(actual.getRole(), is(expected.getRole()));
		assertThat(actual.getEmailConfirmed(), is(expected.getEmailConfirmed()));
	}
	public static void assertEquals(com.anfelisa.user.models.IEmailConfirmationModel actual, com.anfelisa.user.models.IEmailConfirmationModel expected) {
		assertThat(actual.getToken(), is(expected.getToken()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.user.models.IResetPasswordModel actual, com.anfelisa.user.models.IResetPasswordModel expected) {
		assertThat(actual.getToken(), is(expected.getToken()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.user.models.IRoleModel actual, com.anfelisa.user.models.IRoleModel expected) {
		assertThat(actual.getUsername(), is(expected.getUsername()));
		assertThat(actual.getRole(), is(expected.getRole()));
	}
	public static void assertEquals(com.anfelisa.user.models.IDeleteUserModel actual, com.anfelisa.user.models.IDeleteUserModel expected) {
		assertThat(actual.getUsernameToBeDeleted(), is(expected.getUsernameToBeDeleted()));
		assertThat(actual.getUsername(), is(expected.getUsername()));
		assertThat(actual.getRole(), is(expected.getRole()));
	}
	public static void assertEquals(com.anfelisa.user.models.IUserListModel actual, com.anfelisa.user.models.IUserListModel expected) {
		assertThat(actual.getRole(), is(expected.getRole()));
	}
	public static void assertEquals(com.anfelisa.user.models.IChangeUserRoleModel actual, com.anfelisa.user.models.IChangeUserRoleModel expected) {
		assertThat(actual.getEditedUserId(), is(expected.getEditedUserId()));
		assertThat(actual.getNewRole(), is(expected.getNewRole()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getRole(), is(expected.getRole()));
	}
	public static void assertEquals(com.anfelisa.user.models.IUsernameAvailableModel actual, com.anfelisa.user.models.IUsernameAvailableModel expected) {
		assertThat(actual.getUsername(), is(expected.getUsername()));
		assertThat(actual.getAvailable(), is(expected.getAvailable()));
	}
	public static void assertEquals(com.anfelisa.user.models.IForgotPasswordModel actual, com.anfelisa.user.models.IForgotPasswordModel expected) {
		assertThat(actual.getLanguage(), is(expected.getLanguage()));
		assertThat(actual.getEmail(), is(expected.getEmail()));
		assertThat(actual.getUsername(), is(expected.getUsername()));
	}
	public static void assertEquals(com.anfelisa.user.models.IResetPasswordWithNewPasswordModel actual, com.anfelisa.user.models.IResetPasswordWithNewPasswordModel expected) {
		assertThat(actual.getPassword(), is(expected.getPassword()));
	}
	public static void assertEquals(com.anfelisa.user.models.IUserRegistrationModel actual, com.anfelisa.user.models.IUserRegistrationModel expected) {
		assertThat(actual.getLanguage(), is(expected.getLanguage()));
	}
	public static void assertEquals(com.anfelisa.user.models.IConfirmEmailModel actual, com.anfelisa.user.models.IConfirmEmailModel expected) {
		assertThat(actual.getUsername(), is(expected.getUsername()));
	}

}

