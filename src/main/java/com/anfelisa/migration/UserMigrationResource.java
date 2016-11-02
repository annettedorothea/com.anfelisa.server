package com.anfelisa.migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.setup.data.SetupData;
import com.anfelisa.user.actions.CreateUserAction;
import com.anfelisa.user.data.UserCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/migrate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserMigrationResource {

	static final Logger LOG = LoggerFactory.getLogger(UserMigrationResource.class);

	private Connection openConnection() {
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			LOG.error("missing PostgreSQL JDBC Driver", e);
			throw new WebApplicationException(e);
		}

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					String.format("jdbc:postgresql://%s:5432/%s", "sql360.your-server.de", "anfeli_db2"), "anfeli_2",
					"r2ZyJ7gbCc6nbuaW");
		} catch (SQLException e) {
			LOG.error("missing PostgreSQL JDBC Driver", e);
			throw new WebApplicationException(e);
		}

		LOG.info("connection established");
		return connection;
	}

	private void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			LOG.error("cannot close database connection", e);
			throw new WebApplicationException(e);
		}
	}

	@POST
	@Timed
	@Path("/users")
	public Response post() throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.user";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String name = rs.getString("lastname");
				String prename = rs.getString("firstname");
				String role = "STUDENT";
				String uuid = UUID.randomUUID().toString();
				UserCreationData userCreationData = new UserCreationData(null, username, password, name, prename, email,
						role, uuid);
				new CreateUserAction(userCreationData, DatabaseService.getDatabaseHandle()).apply();
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration users", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

}
