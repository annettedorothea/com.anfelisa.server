package com.anfelisa;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.auth.AceAuthenticator;
import com.anfelisa.auth.AceAuthorizer;
import com.anfelisa.auth.AuthUser;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
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
	
	public String getVersion() {
		return "1.2.0";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());
		
		final DBIFactory factory = new DBIFactory();

		DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
		DBI jdbiTimeline = null;

		if (configuration.getTimelineDataSourceFactory().getUrl() != null) {
			AceController.setAceExecutionMode(AceExecutionMode.E2E);
			jdbiTimeline = factory.build(environment, configuration.getTimelineDataSourceFactory(),
					"anfelisa_replay");
			//environment.jersey().register(new ClearDatabaseResource(jdbi));
			//environment.jersey().register(new PrepareDatabaseResource(jdbi, jdbiTimeline));
		} else {
			AceController.setAceExecutionMode(AceExecutionMode.LIVE);
		}

		DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		EmailService.setEmailConfiguration(configuration.getEmail());

		environment.jersey().register(new AuthDynamicFeature(
	            new BasicCredentialAuthFilter.Builder<AuthUser>()
	                .setAuthenticator(new AceAuthenticator(jdbi))
	                .setAuthorizer(new AceAuthorizer())
	                .setPrefix("anfelisaBasic")
	                .setRealm("anfelisa private realm")
	                .buildAuthFilter()));
	    environment.jersey().register(RolesAllowedDynamicFeature.class);
	    environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		com.anfelisa.user.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.user.AppRegistration.registerConsumers();

		com.anfelisa.course.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.course.AppRegistration.registerConsumers();

		com.anfelisa.lesson.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.lesson.AppRegistration.registerConsumers();

		com.anfelisa.test.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.test.AppRegistration.registerConsumers();

		com.anfelisa.result.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.result.AppRegistration.registerConsumers();

		com.anfelisa.box.AppRegistration.registerResources(environment, jdbi, jdbiTimeline);
		com.anfelisa.box.AppRegistration.registerConsumers();

	}

}