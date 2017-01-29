package com.anfelisa.migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.AddCourseToBoxAction;
import com.anfelisa.box.actions.CreateBoxAction;
import com.anfelisa.box.actions.CreateCardAction;
import com.anfelisa.box.actions.CreateScheduledCardAction;
import com.anfelisa.box.actions.CreateScoredCardAction;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.ScheduledCardData;
import com.anfelisa.box.data.ScoredCardData;
import com.anfelisa.course.actions.AddStudentToCourseAction;
import com.anfelisa.course.actions.CreateCourseAction;
import com.anfelisa.course.data.CourseCreationData;
import com.anfelisa.course.data.StudentToCourseAdditionData;
import com.anfelisa.lesson.actions.CreateLessonAction;
import com.anfelisa.lesson.data.LessonCreationData;
import com.anfelisa.result.actions.CreateResultAction;
import com.anfelisa.result.data.ResultCreationData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.actions.CreateTestAction;
import com.anfelisa.test.data.TestCreationData;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.actions.CreateUserAction;
import com.anfelisa.user.data.UserCreationData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/migrate")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class MigrationResource {

	static final Logger LOG = LoggerFactory.getLogger(MigrationResource.class);

	private DBI jdbi;

	private ResultDao resultDao = new ResultDao();

	private TestDao testDao = new TestDao();

	private UserDao userDao = new UserDao();

	public MigrationResource(DBI jdbi) {
		this.jdbi = jdbi;
	}

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
	public Response migrateUsers(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.user";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = "annette_pohl@web.de";
				String name = rs.getString("lastname");
				String prename = rs.getString("firstname");
				String role = "STUDENT";
				if (username.equals("annette")) {
					role = "ADMIN";
					username = "Annette";
				}
				String uuid = UUID.randomUUID().toString();
				UserCreationData userCreationData = new UserCreationData(username, password, name, prename, email, role,
						true, uuid, schema);
				new CreateUserAction(jdbi).applyWithActionData(userCreationData);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration users", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/courses")
	public Response migrateCourses(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.course";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer sequence = rs.getInt("sequence");
				String name = rs.getString("name");
				boolean isPublic = rs.getBoolean("public");
				String uuid = UUID.randomUUID().toString();
				CourseCreationData courseCreationData = new CourseCreationData(id, name, "", sequence, isPublic,
						"Annette", uuid, schema);
				new CreateCourseAction(jdbi).applyWithActionData(courseCreationData);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration courses", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/lessons")
	public Response migrateLessons(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.lesson";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer sequence = rs.getInt("sequence");
				Integer courseId = rs.getInt("course_id");
				String name = rs.getString("name");
				String uuid = UUID.randomUUID().toString();
				LessonCreationData lessonCreationData = new LessonCreationData(id, name, "", sequence, courseId,
						"Annette", uuid, schema);
				new CreateLessonAction(jdbi).applyWithActionData(lessonCreationData);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration lessons", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/tests")
	public Response migrateTests(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.test";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer sequence = rs.getInt("sequence");
				Integer lessonId = rs.getInt("lesson_id");
				String name = rs.getString("name");
				String html = rs.getString("html");
				String uuid = UUID.randomUUID().toString();
				TestCreationData testCreationData = new TestCreationData(id, name, sequence, lessonId, html, "Annette",
						uuid, schema);
				new CreateTestAction(jdbi).applyWithActionData(testCreationData);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration tests", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/results")
	public Response migrateResults(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		Handle handle = jdbi.open();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.result";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				if (username.equals("annette")) {
					username = "Annette";
				}
				Integer testId = rs.getInt("test_id");
				if (testId != null) {
					ITestModel test = testDao.selectByTestId(handle, testId, schema);
					IResultModel result = resultDao.selectByResultId(handle, id, schema);
					IUserModel user = userDao.selectByUsername(handle, username, schema);
					if (result == null && test != null && user != null) {
						DateTime date = new DateTime(rs.getDate("date"));
						String json = rs.getString("json");
						Integer points = rs.getInt("points");
						Integer maxPoints = rs.getInt("max_points");
						String uuid = UUID.randomUUID().toString();
						ResultCreationData resultCreationData = new ResultCreationData(id, username, testId, date, json,
								points, maxPoints, uuid, schema);
						new CreateResultAction(jdbi).applyWithActionData(resultCreationData);
					}
				}
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration results", e);
			throw new WebApplicationException(e);
		}

		handle.close();
		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/boxes")
	public Response migrateBoxes(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.box_of_student";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String student = rs.getString("student");
				if (student.equals("annette")) {
					student = "Annette";
				}
				String uuid = UUID.randomUUID().toString();
				BoxCreationData boxCreationData = new BoxCreationData(id, name, student, student, AuthUser.STUDENT,
						uuid, schema);
				new CreateBoxAction(this.jdbi).applyWithActionData(boxCreationData);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration boxes", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/studentofcourse")
	public Response migrateStudentOfCourse(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.students_of_courses";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer courseId = rs.getInt("course_id");
				String username = rs.getString("username");
				if (username.equals("annette")) {
					username = "Annette";
				}
				String uuid = UUID.randomUUID().toString();
				StudentToCourseAdditionData data = new StudentToCourseAdditionData(username, courseId, username,
						AuthUser.STUDENT, uuid, schema);
				new AddStudentToCourseAction(jdbi).applyWithActionData(data);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration students_of_courses", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/boxofcourse")
	public Response migrateBoxOfCourse(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.add_all_cards_of_course_after_edit_to_box";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer boxId = rs.getInt("box_id");
				Integer courseId = rs.getInt("course_id");
				String uuid = UUID.randomUUID().toString();
				BoxToCourseAdditionData data = new BoxToCourseAdditionData(boxId, courseId, false, "Annette",
						AuthUser.ADMIN, uuid, schema);
				new AddCourseToBoxAction(jdbi).applyWithActionData(data);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration add_all_cards_of_course_after_edit_to_box", e);
			throw new WebApplicationException(e);
		}

		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.add_all_cards_of_course_automatically_to_box";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer boxId = rs.getInt("box_id");
				Integer courseId = rs.getInt("course_id");
				String uuid = UUID.randomUUID().toString();
				BoxToCourseAdditionData data = new BoxToCourseAdditionData(boxId, courseId, true, "Annette",
						AuthUser.ADMIN, uuid, schema);
				new AddCourseToBoxAction(jdbi).applyWithActionData(data);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration add_all_cards_of_course_automatically_to_box", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/cards")
	public Response migrateCards(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.card";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String content = rs.getString("content");
				Integer testId = rs.getInt("test_id");
				String contentHash = rs.getString("content_hash");
				Integer maxPoints = rs.getInt("max_points");
				String uuid = UUID.randomUUID().toString();
				CardCreationData data = new CardCreationData(id, content, testId, contentHash, maxPoints, uuid, schema);
				new CreateCardAction(jdbi).applyWithActionData(data);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration students_of_courses", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	@POST
	@Timed
	@Path("/cardofbox")
	public Response migrateCardOfBox(@NotEmpty String schema) throws JsonProcessingException {
		Connection connection = this.openConnection();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM anfelisa.card_of_box order by box_id, card_id, id";
			ResultSet rs = stmt.executeQuery(sql);
			Integer currentBoxId = -1;
			Integer currentCardId = -1;
			List<CardOfBox> cards = new ArrayList<MigrationResource.CardOfBox>();
			while (rs.next()) {
				Integer cardId = rs.getInt("card_id");
				Float ef = rs.getFloat("ef");
				Integer interval = rs.getInt("interval");
				Integer n = rs.getInt("n");
				Integer count = rs.getInt("count");
				DateTime next = null;
				if (rs.getDate("next") != null) {
					next = new DateTime(rs.getDate("next"));
				}
				Integer boxId = rs.getInt("box_id");
				Integer quality = rs.getInt("quality");
				DateTime timestamp = null;
				if (rs.getDate("timestamp") != null) {
					timestamp = new DateTime(rs.getDate("timestamp"));
				}
				Integer points = rs.getInt("points");

				if (currentBoxId == -1) {
					currentBoxId = boxId;
				}
				if (currentCardId == -1) {
					currentCardId = cardId;
				}
				if (!(currentBoxId.equals(boxId) && currentCardId.equals(cardId))) {
					String uuid = UUID.randomUUID().toString();
					CardOfBox lastCard = cards.get(cards.size() - 1);
					CardOfBox cardBeforeLastCard = null;
					if (cards.size() > 1) {
						cardBeforeLastCard = cards.get(cards.size() - 2);
					}
					ScheduledCardData scheduledCardData = new ScheduledCardData(uuid, schema).withBoxId(lastCard.boxId)
							.withCardId(lastCard.cardId).withCount(lastCard.count).withEf(lastCard.ef)
							.withInterval(lastCard.interval).withN(lastCard.n);
					if (lastCard.timestamp != null) {
						scheduledCardData.setTimestamp(lastCard.timestamp);
					} else {
						scheduledCardData.setTimestamp(new DateTime().minusYears(1));
					}
					if (lastCard.next != null) {
						scheduledCardData.setScheduledDate(lastCard.next);
					} else {
						scheduledCardData.setScheduledDate(new DateTime().minusYears(1));
					}
					if (cardBeforeLastCard != null) {
						scheduledCardData.setLastQuality(cardBeforeLastCard.quality);
					}
					Response response = new CreateScheduledCardAction(jdbi).applyWithActionData(scheduledCardData);
					Integer scheduledCardId = Integer.parseInt(response.getEntity().toString());
					if (cards.size() > 1) {
						for (int i = 1; i < cards.size(); i++) {
							CardOfBox card = cards.get(i);
							CardOfBox previousCard = cards.get(i - 1);
							uuid = UUID.randomUUID().toString();
							ScoredCardData scoredCardData = new ScoredCardData(uuid, schema).withBoxId(card.boxId)
									.withCardId(card.cardId).withPoints(card.points).withQuality(card.quality)
									.withScheduledCardId(scheduledCardId).withScheduledDateOfScored(previousCard.next)
									.withTimestamp(card.timestamp);
							scoredCardData.setScheduledCardId(scheduledCardId);
							response = new CreateScoredCardAction(jdbi).applyWithActionData(scoredCardData);
						}
					}
					cards.clear();
				}
				currentCardId = cardId;
				currentBoxId = boxId;

				CardOfBox card = new CardOfBox(cardId, ef, interval, n, count, next, boxId, quality, timestamp, points);
				cards.add(card);
			}
			rs.close();
		} catch (SQLException e) {
			LOG.error("error when migration card_of_box", e);
			throw new WebApplicationException(e);
		}

		closeConnection(connection);
		return Response.ok().build();
	}

	private class CardOfBox {
		private Integer cardId;
		private Float ef;
		private Integer interval;
		private Integer n;
		private Integer count;
		private DateTime next;
		private Integer boxId;
		private Integer quality;
		private DateTime timestamp;
		private Integer points;

		public CardOfBox(Integer cardId, Float ef, Integer interval, Integer n, Integer count, DateTime next,
				Integer boxId, Integer quality, DateTime timestamp, Integer points) {
			super();
			this.cardId = cardId;
			this.ef = ef;
			this.interval = interval;
			this.n = n;
			this.count = count;
			this.next = next;
			this.boxId = boxId;
			this.quality = quality;
			this.timestamp = timestamp;
			this.points = points;
		}

	}

}
