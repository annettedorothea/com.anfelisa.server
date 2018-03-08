package com.anfelisa.ace;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceDao;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.auth.AuthUser;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public String getName() {
		return "anfelisa";
	}

	public static String getVersion() {
		return "3.0.0";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		
		bootstrap.addCommand(new EventReplayCommand(this));
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());

		AceDao.setSchemaName(null);

		final DBIFactory factory = new DBIFactory();

		DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");

		if (ServerConfiguration.REPLAY.equals(configuration.getServerConfiguration().getMode())) {
			AceController.setAceExecutionMode(AceExecutionMode.REPLAY);
			environment.jersey().register(new PrepareE2EResource(jdbi));
			environment.jersey().register(new StartE2ESessionResource(jdbi));
			environment.jersey().register(new StopE2ESessionResource());
			environment.jersey().register(new GetServerTimelineResource(jdbi));
		} else if (ServerConfiguration.DEV.equals(configuration.getServerConfiguration().getMode())) {
			AceController.setAceExecutionMode(AceExecutionMode.DEV);
			environment.jersey().register(new GetServerTimelineResource(jdbi));
		} else {
			AceController.setAceExecutionMode(AceExecutionMode.LIVE);
		}

		environment.jersey().register(new GetServerInfoResource());

		DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		com.anfelisa.user.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.user.AppRegistration.registerConsumers();

		com.anfelisa.course.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.course.AppRegistration.registerConsumers();

		com.anfelisa.lesson.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.lesson.AppRegistration.registerConsumers();

		com.anfelisa.test.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.test.AppRegistration.registerConsumers();

		com.anfelisa.result.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.result.AppRegistration.registerConsumers();

		com.anfelisa.box.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.box.AppRegistration.registerConsumers();

	}

}
