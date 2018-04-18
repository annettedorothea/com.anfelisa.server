package com.anfelisa.ace;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AceAuthenticator;
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

public class App extends Application<CustomAppConfiguration> {

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
	public void initialize(Bootstrap<CustomAppConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<CustomAppConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(CustomAppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});

		bootstrap.addCommand(new EventReplayCommand(this));
	}

	@Override
	public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());

		AceDao.setSchemaName(null);
		
		EmailService.setEmailConfiguration(configuration.getEmail());

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

		environment.jersey()
				.register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<AuthUser>()
						.setAuthenticator(new AceAuthenticator(jdbi)).setPrefix("anfelisaBasic")
						.setRealm("anfelisaBasic private realm").buildAuthFilter()));
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		environment.jersey().register(RolesAllowedDynamicFeature.class);

		configureCors(environment);

		com.anfelisa.user.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.user.AppRegistration.registerConsumers();

		com.anfelisa.box.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.box.AppRegistration.registerConsumers();

	}

	private void configureCors(Environment environment) {
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
				"X-Requested-With,Content-Type,Accept,Origin,Authorization");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

	}

}
